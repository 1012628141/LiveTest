package com.readyidu.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by sjs on 2017/2/16.
 */
public class HttpUtil {

    public static String httpGet(String url) {
        return HttpUtil.httpGet(url, null, null);
    }

    public static String httpGet(String url, String token) {
        // get请求返回结果
        String result = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            if (!NullUtil.isNullObject(token)) {
                request.addHeader("Token", token);
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
    public static String httpGet(String url, String userAgent, String referer) {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        Request.Builder builder = new Request.Builder().url(url);
        if (!TextUtils.isEmpty(userAgent)) {
            builder.addHeader("User-Agent", userAgent);
        }
        if (!TextUtils.isEmpty(referer)) {
            builder.addHeader("Referer", referer);
        }
        Request request = builder.get().build();
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

    public static String httpGet(String url, String userAgent, String referer, String cookies) {
        // get请求返回结果
        String result = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            if (!NullUtil.isNullObject(userAgent)) {
                request.addHeader("User-Agent", userAgent);
            }
            if (!NullUtil.isNullObject(referer)) {
                request.addHeader("Referer", referer);
            }
            if (!NullUtil.isNullObject(cookies)) {
                request.addHeader("Cookie", cookies);
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

    public static String sendPost(String url, String param) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(param, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");

            httpPost.setEntity(stringEntity);

            // CloseableHttpResponse response =
            // httpclient.execute(httpPost);

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {//
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {

                        HttpEntity entity = response.getEntity();

                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            return responseBody;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
