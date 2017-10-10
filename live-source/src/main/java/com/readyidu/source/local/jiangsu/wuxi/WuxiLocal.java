package com.readyidu.source.local.jiangsu.wuxi;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.zhejiang.*;
import com.readyidu.source.protocol.SourceUri;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class WuxiLocal extends Local {

    private static final String MANAGER_ID = "wuxi";

    public WuxiLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new THMZ1Channel();
        Channel channel2 = new THMZ2Channel();
        Channel channel3 = new THMZ3Channel();
        Channel channel4 = new THMZ4Channel();
        Channel channel5 = new THMZ5Channel();
        Channel channel6 = new THMZ6Channel();

        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            //HttpGet httpGet = new HttpGet("http://test.laizi.cn:8080/114/bm/accountLogin");
//            String url = "http://www2.thmz.com/m2o/player/drmx.php?url=http%3A%2F%2Fstream%2Ethmz%2Ecom%2Fwxtv1%2Fsd%2Flive%2Em3u8&time=1497786907725&refererurl=http%3A%2F%2Fv2%2Ethmz%2Ecom%2F&hash=51879d474e53fff83875cb59de8d9148&playerVersion=4%2E03";
            String url = "http://www2.thmz.com/m2o/player/drmx.php?url=http%3A%2F%2Fstream%2Ethmz%2Ecom%2Fwxtv1%2Fsd%2Flive%2Em3u8&time=1497786907725&refererurl=http%3A%2F%2Fv2%2Ethmz%2Ecom%2Ffolder4%2Ffolder27%2F&&hash=51879d474e53fff83875cb59de8d9148&playerVersion=4%2E03";
            HttpGet httpGet = new HttpGet(url);
//            httpGet.setHeader("Host","www2.thmz.com");
            httpGet.setHeader("Referer","http://v2.thmz.com/folder4/folder27/");
//            httpGet.setHeader("Referer","http://v2.thmz.com/");
//            httpGet.setHeader("Accept","*/*");
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
//            httpGet.setHeader("Accept-Language","zh-cn");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                //打印目标网站输出内容
                System.out.println(EntityUtils.toString(entity));
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
