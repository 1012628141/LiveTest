package com.readyidu.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.TextUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

/**
 * Created by sjs on 2017/2/16.
 */
public class HttpUtil {

    public static String httpGet(String url) {
        return HttpUtil.httpGet(url,null,null);
    }

    public static String httpGet(String url,String userAgent,String referer) {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        Request.Builder builder= new Request.Builder().url(url);
        if (!TextUtils.isEmpty(userAgent)) {
            builder.addHeader("User-Agent",userAgent);
        }
        if (!TextUtils.isEmpty(referer)) {
            builder.addHeader("Referer",referer);
        }
        Request request=builder.get().build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

//        // get请求返回结果
//        String result = null;
//        try {
//            DefaultHttpClient client = new DefaultHttpClient();
//            // 发送get请求
//            HttpGet request = new HttpGet(url);
//            if(!NullUtil.isNullObject(userAgent)){
//                request.addHeader("User-Agent",userAgent);
//            }
//            if(!NullUtil.isNullObject(referer)){
//                request.addHeader("Referer",referer);
//            }
//            HttpResponse response = client.execute(request);
//
//            /** 请求发送成功，并得到响应 **/
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                /** 读取服务器返回过来的json字符串数据 **/
//                result = EntityUtils.toString(response
//                        .getEntity());
//                url = URLDecoder.decode(url, "UTF-8");
//            } else {
//            }
//        } catch (IOException e) {
//        }
//        return result;
    }

    public static String httpGet(String url,String userAgent,String referer,String cookies) {
        // get请求返回结果
        String result = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            if(!NullUtil.isNullObject(userAgent)){
                request.addHeader("User-Agent",userAgent);
            }
            if(!NullUtil.isNullObject(referer)){
                request.addHeader("Referer",referer);
            }
            if(!NullUtil.isNullObject(cookies)){
                request.addHeader("Cookie",cookies);
            }
            HttpResponse response = client.execute(request);

            /** 请求发送成功，并得到响应 **/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /** 读取服务器返回过来的json字符串数据 **/
                result = EntityUtils.toString(response
                        .getEntity());
                url = URLDecoder.decode(url, "UTF-8");
            } else {
            }
        } catch (IOException e) {
        }
        return result;
    }

}
