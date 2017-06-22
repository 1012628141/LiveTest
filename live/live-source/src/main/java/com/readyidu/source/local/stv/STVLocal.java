package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.changzhou.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class STVLocal extends Local {

    private static final String MANAGER_ID = "stv";

    public STVLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel guangdongChannel = new GuangdongStvChannel();
        Channel dongfangChannel = new DongfangStvChannel();

        channels.put(guangdongChannel.getId(), guangdongChannel);
        channels.put(dongfangChannel.getId(), dongfangChannel);

    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
