package com.readyidu.source.local.guangdong.zhaoqing;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.guangdong.zhaoqing.source.GrtnSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Zhaoqing1Channel extends Channel {

    private static final String CHANNEL_ID = "zhaoqing1";

    public Zhaoqing1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new GrtnSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
