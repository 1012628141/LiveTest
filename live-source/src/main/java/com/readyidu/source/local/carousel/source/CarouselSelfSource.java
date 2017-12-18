package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/11/13.
 */
public class CarouselSelfSource extends Source {

    public CarouselSelfSource(String sourceId,int index) {
        super(sourceId, index);
    }
    @Override
    protected String source() {
        String channelName = null;
        int ip ;
        String ipDress = null;
        try {
            channelName = sourceId.substring(sourceId.indexOf("_")+1);
            ip = this.index;
//            ip = sourceId.substring(sourceId.indexOf(":")+1);
//        switch (sourceId)
//        {
//            case SourceConstants.SOURCE_LZD_ZXDP:
//                channelName = "lunbo";
//                break;
//            case SourceConstants.SOURCE_LZD_GNWJDDY:
//                channelName = "gnwjddy";
//                break;
//            case SourceConstants.SOURCE_LZD_DHDY:
//                channelName = "dhdy";
//                break;
//        }
            //http://114.113.90.49:5912/lvds/live/cctv-2/live.m3u8
            switch (ip){
                case SourceConstants.SERVER_NUM_2:
                    ipDress = "live2";
                    break;
                case SourceConstants.SERVER_NUM_3:
                    ipDress = "vod";
                    break;
                case SourceConstants.SERVER_NUM_4:
                    ipDress = "live";
                    break;
                default:
                    ipDress = "vod";
                    break;
            }
            if (!NullUtil.isNullObject(channelName))
            {
                return "http://124.160.117.35/"+ipDress+"/" + channelName + "/index.m3u8$3";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
