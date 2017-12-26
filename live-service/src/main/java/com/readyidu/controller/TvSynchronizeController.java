package com.readyidu.controller;

import com.readyidu.model.PhoneDevice;
import com.readyidu.service.TvSourceService;
import com.readyidu.service.TvSynchronizeService;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 123 on 2017/12/25.
 */
@Controller
public class TvSynchronizeController {


    @Autowired
    private TvSynchronizeService tvSynchronizeService;



    /**
     * 获取二维码
     * @param deviceId 机顶盒识别id
     * @return
     */
    @RequestMapping("/getQRCode")
    public void getQRCode(String deviceId,String tvAlias,HttpServletResponse response){
        if (!NullUtil.isNullObject(deviceId)&&!NullUtil.isNullObject(tvAlias)){
            try {
                tvSynchronizeService.getQRCode(deviceId,tvAlias,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取绑定设备列表
     * @return 绑定的设备的信息
     * @param  deviceId 设备Id
     */
    @ResponseBody
    @RequestMapping("/getDevices")
    public String getDevices(String deviceId){
        return tvSynchronizeService.getDevices(deviceId);
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
