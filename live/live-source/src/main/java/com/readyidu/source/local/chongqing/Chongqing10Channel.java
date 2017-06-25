package com.readyidu.source.local.chongqing;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.chongqing.source.CqtvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/24.
 */
public class Chongqing10Channel extends Channel {

    private static final String CHANNEL_ID = "chongqingtv10";

    public Chongqing10Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CqtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
