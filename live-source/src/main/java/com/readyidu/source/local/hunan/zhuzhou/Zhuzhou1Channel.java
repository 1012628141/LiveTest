package com.readyidu.source.local.hunan.zhuzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.hunan.zhuzhou.source.ZztvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/22.
 */
public class Zhuzhou1Channel extends Channel {

    private static final String CHANNEL_ID = "zhuzhoutv1";

    public Zhuzhou1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new ZztvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
