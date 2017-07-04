package com.readyidu.source.local.jilin.jilin;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by ypf on 2017/6/27.
 */
public class JilinLocal extends Local {

    private static final String MANAGER_ID = "jilin";

    public JilinLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Jilin1Channel();
        Channel channel2 = new Jilin2Channel();
        Channel channel3 = new Jilin3Channel();
        Channel channel4 = new Jilin4Channel();
        Channel channel5 = new Jilin5Channel();
        Channel channel6 = new Jilin6Channel();
        Channel channel7 = new Jilin7Channel();
        Channel channel8 = new Jilin8Channel();
        Channel channel9 = new Jilin9Channel();


        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
        channels.put(channel3.getId(), channel3);
        channels.put(channel4.getId(), channel4);
        channels.put(channel5.getId(), channel5);
        channels.put(channel6.getId(), channel6);
        channels.put(channel7.getId(), channel7);
        channels.put(channel8.getId(), channel8);
        channels.put(channel9.getId(), channel9);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
