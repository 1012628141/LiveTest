package com.readyidu.source.local.jilin.jilin;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.jilin.jilin.source.JltvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/22.
 */
public class Jilin1Channel extends Channel {

    private static final String CHANNEL_ID = "jilintv1";

    public Jilin1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new JltvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
    public static void main(String[] args) {
        Source source = new JltvSource("source_jl_jl1");
        source.toString();
        System.out.print(source.toString());
    }
}
