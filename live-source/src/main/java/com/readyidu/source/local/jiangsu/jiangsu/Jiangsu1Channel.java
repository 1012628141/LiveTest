package com.readyidu.source.local.jiangsu.jiangsu;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.jiangsu.jiangsu.source.JstvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class Jiangsu1Channel extends Channel {

    private static final String CHANNEL_ID = "jiangsu1";

    public Jiangsu1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new JstvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
    public static void main(String[] args) {
        Source source = new JstvSource("source_jstv_js1");
        System.out.print(source.toString());
    }
}
