package com.readyidu.source.local.shanghai;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.stv.DongfangStvChannel;
import com.readyidu.source.local.stv.GuangdongStvChannel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class ShanghaiLocal extends Local {

    private static final String MANAGER_ID = "shanghai";

    public ShanghaiLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Shanghai1Channel();
        Channel channel2 = new Shanghai2Channel();
        Channel channel3 = new Shanghai3Channel();
        Channel channel4 = new Shanghai4Channel();
        Channel channel5 = new Shanghai5Channel();
        Channel channel6 = new Shanghai6Channel();
        Channel channel7 = new Shanghai7Channel();
        Channel channel8 = new Shanghai8Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
        channels.put(channel8.getId(), channel8);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
