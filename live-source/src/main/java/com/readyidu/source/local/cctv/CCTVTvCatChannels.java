package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;

import com.readyidu.source.local.cctv.source.TvCatSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/8/3.
 */
public class CCTVTvCatChannels extends Channel {
    public CCTVTvCatChannels() {channelId = "cctv_tvcat";}

    @Override
    public Source getSource(SourceUri uri) {
        Source source=new TvCatSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
