package com.readyidu.service;

import javax.servlet.ServletOutputStream;
import java.util.List;

public interface TvSynchronizeService {

    /*参数  deviceId：机顶盒唯一标识id*/
    void getQRCode(String deviceId,String tvAlias,ServletOutputStream outputStream);

    /*参数 tvDeviceId设备识别号  添加一个设备 返回值不为0成功*/
    int addTvDevice(String tvDeviceId,String tvAlias);

    /*参数deviceId 机顶盒设备ID  返回值 绑定设备的id*/
    String getDevices(String deviceId);

    String removePhoneByDeviceId(String userId);
}
