package com.readyidu.tools;


import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
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
    public static void  sendPush(String masterSecret,String appKey,String message){
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());
        Map map=new HashMap();
        map.put("message",message);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date().getTime());
        map.put("date",time);
        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jpushClient.sendMessageAll(JsonResult.toString(NetworkCode.CACHE_EXPIRE,map));
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
//    public static PushPayload buildPushObject_all_all_alert() {
////        return  PushPayload.newBuilder().setNotification()
////        return PushPayload.alertAll(JsonResult.toString(NetworkCode.CACHE_EXPIRE,"命令缓存失效"));
//    }
}
