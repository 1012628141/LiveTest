package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.carousel.source.CarouselCCTVSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/12/22.
 */
public class CarouselCCTVChannel extends Channel {
    public CarouselCCTVChannel() {
        channelId = "carousel_cctv";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new CarouselCCTVSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
