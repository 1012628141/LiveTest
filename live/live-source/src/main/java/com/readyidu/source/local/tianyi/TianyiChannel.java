package com.readyidu.source.local.tianyi;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.CNTVSource;
import com.readyidu.source.local.tianyi.source.TianyiSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/9/18.
 */
public class TianyiChannel extends Channel {
    private static final String CHANNEL_ID = "tianyi";
    public TianyiChannel() {
        channelId = CHANNEL_ID;
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new TianyiSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
