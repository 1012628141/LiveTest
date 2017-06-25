package com.readyidu.source.local.hunan.hunan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.changzhou.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/22.
 */
public class HunanLocal extends Local {

    private static final String MANAGER_ID = "hunan";

    public HunanLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Hunan1Channel();
        Channel channel2 = new Hunan2Channel();
        Channel channel3 = new Hunan3Channel();
        Channel channel4 = new Hunan4Channel();
        Channel channel5 = new Hunan5Channel();
        Channel channel6 = new Hunan6Channel();
        Channel channel7 = new Hunan7Channel();
        Channel channel8 = new Hunan8Channel();
        Channel channel9 = new Hunan9Channel();
        Channel channel10 = new Hunan10Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
        channels.put(channel8.getId(), channel8);
        channels.put(channel9.getId(), channel9);
        channels.put(channel10.getId(), channel10);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
