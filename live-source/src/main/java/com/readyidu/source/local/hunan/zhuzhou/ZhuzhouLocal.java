package com.readyidu.source.local.hunan.zhuzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.changzhou.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/22.
 */
public class ZhuzhouLocal extends Local {

    private static final String MANAGER_ID = "zhuzhou";

    public ZhuzhouLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Zhuzhou1Channel();
        Channel channel2 = new Zhuzhou2Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
