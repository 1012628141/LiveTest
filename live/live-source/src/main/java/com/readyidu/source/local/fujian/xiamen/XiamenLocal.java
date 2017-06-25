package com.readyidu.source.local.fujian.xiamen;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.fujian.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class XiamenLocal extends Local {

    private static final String MANAGER_ID = "xiamen";

    public XiamenLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Xiamen1Channel();
        Channel channel2 = new Xiamen2Channel();
        Channel channel3 = new Xiamen3Channel();
        Channel channel4 = new Xiamen4Channel();

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
