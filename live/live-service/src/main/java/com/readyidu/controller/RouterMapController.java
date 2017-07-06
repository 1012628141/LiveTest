package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.model.RouterMapping;
import com.readyidu.service.RouterService;
import com.readyidu.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017/7/5
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/router/channel/")
public class RouterMapController {

    @Resource(name = "routerService")
    RouterService routerService;

    // 客户端获取全部Mapping的地方
    @RequestMapping(value = "getMapper.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllChannelMap() {
        List<RouterMapping> routerMappings = routerService.selectAll();
        return JsonResult.toString(NetworkCode.CODE_SUCCESS, routerMappings);
    }

    //
}
