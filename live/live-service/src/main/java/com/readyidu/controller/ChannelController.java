package com.readyidu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readyidu.constants.NetworkCode;
import com.readyidu.service.ChannelService;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/channel")
public class ChannelController {

    @Resource(name = "channelService")
    private ChannelService channelService;

    @RequestMapping(value = "/channel.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannel(HttpServletRequest request,
                             HttpServletResponse response) {
//        String jx  = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv1","Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1",null,"Hm_lpvt_1bb06592fde65998bca187014e8f64d1=1497942184; Hm_lvt_1bb06592fde65998bca187014e8f64d1=1497942004; JSESSIONID=6E4E94385089EF0588C072A4008D8404");

        try {
            List<Channel> channelInfoList = channelService
                    .getChannelList();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoList);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/channelType.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelType(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            List<ChannelType> channelInfoType = channelService
                    .getChannelType();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoType);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/channel.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postChannel(HttpServletRequest request,
                              HttpServletResponse response) {
        try {
            List<Channel> channelInfoList = channelService
                    .getChannelList();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoList);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/channelType.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postChannelType(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            List<ChannelType> channelInfoType = channelService
                    .getChannelType();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoType);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
}