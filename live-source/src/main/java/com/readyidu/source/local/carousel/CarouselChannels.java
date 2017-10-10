package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.carousel.source.CarouselSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by BNDYH on 2017/8/16.
 */
public class CarouselChannels extends Channel {
    public CarouselChannels() {
        channelId = "carousel_migu";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CarouselSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
