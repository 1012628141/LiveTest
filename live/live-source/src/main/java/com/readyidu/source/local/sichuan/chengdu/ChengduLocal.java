package com.readyidu.source.local.sichuan.chengdu;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.fujian.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class ChengduLocal extends Local {

    private static final String MANAGER_ID = "chengdu";

    public ChengduLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Chengdu1Channel();
        Channel channel2 = new Chengdu2Channel();
        Channel channel3 = new Chengdu3Channel();
        Channel channel4 = new Chengdu4Channel();
        Channel channel5 = new Chengdu5Channel();
        Channel channel6 = new Chengdu6Channel();
        Channel channel7 = new Chengdu7Channel();
        Channel channel8 = new Chengdu8Channel();
        Channel channel9 = new Chengdu9Channel();
        Channel channel10 = new Chengdu10Channel();
        Channel channel11 = new Chengdu11Channel();
        Channel channel12 = new Chengdu12Channel();
        Channel channel13 = new Chengdu13Channel();
        Channel channel14 = new Chengdu14Channel();

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
        channels.put(channel11.getId(), channel11);
        channels.put(channel12.getId(), channel12);
        channels.put(channel13.getId(), channel13);
        channels.put(channel14.getId(), channel14);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
