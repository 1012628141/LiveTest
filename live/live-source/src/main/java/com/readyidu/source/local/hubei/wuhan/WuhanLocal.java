package com.readyidu.source.local.hubei.wuhan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.hunan.hunan.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/26.
 */
public class WuhanLocal extends Local {

    private static final String MANAGER_ID = "wuhan";

    public WuhanLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Wuhan1Channel();
        Channel channel2 = new Wuhan2Channel();
        Channel channel3 = new Wuhan3Channel();
        Channel channel4 = new Wuhan4Channel();
        Channel channel5 = new Wuhan5Channel();
        Channel channel6 = new Wuhan6Channel();
        Channel channel7 = new Wuhan7Channel();
        Channel channel8 = new Wuhan8Channel();
        Channel channel9 = new Wuhan9Channel();


        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
        channels.put(channel8.getId(), channel8);
        channels.put(channel9.getId(), channel9);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
