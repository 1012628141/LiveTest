package com.readyidu.source.local.hubei.yichang;
import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/26.
 */
public class YichangLocal extends Local {

    private static final String MANAGER_ID = "yichang";

    public YichangLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<>();

        Channel channel1 = new Yichang1Channel();
        Channel channel2 = new Yichang2Channel();
        Channel channel3 = new Yichang3Channel();

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
