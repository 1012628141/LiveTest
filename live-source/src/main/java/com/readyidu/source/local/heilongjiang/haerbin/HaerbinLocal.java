package com.readyidu.source.local.heilongjiang.haerbin;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/27.
 */
public class HaerbinLocal extends Local {

    private static final String MANAGER_ID = "haerbin";

    public HaerbinLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Haerbin1Channel();
        Channel channel2 = new Haerbin2Channel();
        Channel channel3 = new Haerbin3Channel();
        Channel channel4 = new Haerbin4Channel();
        Channel channel5 = new Haerbin5Channel();

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
