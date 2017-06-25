package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.CNTVSource;
import com.readyidu.source.local.stv.source.Shiting5Source;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class XiamenStvChannel extends Channel {

    private static final String CHANNEL_ID = "xiamenstv";

    public XiamenStvChannel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CNTVSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
