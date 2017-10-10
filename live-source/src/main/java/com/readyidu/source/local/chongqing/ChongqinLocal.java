package com.readyidu.source.local.chongqing;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.changzhou.*;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/24.
 */
public class ChongqinLocal extends Local {

    private static final String MANAGER_ID = "chongqing";

    public ChongqinLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Chongqing1Channel();
        Channel channel2 = new Chongqing2Channel();
        Channel channel3 = new Chongqing3Channel();
        Channel channel4 = new Chongqing4Channel();
        Channel channel5 = new Chongqing5Channel();
        Channel channel6 = new Chongqing6Channel();
        Channel channel7 = new Chongqing7Channel();
        Channel channel8 = new Chongqing8Channel();
        Channel channel9 = new Chongqing9Channel();
        Channel channel10 = new Chongqing10Channel();
        Channel channel11 = new Chongqing11Channel();
        Channel channel12 = new Chongqing12Channel();

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
        channels.put(channel12.getId(), channel12);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
