package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.MgtvSource;
import com.readyidu.source.local.stv.source.Shiting5Source;
import com.readyidu.source.local.stv.source.TvCatSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class HunanStvChannel extends Channel {

    private static final String CHANNEL_ID = "hunanstv";

    public HunanStvChannel() {
        channelId = CHANNEL_ID;
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new Shiting5Source(uri.getSource());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        source = new MgtvSource(uri.getSource(),uri.getSourceIndex());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        source =new TvCatSource(uri.getSource());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        return null;
    }
}
