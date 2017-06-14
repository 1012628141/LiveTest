package com.readyidu.source.local.zhejiang;

        import com.readyidu.source.base.Channel;
        import com.readyidu.source.base.Source;
        import com.readyidu.source.local.zhejiang.hangzhou.source.HuluSource;
        import com.readyidu.source.local.zhejiang.source.CztvSource;
        import com.readyidu.source.protocol.SourceUri;
        import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
public class CZTV1Channel extends Channel {

    private static final String CHANNEL_ID = "cztv1";

    public CZTV1Channel() {
        channelId = CHANNEL_ID;
    }

    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CztvSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
