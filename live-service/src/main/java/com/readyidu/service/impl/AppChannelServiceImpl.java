package com.readyidu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AppChannelServiceImpl extends BaseService implements AppChannelService{

    @Autowired
    private PhoneDeviceMapper phoneDeviceMapper;

    @Override
    public String checkBinding(int account, String deviceId) {
        String deviceId_old = phoneDeviceMapper.selectDeviceIdByUserId(account);
        if (deviceId_old == deviceId){
            //小益账号已绑定该机顶盒
            String message = "您的手机设备已经开通手机直播功能无需重复开通。";
            return message;
        } else if (!deviceId_old.isEmpty()){
            //小益账号绑定了其他机顶盒，则解绑
            phoneDeviceMapper.delete(account);
        }
        //判断该机顶盒是否超过3个
        if(phoneDeviceMapper.getCountByDeviceId(deviceId)<3){
            //向指定TV端发送推送
            return "";
        }else {
            return "您绑定的手机设备已达上限，请解绑后再重新添加新的手机设备。";
        }
    }
}
