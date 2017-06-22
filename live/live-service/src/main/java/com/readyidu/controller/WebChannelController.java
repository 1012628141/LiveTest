package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.service.ChannelService;
import com.readyidu.util.JsonResult;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 2017/6/20
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/webChannel")
public class WebChannelController {

    @Resource(name = "channelService")
    private ChannelService channelService;

    @RequestMapping(value = "/addChannel/{channelName}", method = RequestMethod.POST)
    @ResponseBody
    public String addChannel(@PathVariable String channelName) {
        if (channelService.addChannel(channelName) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/addSource.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addSource(@RequestBody ChannelRequest channelRequest) {
        if (channelService.updateSource(channelRequest.getChannelId(), channelRequest.getSourceUri()) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/removeSource.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String removeSource(@RequestBody ChannelRequest channelRequest) {
        if (channelService.removeSource(channelRequest.getChannelId(), channelRequest.getSourceId()) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/changeType.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String changeType(@RequestBody ChannelRequest channelRequest) {
        if (channelService.changeType(channelRequest.getChannelId(), channelRequest.getTypeId()) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/removeChannel.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String removeChannel(@RequestBody ChannelRequest channelRequest) {
        if (channelService.removeChannel(channelRequest.getChannelId()) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } else {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
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
