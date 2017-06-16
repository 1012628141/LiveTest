package com.readyidu.source.local.zhejiang.pinghu;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.zhejiang.hangzhou.source.HuluSource;
import com.readyidu.source.local.zhejiang.pinghu.source.XigoSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class XIGO1Channel extends Channel {

    private static final String CHANNEL_ID = "xigo1";

    public XIGO1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new XigoSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
