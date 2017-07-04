package com.readyidu.source.local.sichuan.mianyang;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.sichuan.mianyang.source.MyntvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Mainyang4Channel extends Channel {

    private static final String CHANNEL_ID = "mianyang4";

    public Mainyang4Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new MyntvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
