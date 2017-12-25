package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.carousel.source.CarouselSelfSource;
import com.readyidu.source.local.carousel.source.WTVCarouselSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/11/13.
 */
public class CarouselSelfChannel extends Channel {
    public CarouselSelfChannel() {
        channelId = "carousel_lzd";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CarouselSelfSource(uri.getSource(),uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
