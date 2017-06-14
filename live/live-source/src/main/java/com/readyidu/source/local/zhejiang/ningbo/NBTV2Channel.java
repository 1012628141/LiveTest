package com.readyidu.source.local.zhejiang.ningbo;

        import com.readyidu.source.base.Channel;
        import com.readyidu.source.base.Source;
        import com.readyidu.source.local.zhejiang.ningbo.source.NbtvSource;
        import com.readyidu.source.protocol.SourceUri;
        import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class NBTV2Channel extends Channel {

    private static final String CHANNEL_ID = "nbtv2";

    public NBTV2Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new NbtvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
