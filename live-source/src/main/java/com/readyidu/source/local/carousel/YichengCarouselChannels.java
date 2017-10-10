package com.readyidu.source.local.carousel;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.carousel.source.WTVCarouselSource;
import com.readyidu.source.local.carousel.source.YichengCarouselSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/9.
 */
public class YichengCarouselChannels extends Channel {
    public YichengCarouselChannels(){
        channelId = "carouse_yicheng";}
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new YichengCarouselSource(uri.getSource());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source;
    }
}
