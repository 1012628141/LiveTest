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
            case SourceConstants.SOURCE_HNTV_STV1:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=136");
                break;
            case SourceConstants.SOURCE_HNTV_STV2:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=137");
                break;
            case SourceConstants.SOURCE_HNTV_STV3:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=138");
                break;
            case SourceConstants.SOURCE_HNTV_STV4:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=139");
                break;
            case SourceConstants.SOURCE_HNTV_STV5:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=140");
                break;
            case SourceConstants.SOURCE_HNTV_STV6:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=141");
                break;
            case SourceConstants.SOURCE_HNTV_STV7:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=142");
                break;
            case SourceConstants.SOURCE_HNTV_STV8:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=143");
                break;
            case SourceConstants.SOURCE_HNTV_STV9:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=144");
                break;
            case SourceConstants.SOURCE_HNTV_STV10:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=145");
                break;
            case SourceConstants.SOURCE_HNTV_STV11:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=146");
                break;
            case SourceConstants.SOURCE_HNTV_STV12:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=147");
                break;
            case SourceConstants.SOURCE_HNTV_STV13:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=148");
                break;
            default:
                break;
        }
        Pattern pattern = Pattern.compile("http://live.hntv.tv:9601/live/live\\d+/500k/tzwj_video.m3u8\\?KEY1=[a-z0-9]+&KEY2=[a-z0-9]+");
        Matcher matcher = pattern.matcher(hntvStv);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }
}
