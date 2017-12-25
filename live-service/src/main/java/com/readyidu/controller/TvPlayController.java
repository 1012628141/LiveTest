package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.service.PlayTypeService;
import com.readyidu.service.TvSourceService;
import com.readyidu.service.impl.TvSourceServiceImpl;
import com.readyidu.tools.JPushTool;
import com.readyidu.util.JsonResult;
import com.readyidu.util.QRCodeUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/10/9.
 */
@Controller
@RequestMapping("/play")
public class TvPlayController {
//    private static final String MASTER_SECRET = "42cd72a24310d452da54caab";
//    private static final String APP_KEY = "d351b43f6d69a55687f27c1f";
    private static final String MASTER_SECRET = "ef9f38dadd725270fea9e65b";
    private static final String APP_KEY = "6d798d4905318ea41b80f3e3";

    private static final String MESSAGE = "切换TV";
    @Autowired
    private PlayTypeService playTypeService;

    @Autowired
    private TvSourceService tvSourceService;

    @ResponseBody
    @RequestMapping(value = "pushPlayType.do", produces = "application/json; charset=utf-8")
    public String pushPlayType() {
        try {
            JPushTool.sendPush(MASTER_SECRET, APP_KEY, MESSAGE, NetworkCode.TYPE_CHANGE);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @ResponseBody
    @RequestMapping(value = "tvPlayType.do", produces = "application/json; charset=utf-8")
    public String tvPlayType() {
        Map<String, Integer> map = new HashMap<>();
        try {
            int playType = playTypeService.getPlayType();
            map.put("playType", playType);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, map);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @ResponseBody
    @RequestMapping(value = "tvsource", produces = "application/json; charset=utf-8")
    public String tvsource(String source) {
            return tvSourceService.channelType();
    }
    @ResponseBody
    @RequestMapping(value = "test", produces = "application/json; charset=utf-8")
    public String test(String source,Integer id) {
        return tvSourceService.getNewChannelListByTypeId(source,id);
    }
    @ResponseBody
    @RequestMapping(value = "key", produces = "application/json; charset=utf-8")
    public String key(String source) {
        return tvSourceService.selectChannelInfoByKey(source);
    }
    @ResponseBody
    @RequestMapping(value = "channelPlaybill", produces = "application/json; charset=utf-8")
    public String channelPlaybill(String source) {
        return tvSourceService.channelPlaybill(source);
    }


    @RequestMapping("yanzheng")
    public void yanzheng(HttpServletResponse response){
        try {
            QRCodeUtil.encode("http://www.baidu.com", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
