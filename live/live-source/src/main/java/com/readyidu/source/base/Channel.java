package com.readyidu.source.base;

import com.readyidu.source.protocol.SourceUri;

/**
 * Created by yuzhang on 17/6/8.
 */
abstract public class Channel {

    protected String channelId;

    abstract public Source getSource(SourceUri uri);

    public String getId(){
        return channelId;
    }
}
