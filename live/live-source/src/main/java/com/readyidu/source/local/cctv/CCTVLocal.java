package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * 2017/6/15
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public class CCTVLocal extends Local {

    public CCTVLocal() {
        managerId = "cctv";

        Channel channel1 = new CCTVChannels();
        Channel channel2 = new CCTVShitingChannels();
        Channel channel3 = new CCTVTvCatChannels();
        channels = new HashMap<>();
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
