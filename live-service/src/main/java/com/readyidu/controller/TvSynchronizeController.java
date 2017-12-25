package com.readyidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/DevicesChannels")
    public String DevicesChannels(){
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
