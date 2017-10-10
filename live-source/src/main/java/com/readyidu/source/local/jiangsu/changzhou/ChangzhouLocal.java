package com.readyidu.source.local.jiangsu.changzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.changzhou.source.CztvSource;
import com.readyidu.source.local.jiangsu.wuxi.*;
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
public class ChangzhouLocal extends Local {

    private static final String MANAGER_ID = "changzhou";

    public ChangzhouLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Changzhou1Channel();
        Channel channel2 = new Changzhou2Channel();
        Channel channel3 = new Changzhou3Channel();
        Channel channel4 = new Changzhou4Channel();
        Channel channel5 = new Changzhou5Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
