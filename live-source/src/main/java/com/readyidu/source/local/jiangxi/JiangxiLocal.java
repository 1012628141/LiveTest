package com.readyidu.source.local.jiangxi;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 17/6/24.
 */
public class JiangxiLocal extends Local {

    private static final String MANAGER_ID = "jiangxi";

    public JiangxiLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Jiangxi1Channel();
        Channel channel2 = new Jiangxi2Channel();
        Channel channel3 = new Jiangxi3Channel();
        Channel channel4 = new Jiangxi4Channel();
        Channel channel5 = new Jiangxi5Channel();
        Channel channel6 = new Jiangxi6Channel();
        Channel channel7 = new Jiangxi7Channel();
        Channel channel8 = new Jiangxi8Channel();
        Channel channel9 = new Jiangxi9Channel();

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
