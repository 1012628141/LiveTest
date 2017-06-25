package com.readyidu.source.local.jiangxi;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.jiangxi.source.JxtvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 17/6/24.
 */
public class Jiangxi6Channel extends Channel {

    private static final String CHANNEL_ID = "jiangxi6";

    public Jiangxi6Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new JxtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
