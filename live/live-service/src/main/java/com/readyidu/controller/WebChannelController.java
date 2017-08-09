package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.service.CacheService;
import com.readyidu.service.ChannelService;
import com.readyidu.tools.WebHttpTool;
import com.readyidu.util.JsonResult;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
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

    public static class ChannelRequest {
        private Integer channelId;
        private String sourceUri;
        private Integer sourceId;
        private String typeId;

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public Integer getChannelId() {
            return channelId;
        }

        public void setChannelId(Integer channelId) {
            this.channelId = channelId;
        }

        public String getSourceUri() {
            return sourceUri;
        }

        public void setSourceUri(String sourceUri) {
            this.sourceUri = sourceUri;
        }

        public Integer getSourceId() {
            return sourceId;
        }

        public void setSourceId(Integer sourceId) {
            this.sourceId = sourceId;
        }
    }

}
