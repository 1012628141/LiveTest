package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.FengmiSource;
import com.readyidu.source.local.stv.source.FengmiStvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class FengmiStvChannel extends Channel{
    public FengmiStvChannel() {
        channelId = "stv_fengmi";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source= new FengmiStvSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
