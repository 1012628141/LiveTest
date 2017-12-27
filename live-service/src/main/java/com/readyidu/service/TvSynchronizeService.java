package com.readyidu.service;

import com.readyidu.model.PhoneService;

import javax.servlet.ServletOutputStream;
import java.util.List;

import com.readyidu.model.PhoneDevice;

public interface TvSynchronizeService {

    /*参数  deviceId：机顶盒唯一标识id*/
    String getQRCode(String deviceId,String tvAlias,ServletOutputStream outputStream);

    /*参数 tvDeviceId设备识别号  添加一个设备 返回值不为0成功*/
    int addTvDevice(String tvDeviceId,String tvAlias);

    /*参数deviceId 机顶盒设备ID  返回值 绑定设备的id*/
    String getDevices(String deviceId);

    int insertPhoneDevice(PhoneDevice phoneDevice);

    String removePhoneByDeviceId(String userId);

    /*参数deviceId机顶盒设备ID 返回值 绑定设备下不同账号的自定义源*/
    List<PhoneService> getCostomizeSourceList(String deviceId);
}
