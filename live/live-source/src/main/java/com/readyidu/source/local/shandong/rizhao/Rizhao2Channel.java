package com.readyidu.source.local.shandong.rizhao;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.shandong.rizhao.source.RztvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/27.
 */
public class Rizhao2Channel extends Channel {

    private static final String CHANNEL_ID = "rizhaotv2";

    public Rizhao2Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new RztvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
