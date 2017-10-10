package com.readyidu.source.local.jiangxi.shangrao;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangxi.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 17/6/24.
 */
public class ShangraoLocal extends Local {

    private static final String MANAGER_ID = "shangrao";

    public ShangraoLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Shangrao1Channel();
        Channel channel2 = new Shangrao2Channel();
        Channel channel3 = new Shangrao3Channel();
        Channel channel4 = new Shangrao4Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
