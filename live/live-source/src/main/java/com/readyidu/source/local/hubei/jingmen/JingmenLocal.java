package com.readyidu.source.local.hubei.jingmen;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/26.
 */
public class JingmenLocal extends Local {

    private static final String MANAGER_ID = "jingmen";

    public JingmenLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<>();

        Channel channel1 = new Jingmen1Channel();
        Channel channel2 = new Jingmen2Channel();


        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
