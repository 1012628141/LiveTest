package com.readyidu.tools;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 2017/6/21
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public class WebHttpTool {
    private static final Logger logger = LoggerFactory.getLogger(WebHttpTool.class);

    public static String sendGet(String url) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
//        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        logger.debug("\nSending 'GET' request to URL : " + url);
        logger.debug("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line.replace("\\", ""));
        }

        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
        return result.toString();

    }

    // HTTP POST request
    public static String sendPost(String url, Map<String, String> params) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
//        post.setHeader("User-Agent", USER_AGENT);
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

        Iterator iter = params.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            urlParameters.add(new BasicNameValuePair(key, val));
        }
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        logger.debug("\nSending 'POST' request to URL : " + url);
        logger.debug("Post parameters : " + post.getEntity());
        logger.debug("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line.replace("\\", ""));
        }

        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
