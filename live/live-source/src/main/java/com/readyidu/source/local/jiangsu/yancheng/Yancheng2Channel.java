package com.readyidu.source.local.jiangsu.yancheng;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.jiangsu.changzhou.source.CztvSource;
import com.readyidu.source.local.jiangsu.yancheng.source.YcSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Yancheng2Channel extends Channel {

    private static final String CHANNEL_ID = "yancheng2";

    public Yancheng2Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new YcSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
