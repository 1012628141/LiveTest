package com.readyidu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.BaseService;
import com.readyidu.tools.JPushTool;
import com.readyidu.tools.WebHttpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "appChannelService")
public class AppChannelServiceImpl extends BaseService implements AppChannelService{

    @Autowired
    private PhoneDeviceMapper phoneDeviceMapper;

    private static final String MASTER_SECRET="ae03c3cd69069d05f04a0290";
    private static final String APP_KEY="e27c9e82155e29b33d01a9e3";
    private static final String MESSAGE="手机账号绑定机顶盒";
    private static final String HTTP_POST_URL = "http://192.168.4.103:8815/user/queryUserByusid.do";

    @Override
    public int checkBinding(int account, String deviceId,String tvAlias,String appAlias) {
        String deviceId_old = phoneDeviceMapper.selectDeviceIdByUserId(account);
        int code;
        if (deviceId_old == deviceId){
            //小益账号已绑定该机顶盒
            code = NetworkCode.BUNDLING_REPETITION;
            JPushTool.sendAppointPush(MASTER_SECRET,APP_KEY,MESSAGE, NetworkCode.BUNDLING_REPETITION,tvAlias,appAlias);
            return code;
        } else if (!deviceId_old.isEmpty()){
            //小益账号绑定了其他机顶盒，则解绑
            phoneDeviceMapper.delete(account);
        }
        //判断该机顶盒是否超过3个
        if(phoneDeviceMapper.getCountByDeviceId(deviceId)<3){
            //向指定TV端发送推送
            code = NetworkCode.CODE_SUCCESS;
            JPushTool.sendAppointPush(MASTER_SECRET,APP_KEY,MESSAGE, NetworkCode.CODE_SUCCESS,tvAlias,appAlias);
        }else {
            code = NetworkCode.BUNDLING_LIMIT;
            JPushTool.sendAppointPush(MASTER_SECRET,APP_KEY,MESSAGE, NetworkCode.BUNDLING_LIMIT,tvAlias,appAlias);
        }
        return code;
    }

    @Override
    public boolean checkUserId(int userId) {
        Map<String, String> params = new HashMap<>();
        params.put("userId",String.valueOf(userId));
        try {
            String result =WebHttpTool.sendPost(HTTP_POST_URL,params);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String finalResult = JSONObject.parseObject(jsonObject.getString("data")).getString("result");
            if(finalResult=="true"){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
