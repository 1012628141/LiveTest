package com.readyidu.source.local.shandong.rizhao;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.shandong.jinan.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/27.
 */
public class RizhaoLocal extends Local {

    private static final String MANAGER_ID = "rizhao";

    public RizhaoLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Rizhao1Channel();
        Channel channel2 = new Rizhao2Channel();
        Channel channel3 = new Rizhao3Channel();
        Channel channel4 = new Rizhao4Channel();


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
