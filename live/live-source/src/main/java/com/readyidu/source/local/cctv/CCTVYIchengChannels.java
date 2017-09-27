package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.TianyiSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/9/27.
 */
public class CCTVYIchengChannels extends Channel{
    public CCTVYIchengChannels() {
        channelId = "cctv_yicheng";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source=new TianyiSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
