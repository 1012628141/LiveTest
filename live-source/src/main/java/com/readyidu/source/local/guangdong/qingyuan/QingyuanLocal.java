package com.readyidu.source.local.guangdong.qingyuan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.guangdong.zhanjiang.Zhanjiang1Channel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class QingyuanLocal extends Local {

    private static final String MANAGER_ID = "qingyuan";

    public QingyuanLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new Qingyuan1Channel();
        Channel channel2 = new Qingyuan2Channel();

        channels.put(channel1.getId(), channel1);
        channels.put(channel2.getId(), channel2);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
