package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.carousel.source.LeSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/8/10.
 */
public class LeCarousel extends Channel
{
    public LeCarousel() {
        channelId = "le_carousel";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new LeSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
