package com.readyidu.source.local.hubei.wuhan;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.hubei.wuhan.source.WhtvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/26.
 */
public class Wuhan1Channel extends Channel {

    private static final String CHANNEL_ID = "wuhantv1";

    public Wuhan1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new WhtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
    public static void main(String[] args){
        Source source = new WhtvSource("source_hb_wh1");
        System.out.print(source.toString());
    }
}
