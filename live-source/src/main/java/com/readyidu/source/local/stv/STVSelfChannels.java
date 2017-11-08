package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.CCTVSelfSource;
import com.readyidu.source.local.stv.source.STVSelfSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/28.
 */
public class STVSelfChannels extends Channel {
    public STVSelfChannels() {
        channelId = "cctv_lzd";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new STVSelfSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
