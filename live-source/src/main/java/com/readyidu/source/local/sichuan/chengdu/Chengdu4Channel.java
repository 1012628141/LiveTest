package com.readyidu.source.local.sichuan.chengdu;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.sichuan.chengdu.source.CditvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Chengdu4Channel extends Channel {

    private static final String CHANNEL_ID = "chengdu4";

    public Chengdu4Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CditvSource(uri.getSource(),uri.getSourceIndex());
        if (!NullUtil.isNullObject(source.toString())) {
            return source;
        }
        return null;
    }
}
