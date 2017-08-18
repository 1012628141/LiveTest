package com.readyidu.source.local.zhejiang.ningbo.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.service.CacheService;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 17/6/9.
 */

public class NbtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1200;

    public NbtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        String nbtvDom = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_NBTV_NBTV1:
                nbtvDom = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv1");
                break;
            case SourceConstants.SOURCE_NBTV_NBTV2:
                nbtvDom = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv2");
                break;
            case SourceConstants.SOURCE_NBTV_NBTV3:
                nbtvDom = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv3");
                break;
            case SourceConstants.SOURCE_NBTV_NBTV4:
                nbtvDom = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv4");
                break;
            case SourceConstants.SOURCE_NBTV_NBTV5:
                nbtvDom = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv5");
                break;
            case SourceConstants.SOURCE_NBTV_NBTV6:
                nbtvDom = HttpUtil.httpGet("http://m.nbtv.cn/mob/live/index.html?videoPath=nbtv6");
            default:
                break;
        }

        if (!NullUtil.isNullObject(nbtvDom)) {
            Pattern pattern = Pattern.compile("http://hls.nbtv.cn/[a-z0-9]+/[0-9a-z]+/live/nbtv[1-6]_md/playlist.m3u8");
            Matcher matcher = pattern.matcher(nbtvDom);
            if (matcher.find()) {
                cacheSource = matcher.group(0);
                return cacheSource;
            }
        }
        return null;
    }
}
