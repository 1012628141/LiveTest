package com.readyidu.source.local.jiangsu.taizhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.jiangsu.yancheng.Yancheng1Channel;
import com.readyidu.source.local.jiangsu.yancheng.Yancheng2Channel;
import com.readyidu.source.local.jiangsu.yancheng.Yancheng3Channel;
import com.readyidu.source.local.jiangsu.yancheng.Yancheng4Channel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class TaizhouLocal extends Local {

    private static final String MANAGER_ID = "taizhou";

    public TaizhouLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Taizhou1Channel();
        Channel channel2 = new Taizhou2Channel();
        Channel channel3 = new Taizhou3Channel();

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
