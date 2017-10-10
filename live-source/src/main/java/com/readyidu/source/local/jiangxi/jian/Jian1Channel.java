package com.readyidu.source.local.jiangxi.jian;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.jiangxi.jian.source.IjatvSource;
import com.readyidu.source.local.zhejiang.hangzhou.source.HuluSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Jian1Channel extends Channel {

    private static final String CHANNEL_ID = "jian1";

    public Jian1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new IjatvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
