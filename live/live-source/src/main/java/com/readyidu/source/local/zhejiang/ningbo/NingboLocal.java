package com.readyidu.source.local.zhejiang.ningbo;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class NingboLocal extends Local {

    private static final String MANAGER_ID = "ningbo";

    public NingboLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();
        Channel channel1 = new NBTV1Channel();
        Channel channel2 = new NBTV2Channel();
        Channel channel3 = new NBTV3Channel();
        Channel channel4 = new NBTV4Channel();
        Channel channel5 = new NBTV5Channel();
        Channel channel6 = new NBTV6Channel();
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
