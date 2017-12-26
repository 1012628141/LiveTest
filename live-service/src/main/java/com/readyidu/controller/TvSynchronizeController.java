package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.model.PhoneDevice;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.service.TvSynchronizeService;
import com.readyidu.service.impl.TvSynchronizeServiceImpl;
import com.readyidu.tools.JPushTool;
import com.readyidu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2017/12/25.
 */
@Controller
public class TvSynchronizeController {
    private TvSynchronizeService tvSynchronizeService = new TvSynchronizeServiceImpl();
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
    public String bindingReq(RequestParamModel requestParamModel){
        int acount = requestParamModel.getAccount();
        String deviceId = requestParamModel.getDeviceId();
        PhoneDevice phoneDevice = new PhoneDevice();
        phoneDevice.setDeviceId(deviceId);
        phoneDevice.setUserId(acount);
        int num = tvSynchronizeService.insertPhoneDevice(phoneDevice);
        if (num > 0){
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
        }
        return null;
    }
}
