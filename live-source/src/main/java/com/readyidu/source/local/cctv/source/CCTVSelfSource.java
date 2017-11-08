package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/28.
 */
public class CCTVSelfSource extends Source {
    public CCTVSelfSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String channelName = null;
        switch (sourceId)
        {
            case SourceConstants.SOURCE_LZD_CCTV1:
                channelName = "cctv-1";
                break;
            case SourceConstants.SOURCE_LZD_CCTV2:
                channelName = "cctv-2";
                break;
            case SourceConstants.SOURCE_LZD_CCTV3:
                channelName = "cctv-3";
                break;
            case SourceConstants.SOURCE_LZD_CCTV4:
                channelName = "cctv-4";
                break;
            case SourceConstants.SOURCE_LZD_CCTV5:
                channelName = "cctv-5";
                break;
            case SourceConstants.SOURCE_LZD_CCTV6:
                channelName = "cctv-6";
                break;
            case SourceConstants.SOURCE_LZD_CCTV7:
                channelName = "cctv-7";
                break;
            case SourceConstants.SOURCE_LZD_CCTV8:
                channelName = "cctv-8";
                break;
            case SourceConstants.SOURCE_LZD_CCTV9:
                channelName = "cctv-9";
                break;
            case SourceConstants.SOURCE_LZD_CCTV10:
                channelName = "cctv-10";
                break;
            case SourceConstants.SOURCE_LZD_CCTV11:
                channelName = "cctv-11";
                break;
            case SourceConstants.SOURCE_LZD_CCTV12:
                channelName = "cctv-12";
                break;
            case SourceConstants.SOURCE_LZD_CCTV13:
                channelName = "cctv-13";
                break;
            case SourceConstants.SOURCE_LZD_CCTV14:
                channelName = "cctv-14";
                break;
            case SourceConstants.SOURCE_LZD_CCTV15:
                channelName = "cctv-15";
                break;
            case SourceConstants.SOURCE_LZD_CCTV5ADD:
                channelName = "cctv5p";
                break;
        }
        //http://114.113.90.49:5912/lvds/live/cctv-2/live.m3u8
        if (!NullUtil.isNullObject(channelName))
        {
            return "http://183.131.16.143:5913/lvds/live/" + channelName + "/live.m3u8$1";
        }
        return null;
    }
}
