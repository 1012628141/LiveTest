package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.model.ChannelSource;
import com.readyidu.service.CacheService;
import com.readyidu.service.ChannelSourceService;
import com.readyidu.service.DeathChannelService;
import com.readyidu.util.JsonResult;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 2017/6/23
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/report")
public class DeathChannelController {

    @Resource(name = "deathChannelService")
    DeathChannelService deathChannelService;
    @Resource(name = "channelSourceService")
    ChannelSourceService channelSourceService;
    @Resource(name = "cacheService")
    CacheService cacheService;
    @RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertReport(HttpServletRequest request) {
        // Check if update
        String source = request.getParameter("sourceUri");

        if (!TextUtils.isEmpty(source)) {
            ChannelSource channelDeath = channelSourceService.getDeathBySource(source);
            if (channelDeath != null) {
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
            }
            else {
                if (channelSourceService.updateIsDelete(source) != 0) {
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
                }
            }
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL, "");
    }
    @ResponseBody
    @RequestMapping(value = "/auditPass.do",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String auditPass(Integer sourceid,boolean status){
        if (sourceid!=0) {
            String cacheKey = "LIVE_SERVICE_channel_deathChannelList";
            cacheService.del(cacheKey);
            if (status){
                if (channelSourceService.delectSourceByid(sourceid)!=0){
                    cacheService.del("LIVE_SERVICE_channel_channelList");
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
                }
            }
            else {
                if (channelSourceService.reductionSourceByid(sourceid)!=0){
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
                }
            }
        }
        return  JsonResult.toString(NetworkCode.CODE_FAIL,"");
    }
}
