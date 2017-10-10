package com.readyidu.source.local.zhejiang.shengzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.zhejiang.shangyu.SYBTV1Channel;
import com.readyidu.source.local.zhejiang.shangyu.SYBTV2Channel;
import com.readyidu.source.local.zhejiang.shangyu.SYBTV3Channel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class ShengzhouLocal extends Local {

    private static final String MANAGER_ID = "shengzhou";

    public ShengzhouLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel channel1 = new SZTTKK1Channel();

        channels.put(channel1.getId(), channel1);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
