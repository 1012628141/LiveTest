package com.readyidu.source.local.zhejiang.hangzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class HangzhouLocal extends Local {

    private static final String MANAGER_ID = "hangzhou";

    public HangzhouLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();
        Channel channel1 = new HTV1Channel();
        Channel channel2 = new HTV2Channel();
        Channel channel3 = new HTV3Channel();
        Channel channel4 = new HTV4Channel();
        Channel channel5 = new HTV5Channel();
        Channel channel6 = new HTV6Channel();
        Channel channel7 = new Xiaoshan1Channel();
        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
