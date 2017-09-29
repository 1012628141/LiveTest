package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.carousel.source.WTVCarouselSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class WtvCarouseChannels extends Channel {
    public WtvCarouseChannels(){
        channelId = "carouse_wtv";}
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new WTVCarouselSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
