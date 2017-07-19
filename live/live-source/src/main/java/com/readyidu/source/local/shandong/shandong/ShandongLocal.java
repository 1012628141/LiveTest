package com.readyidu.source.local.shandong.shandong;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.shandong.jinan.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/27.
 */
public class ShandongLocal extends Local {

    private static final String MANAGER_ID = "shandong";

    public ShandongLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Shandong1Channel();
        Channel channel2 = new Shandong2Channel();
        Channel channel3 = new Shandong3Channel();
        Channel channel4 = new Shandong4Channel();
        Channel channel5 = new Shandong5Channel();
        Channel channel6 = new Shandong6Channel();
        Channel channel7 = new Shandong7Channel();
        Channel channel8 = new Shandong8Channel();
        Channel channel9 = new Shandong9Channel();
        Channel channel10 = new Shandong10Channel();


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
