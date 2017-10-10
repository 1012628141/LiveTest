package com.readyidu.source.local.fujian;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.zhejiang.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class FujianLocal extends Local {

    private static final String MANAGER_ID = "fujian";

    public FujianLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new FJTV1Channel();
        Channel channel2 = new FJTV2Channel();
        Channel channel3 = new FJTV3Channel();
        Channel channel4 = new FJTV5Channel();
        Channel channel5 = new FJTV6Channel();
        Channel channel6 = new FJTV8Channel();

        channels.put(channel1.getId(), channel1);
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
}
