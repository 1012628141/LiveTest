package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.FengmiSource;
import com.readyidu.source.local.cctv.source.YichengSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class CCTVFengmiChannel extends Channel{
    public CCTVFengmiChannel() {
        channelId = "cctv_fengmi";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source= new FengmiSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
