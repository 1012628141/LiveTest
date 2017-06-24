package com.readyidu.source.local.guangdong.yunfu;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.guangdong.zhanjiang.Zhanjiang1Channel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class YunfuLocal extends Local {

    private static final String MANAGER_ID = "yunfu";

    public YunfuLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Yunfu1Channel();

        channels.put(channel1.getId(), channel1);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
