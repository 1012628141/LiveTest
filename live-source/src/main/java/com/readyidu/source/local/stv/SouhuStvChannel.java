package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.Shiting5Source;
import com.readyidu.source.local.stv.source.SouhuSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/25.
 */
public class SouhuStvChannel extends Channel {
    private static final String CHANNEL_ID = "souhu_stv";
    public SouhuStvChannel() { this.channelId = CHANNEL_ID; }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new SouhuSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
