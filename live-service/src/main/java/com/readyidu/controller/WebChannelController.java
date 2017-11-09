package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.model.ChannelSource;
import com.readyidu.service.CacheService;
import com.readyidu.service.ChannelService;
import com.readyidu.service.ChannelSourceService;
import com.readyidu.tools.WebHttpTool;
import com.readyidu.util.JsonResult;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "cacheService")
    private CacheService cacheService;

    @Resource(name = "channelSourceService")
    private ChannelSourceService channelSourceService;

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
        String channelId = request.getParameter("channelId");
        String source = request.getParameter("source");
        String sourceId = request.getParameter("sourceId");
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
        if (channelService.removeSource(Integer.valueOf(request.getParameter("channelId")), Integer.valueOf(request.getParameter("sourceId"))) != 0) {
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
