package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.mapper.ChannelTypeMapper;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.mapper.LunBoFromMapper;
import com.readyidu.model.*;
import com.readyidu.service.*;
import com.readyidu.tools.JsonFileTool;
import com.readyidu.tools.QiNiuUploadTool;
import com.readyidu.tools.WebHttpTool;
import com.readyidu.util.JsonResult;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * 2017/6/20
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/webChannel")
public class WebChannelController {
    private static final Logger logger = LoggerFactory.getLogger(WebChannelController.class);
    private static final String zipName = "playChannel";

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "cacheService")
    private CacheService cacheService;

    @Resource(name = "channelSourceService")
    private ChannelSourceService channelSourceService;

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private LunBoFromMapper lunBoFromMapper;

    @Autowired
    private ChannelTypeMapper channelTypeMapper;

    @Autowired
    private ConfInfoMapper confInfoMapper;

    @RequestMapping(value = "/upLoadChannelList", method = RequestMethod.GET)
    @ResponseBody
    public String upLoadChannelList(String version){
        Map<String, Object> dataJson = new HashMap<>();
        List<Channel> channelList = channelMapper.selectWithoutSource();
//        List<DemandChannel> movieList = lunBoFromMapper.selectIntoChannel();
        List<ChannelType> typeList = channelTypeMapper.selectAll();
        dataJson.put("channels", channelList);
//        dataJson.put("movieList", movieList);
        dataJson.put("typeList", typeList);
        dataJson.put("version",version);
        String json = JsonResult.toString(NetworkCode.CODE_SUCCESS, dataJson);
        String filePath = (new File("")).getAbsolutePath();
        System.out.println(filePath);
        if(JsonFileTool.createJsonFile(json,filePath,zipName)){
            if (QiNiuUploadTool.createCardImgZip(filePath,zipName)) {
                String hashCode = QiNiuUploadTool.upLoad(QiNiuUploadTool.zipPath + zipName + ".zip");
                ConfInfo confInfo = new ConfInfo();
                confInfo.setHash(hashCode);
                confInfo.setVersion(version);
                int result = confInfoMapper.updateConfinfo(confInfo);
                if (result==1){
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS,"success");
                }
            }
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL,"fail");
    }

    @RequestMapping(value = "/addChannel/{channelName}", method = RequestMethod.GET)
    @ResponseBody
    public String addChannel(@PathVariable String channelName) {
        if (channelService.addChannel(channelName) != 0) {
            cacheService.del("LIVE_SERVICE_channel_channelList");
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/addSource.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addSource(HttpServletRequest request) {
        if (channelService.updateSource(Integer.valueOf(request.getParameter("channelId")), request.getParameter("sourceUri")) != 0) {
            cacheService.del("LIVE_SERVICE_channel_channelList");
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
    @RequestMapping(value = "/modifySource.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String modifySource(HttpServletRequest request){
        String channelId = request.getParameter("channelId");//对应t_channel_source的ID
        String source = request.getParameter("source");
        String sourceId = request.getParameter("sourceId");//对应t_channel_source的parentid
        System.out.println(source);
        if(channelSourceService.modifySource(new ChannelSource(
                Integer.valueOf(channelId),
                Integer.valueOf(sourceId),
                source))!=0){
            cacheService.del("LIVE_SERVICE_channel_channelList");
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL,"");
    }
    @RequestMapping(value = "/removeSource.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String removeSource(HttpServletRequest request) {
        if (channelService.removeSource(Integer.valueOf(request.getParameter("channelId")), Integer.valueOf(request.getParameter("sourceId"))) != 0) {//ssourceId为web端同一频道的源序号
            cacheService.del("LIVE_SERVICE_channel_channelList");
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/reinstateSource.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String reinstateSource(HttpServletRequest request) {
        if (channelService.reinstateSource(Integer.valueOf(request.getParameter("channelId")), Integer.valueOf(request.getParameter("sourceId"))) != 0) {
            cacheService.del("LIVE_SERVICE_channel_channelList");
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }



    @RequestMapping(value = "/changeType.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String changeType(HttpServletRequest request) {
        if (channelService.changeType(Integer.valueOf(request.getParameter("channelId")), request.getParameter("typeId")) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/removeChannel.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String removeChannel(HttpServletRequest request) {
        if (channelService.removeChannel(Integer.valueOf(request.getParameter("channelId"))) != 0) {
            cacheService.del("LIVE_SERVICE_channel_channelList");
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/checkSource.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public synchronized String checkChannel(HttpServletRequest request) {
        String sourceUri = request.getParameter("sourceUri");
        if (TextUtils.isEmpty(sourceUri)) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }

        if (sourceUri.toLowerCase().startsWith("sourceuri")) {
            // Request
            Map<String, String> params = new HashMap<>();
            params.put("sourceUri", sourceUri);
            try {
                String result = WebHttpTool.sendPost("http://localhost:6262/source/source.do", params);
                Response response = JSON.parseObject(result, Response.class);
                if (response.getCode() == 200) {
                    return checkSource(response.getData().get("source"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            checkSource(sourceUri);
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL, sourceUri);
    }
    @RequestMapping(value = "/sortChange.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String sortChange(@RequestParam(value = "sourceList[]") int[] sourceList, int channelId, HttpServletRequest request) {
        List<ChannelSource> sources = channelSourceService.selectSourceByParentId(channelId);
        try {

            for (int index = 0; index < sources.size(); index++) {
//            System.out.println("source:"+sources[sourceList[index]]);
//            System.out.println(" ,sort:"+(index+1));
                if (sources.get(index).getSort() != sources.get(sourceList[index]).getSort()) {
//                System.out.print("changeAfter:"+sources.get(index).getSort());
//                System.out.println(",changeBefore:"+sources.get(sourceList[index]).getSort());
                    channelSourceService.updateSort(new ChannelSource(sources.get(index).getSort(), sources.get(sourceList[index]).getSource()));
                }
            }
        }catch (Exception e){
            return  JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }

        return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
    }

    private String checkSource(String sourceUri) {
        if (!TextUtils.isEmpty(sourceUri)) {
            URI uri = URI.create(sourceUri);
            if (uri.getPath().startsWith("rtmp")) {
                return JsonResult.toString(NetworkCode.CODE_SUCCESS, sourceUri);
            } else {
                try {
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS, sourceUri);
//                    InputStream liveStream = uri.toURL().openStream();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL, sourceUri);
    }

    public static class Response {
        private Integer code;
        private HashMap<String, String> data;

        public HashMap<String, String> getData() {
            return data;
        }

        public void setData(HashMap<String, String> data) {
            this.data = data;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

}
