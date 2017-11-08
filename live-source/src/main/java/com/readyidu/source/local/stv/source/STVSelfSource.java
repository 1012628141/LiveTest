package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/28.
 */
public class STVSelfSource extends Source {
    public STVSelfSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String channelName = null;
        switch (sourceId)
        {
            case SourceConstants.SOURCE_LZD_AHWS:
                channelName = "ahws";
                break;
            case SourceConstants.SOURCE_LZD_BJWS:
                channelName = "bjws";
                break;
            case SourceConstants.SOURCE_LZD_CQWS:
                channelName = "cqws";
                break;
            case SourceConstants.SOURCE_LZD_DFWS:
                channelName = "dfws";
                break;
            case SourceConstants.SOURCE_LZD_DNWS:
                channelName = "dnws";
                break;
            case SourceConstants.SOURCE_LZD_GDWS:
                channelName = "gdws";
                break;
            case SourceConstants.SOURCE_LZD_HUBWS:
                channelName = "hubws";
                break;
            case SourceConstants.SOURCE_LZD_HUNWS:
                channelName = "hunws";
                break;
            case SourceConstants.SOURCE_LZD_JSWS:
                channelName = "jsws";
                break;
            case SourceConstants.SOURCE_LZD_JXWS:
                channelName = "jxws";
                break;
            case SourceConstants.SOURCE_LZD_SCWS:
                channelName = "scws";
                break;
            case SourceConstants.SOURCE_LZD_SDWS:
                channelName = "sdws";
                break;
            case SourceConstants.SOURCE_LZD_SZWS:
                channelName = "szws";
                break;
            case SourceConstants.SOURCE_LZD_ZJWS:
                channelName = "zjws";
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
