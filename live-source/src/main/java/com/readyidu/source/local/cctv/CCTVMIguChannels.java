package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.MiguSource;
import com.readyidu.source.local.cctv.source.Shiting5Source;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/8/15.
 */
public class CCTVMIguChannels extends Channel{
    public CCTVMIguChannels() {
        channelId = "cctv_migu";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new MiguSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
