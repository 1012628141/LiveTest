package com.readyidu.source.local.zhejiang.hangzhou;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.zhejiang.hangzhou.source.XianghuSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/14.
 */
public class XiaoshanChannel extends Channel{

    private static final String CHANNEL_ID = "xiaoshan";

    public XiaoshanChannel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new XianghuSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
