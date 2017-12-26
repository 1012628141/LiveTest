package com.readyidu.service.impl;


import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.BaseService;
import com.readyidu.tools.JPushTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("appChannelService")
public class AppChannelServiceImpl extends BaseService implements AppChannelService{

    @Autowired
    private PhoneDeviceMapper phoneDeviceMapper;
    @Autowired
    private ConfInfoMapper confInfoMapper;

    private static final String MASTER_SECRET="ae03c3cd69069d05f04a0290";
    private static final String APP_KEY="e27c9e82155e29b33d01a9e3";
    private static final String MESSAGE="手机账号绑定机顶盒";

    @Override
    public void checkBinding(int account, String deviceId,String alias) {
        String deviceId_old = phoneDeviceMapper.selectDeviceIdByUserId(account);
        if (deviceId_old == deviceId){
            //小益账号已绑定该机顶盒
//            String message = "您的手机设备已经开通手机直播功能无需重复开通。";
            JPushTool.sendAppointPush(MASTER_SECRET,APP_KEY,MESSAGE, NetworkCode.BUNDLING_REPETITION,alias);
        } else if (!deviceId_old.isEmpty()){
            //小益账号绑定了其他机顶盒，则解绑
            phoneDeviceMapper.delete(account);
        }
        //判断该机顶盒是否超过3个
        if(phoneDeviceMapper.getCountByDeviceId(deviceId)<3){
            //向指定TV端发送推送
//            String message = "";
            JPushTool.sendAppointPush(MASTER_SECRET,APP_KEY,MESSAGE, NetworkCode.BUNDLING_CAN,alias);
        }else {
//            String message = "您绑定的手机设备已达上限，请解绑后再重新添加新的手机设备。";
            JPushTool.sendAppointPush(MASTER_SECRET,APP_KEY,MESSAGE, NetworkCode.BUNDLING_LIMIT,alias);
        }
    }

    @Override
    public ConfInfo selectByAcount(Integer acount) {
        return confInfoMapper.selectByAcount(acount);
    }

    @Transactional
    @Override
    public void insertConf(ConfInfo confInfo) {
        confInfoMapper.insertConf(confInfo);
    }

    @Transactional
    @Override
    public void updateConfinfo(ConfInfo confInfo) {
        confInfoMapper.updateConfinfo(confInfo);
    }
}


