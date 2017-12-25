package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qiniu.happydns.Network;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 123 on 2017/12/25.
 */
@Controller
public class TvSynchronizeController {

    /**
     * 获取二维码
     * @return
     */
    @RequestMapping("/getQRCode")
    public String getQRCode(){
        return null;
    }

    /**
     * 获取绑定设备列表
     * @return
     */
    @RequestMapping("/getDevices")
    public String getDevices(){
        return null;
    }

    /**
     * 获取绑定设备自定义源列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/DevicesChannels")
    public String DevicesChannels(HttpServletRequest request){
        return null;
    }

    /**
     * tv端绑定确认接口
     * @return
     */
    @RequestMapping("/bindingReq")
    public String bindingReq(){
        return null;
    }
}
