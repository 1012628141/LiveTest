package com.readyidu.source.local.cctv;


import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.CCTVFengcaiSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class CCTVFengcaiChannels extends Channel{
    public CCTVFengcaiChannels() {
        channelId = "cctv_fengcai";
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source= new CCTVFengcaiSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
