package com.readyidu.source.local.guangdong.zhaoqing;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.guangdong.foshan.Foshan1Channel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class ZhaoqingLocal extends Local {

    private static final String MANAGER_ID = "zhaoqing";

    public ZhaoqingLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Zhaoqing1Channel();

        channels.put(channel1.getId(), channel1);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
