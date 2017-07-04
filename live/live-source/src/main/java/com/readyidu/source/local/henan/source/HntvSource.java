package com.readyidu.source.local.henan.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/25.
 */
public class HntvSource extends Source {

    public HntvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String hntvStv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_HNTV_1:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=136");
                break;
            case SourceConstants.SOURCE_HNTV_2:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=137");
                break;
            case SourceConstants.SOURCE_HNTV_3:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=138");
                break;
            case SourceConstants.SOURCE_HNTV_4:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=139");
                break;
            case SourceConstants.SOURCE_HNTV_5:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=140");
                break;
            case SourceConstants.SOURCE_HNTV_6:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=141");
                break;
            case SourceConstants.SOURCE_HNTV_7:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=142");
                break;
            case SourceConstants.SOURCE_HNTV_8:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=143");
                break;
            case SourceConstants.SOURCE_HNTV_9:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=144");
                break;
            case SourceConstants.SOURCE_HNTV_10:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=145");
                break;
            case SourceConstants.SOURCE_HNTV_11:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=146");
                break;
            case SourceConstants.SOURCE_HNTV_12:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=147");
                break;
            case SourceConstants.SOURCE_HNTV_13:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=148");
                break;
            default:
                break;
        }

        Pattern pattern = Pattern.compile("http://live.hntv.tv:\\d+/live/live\\d+/500k/tzwj_video.m3u8\\?KEY1=[a-z0-9]+&KEY2=[a-z0-9]+");
        Matcher matcher = pattern.matcher(hntvStv);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }
}
