package com.readyidu.source.local.heilongjiang.haerbin;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.heilongjiang.haerbin.source.HebtvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/27.
 */
public class Haerbin5Channel extends Channel {

    private static final String CHANNEL_ID = "haerbintv5";

    public Haerbin5Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new HebtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
