package com.readyidu.source.local.sichuan.lvzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.sichuan.lvzhou.source.WeblzSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Luzhou3Channel extends Channel {

    private static final String CHANNEL_ID = "luzhou3";

    public Luzhou3Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new WeblzSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
