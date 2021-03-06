package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.service.SourceService;
import com.readyidu.model.Source;
import com.readyidu.service.TvSourceService;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by yuzhang on 17/6/9.
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/source")
public class SourceController {

    public static final String PARAM_SOURCE_URI = "sourceUri";

    @Resource(name = "sourceService")
    SourceService sourceService;

    @Resource(name = "tvSourceService")
    TvSourceService tvSourceService;
    @RequestMapping(value = "/source.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelType(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            String source = sourceService.getSource(request.getParameter(PARAM_SOURCE_URI));
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.CODE_FAIL, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, new Source(source));
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/source.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postChannel(HttpServletRequest request,
                              HttpServletResponse response) {
        try {
            String source = sourceService.getSource(request.getParameter(PARAM_SOURCE_URI));
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.CODE_FAIL, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, new Source(source));
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
}
