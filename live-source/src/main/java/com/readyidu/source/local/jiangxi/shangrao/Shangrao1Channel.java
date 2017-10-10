package com.readyidu.source.local.jiangxi.shangrao;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.jiangxi.shangrao.source.Zb0793Source;
import com.readyidu.source.local.jiangxi.source.JxtvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 17/6/24.
 */
public class Shangrao1Channel extends Channel {

    private static final String CHANNEL_ID = "shangrao1";

    public Shangrao1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new Zb0793Source(uri.getSource(), uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
