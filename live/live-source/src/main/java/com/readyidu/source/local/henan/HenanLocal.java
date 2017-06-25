package com.readyidu.source.local.henan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class HenanLocal extends Local {

    private static final String MANAGER_ID = "henan";

    public HenanLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Henan1Channel();
        Channel channel2 = new Henan2Channel();
        Channel channel3 = new Henan3Channel();
        Channel channel4 = new Henan4Channel();
        Channel channel5 = new Henan5Channel();
        Channel channel6 = new Henan6Channel();
        Channel channel7 = new Henan7Channel();
        Channel channel8 = new Henan8Channel();
        Channel channel9 = new Henan9Channel();
        Channel channel10 = new Henan10Channel();
        Channel channel11 = new Henan11Channel();
        Channel channel12 = new Henan12Channel();
        Channel channel13 = new Henan13Channel();

        channels.put(channel1.getId(), channel2);
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
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
