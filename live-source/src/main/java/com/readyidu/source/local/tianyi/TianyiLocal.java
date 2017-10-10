package com.readyidu.source.local.tianyi;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by 123 on 2017/9/18.
 */
public class TianyiLocal extends Local {
    private static final String MANAGER_ID = "movie";

    public TianyiLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();
        Channel tianyiChannel = new TianyiChannel();
        channels.put(tianyiChannel.getId(),tianyiChannel);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
