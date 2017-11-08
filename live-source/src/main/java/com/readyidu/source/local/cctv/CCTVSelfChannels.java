package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.CCTVSelfSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/28.
 */
public class CCTVSelfChannels extends Channel {
    public CCTVSelfChannels() {
        channelId = "cctv_lzd";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CCTVSelfSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
