package com.readyidu.source.local.anhui;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.anhui.source.AhtvSource;
import com.readyidu.source.local.chongqing.source.CqtvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by chenyihao on 2017/6/27.
 */
public class Anhui4Channel extends Channel{
    private static final String CHANNEL_ID = "anhuitv4";

    public Anhui4Channel() {
        channelId = CHANNEL_ID;
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new AhtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
