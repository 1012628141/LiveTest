package com.readyidu.source.local.henan.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/25.
 */
public class HntvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public HntvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
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
                cacheSource = matcher.group(0);
                CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                return cacheSource;
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
