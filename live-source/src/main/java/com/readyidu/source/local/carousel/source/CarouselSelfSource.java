package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/11/13.
 */
public class CarouselSelfSource extends Source {
    public CarouselSelfSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String channelName = null;
        switch (sourceId)
        {
            case SourceConstants.SOURCE_LZD_ZXDP:
                channelName = "lunbo";
                break;
            case SourceConstants.SOURCE_LZD_GNWJDDY:
                channelName = "gnwjddy";
                break;
            case SourceConstants.SOURCE_LZD_DHDY:
                channelName = "dhdy";
                break;
        }
        //http://114.113.90.49:5912/lvds/live/cctv-2/live.m3u8
        if (!NullUtil.isNullObject(channelName))
        {
            return "http://60.190.249.8/vod/" + channelName + "/index.m3u8$3";
        }
        return null;
    }
}
