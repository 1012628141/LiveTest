package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.YichengStvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/9/29.
 */
public class YichengStvChannel extends Channel {
    private static final String CHANNEL_ID = "stv_yicheng";

    public YichengStvChannel() {
        channelId = CHANNEL_ID;
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new YichengStvSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
