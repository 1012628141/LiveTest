package com.readyidu.source.local.ICanTv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.stv.ICanStvChannel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

public class ICanLocal extends Local {
    private static final String MANAGER_ID = "ican";

    public ICanLocal(){
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();
        Channel iCanTVChannel = new ICanTvChannel();
        channels.put(iCanTVChannel.getId(),iCanTVChannel);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
