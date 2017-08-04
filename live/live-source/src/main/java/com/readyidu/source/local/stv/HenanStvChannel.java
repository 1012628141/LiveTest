package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.HntvSource;
import com.readyidu.source.local.stv.source.Shiting5Source;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class HenanStvChannel extends Channel {

    private static final String CHANNEL_ID = "henanstv";

    public HenanStvChannel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        System.out.println("**********henanshiting");
        Source source = new HntvSource(uri.getSource());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        System.out.println("**********henanshiting");
        source = new Shiting5Source(uri.getSource());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        return null;
    }
}
