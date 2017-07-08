package com.readyidu.source.local.stv.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
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
                case SourceConstants.SOURCE_HNTV_STV:
                    hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=135");
                    break;
                default:
                    break;
            }
            Pattern pattern = Pattern.compile("http://live.hntv.tv:9600/live/live1/500k/tzwj_video.m3u8\\?KEY1=[a-z0-9]+&KEY2=[a-z0-9]+");
            Matcher matcher = pattern.matcher(hntvStv);
            if (matcher.find()) {
                CacheUtil.set(CACHE_NAME + sourceId, matcher.group(0), CHACHE_TIMEOUT);
                return matcher.group(0);
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
