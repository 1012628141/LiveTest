package com.readyidu.source.local.sichuan.mianyang;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.zhejiang.ningbo.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class MianyangLocal extends Local {

    private static final String MANAGER_ID = "mianyang";

    public MianyangLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();
        Channel channel1 = new Mainyang1Channel();
        Channel channel2 = new Mainyang2Channel();
        Channel channel3 = new Mainyang3Channel();
        Channel channel4 = new Mainyang4Channel();
        Channel channel5 = new Mainyang5Channel();
        Channel channel6 = new Mainyang6Channel();
        Channel channel7 = new Mainyang7Channel();
        Channel channel8 = new Mainyang8Channel();
        Channel channel9 = new Mainyang9Channel();

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
