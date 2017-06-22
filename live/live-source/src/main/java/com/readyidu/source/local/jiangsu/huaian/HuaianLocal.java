package com.readyidu.source.local.jiangsu.huaian;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.changzhou.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/20.
 */
public class HuaianLocal extends Local {

    private static final String MANAGER_ID = "huaian";

    public HuaianLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Changzhou1Channel();
        Channel channel2 = new Changzhou2Channel();
        Channel channel3 = new Changzhou3Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
