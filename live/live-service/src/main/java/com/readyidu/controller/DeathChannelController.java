package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelDeath;
import com.readyidu.service.DeathChannelService;
import com.readyidu.util.JsonResult;
import org.apache.http.util.TextUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.TextUI;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertReport(HttpServletRequest request) {
        // Check if update
        String source = request.getParameter("sourceUri");

        if (!TextUtils.isEmpty(source)) {
            ChannelDeath channelDeath = deathChannelService.getChannel(source);

            if (channelDeath != null) {
                channelDeath.setCreatedat(new Date());
                if (deathChannelService.update(channelDeath) != 0) {
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
                }
            } else {
                channelDeath = new ChannelDeath();
                channelDeath.setCreatedat(new Date());
                channelDeath.setSource(source);
                if (deathChannelService.insert(channelDeath) != 0) {
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
                }
            }
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL, "");
    }
}
