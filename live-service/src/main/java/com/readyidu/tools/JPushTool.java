package com.readyidu.tools;


import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import com.readyidu.constants.NetworkCode;
import com.readyidu.util.JsonResult;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/9/11.
 */
public class JPushTool {
    protected static Logger LOG = Logger.getLogger(JPushTool.class);
    public static void  sendPush(String masterSecret,String appKey,String message,int code){
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());
        Map map=new HashMap();
        map.put("message",message);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date().getTime());
        map.put("date",time);
        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jpushClient.sendMessageAll(JsonResult.toString(code,map));
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }
    public static PushPayload buildPushObject_all_all_alert(Map map,int code,String alias) {
        return  PushPayload.newBuilder()
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.alias(alias))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(JsonResult.toString(code,map))
                        .build())
                .build();
    }
    public static void  sendAppointPush(String masterSecret,String appKey,String message,int code,String alias){
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());
        Map map=new HashMap();
        map.put("message",message);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date().getTime());
        map.put("date",time);
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert(map,code,alias);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }
}
