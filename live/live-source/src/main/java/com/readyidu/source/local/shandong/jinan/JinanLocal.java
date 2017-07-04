package com.readyidu.source.local.shandong.jinan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;

import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/27.
 */
public class JinanLocal extends Local {

    private static final String MANAGER_ID = "jinan";

    public JinanLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Jinan1Channel();
        Channel channel2 = new Jinan2Channel();
        Channel channel3 = new Jinan3Channel();
        Channel channel4 = new Jinan4Channel();
        Channel channel5 = new Jinan5Channel();
        Channel channel6 = new Jinan6Channel();
        Channel channel7 = new Jinan7Channel();


        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
