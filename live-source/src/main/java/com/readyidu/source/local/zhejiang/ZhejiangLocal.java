package com.readyidu.source.local.zhejiang;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.zhejiang.hangzhou.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class ZhejiangLocal extends Local {

    private static final String MANAGER_ID = "zhejiang";

    public ZhejiangLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel2 = new CZTV2Channel();
        Channel channel3 = new CZTV3Channel();
        Channel channel4 = new CZTV4Channel();
        Channel channel5 = new CZTV5Channel();
        Channel channel6 = new CZTV6Channel();
        Channel channel7 = new CZTV7Channel();
        Channel channel8 = new CZTV8Channel();
        Channel channel9 = new CZTV9Channel();
        Channel channel10 = new CZTV10Channel();
        Channel channel11 = new CZTV11Channel();
        Channel channel12 = new CZTV12Channel();

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
        channels.put(channel12.getId(), channel12);

    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
