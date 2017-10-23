package com.readyidu.source.local.cctv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.cctv.source.IPTVSource;
import com.readyidu.source.local.cctv.source.NETTVSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/17.
 */
public class IPTVChannels extends Channel {
    public IPTVChannels() { channelId = "cctv_iptv";}

    @Override
    public Source getSource(SourceUri uri) {
        Source source= new IPTVSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
