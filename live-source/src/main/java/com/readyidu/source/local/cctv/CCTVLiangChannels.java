package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.LiangTVSource;
import com.readyidu.source.local.cctv.source.MiguSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/9/20.
 */
public class CCTVLiangChannels extends Channel {
    public CCTVLiangChannels() {
        channelId = "cctv_liang";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new LiangTVSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
