package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.cctv.source.FengmiSource;
import com.readyidu.source.local.stv.FengmiStvChannel;
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
        Channel channel4 = new CCTVMIguChannels();
        Channel channel5 = new CCTVLiangChannels();
        Channel channel6 = new CCTVTianyiChannels();
        Channel channel7 = new CCTVYIchengChannels();
        Channel channel8 = new NETTVChannels();
        Channel channel9 = new IPTVChannels();
        Channel channel10 = new CCTVFengmiChannel();
        Channel channel11 = new CCTVSelfChannels();
        channels = new HashMap<>();
        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
        channels.put(channel8.getId(), channel8);
        channels.put(channel9.getId(), channel9);
        channels.put(channel10.getId(), channel10);
        channels.put(channel11.getId(), channel11);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
            return channel.getSource(uri).getSource();
    }
}
