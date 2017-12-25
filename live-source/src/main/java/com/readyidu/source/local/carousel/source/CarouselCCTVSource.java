package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/12/22.
 */
public class CarouselCCTVSource extends Source {

    public CarouselCCTVSource(String sourceId) {
        super(sourceId);
    }
    @Override
    protected String source() {
        String channelName ;
        try {
            channelName = sourceId.substring(sourceId.indexOf("_")+1);
            if (!NullUtil.isNullObject(channelName))
            {
                return "http://124.160.117.36:5913/lvds/live/"+channelName+"/live.m3u8$3";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
