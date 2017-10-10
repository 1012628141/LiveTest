package com.readyidu.source.local.jiangsu.jiangsu;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.taizhou.Taizhou1Channel;
import com.readyidu.source.local.jiangsu.taizhou.Taizhou2Channel;
import com.readyidu.source.local.jiangsu.taizhou.Taizhou3Channel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class JiangsuLocal extends Local {

    private static final String MANAGER_ID = "jiangsu";

    public JiangsuLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Jiangsu1Channel();
        Channel channel2 = new Jiangsu2Channel();
        Channel channel3 = new Jiangsu3Channel();
        Channel channel4 = new Jiangsu4Channel();
        Channel channel5 = new Jiangsu5Channel();
        Channel channel6 = new Jiangsu6Channel();
        Channel channel7 = new Jiangsu7Channel();
        Channel channel8 = new Jiangsu8Channel();
        Channel channel9 = new Jiangsu9Channel();
        Channel channel10 = new Jiangsu10Channel();
        Channel channel11 = new Jiangsu11Channel();


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
        return channel.getSource(uri).toString();
    }
}
