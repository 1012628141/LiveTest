package com.readyidu.source.local.sichuan.lvzhou.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 17/6/9.
 */

public class WeblzSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 300;

    public WeblzSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        // 优先从缓存中取
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String myntvDom = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_WEBLZ_1:
                    myntvDom = HttpUtil.httpGet("http://www.weblz.com.cn/video/live.html", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_WEBLZ_2:
                    myntvDom = HttpUtil.httpGet("http://www.weblz.com.cn/video/live2.html", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_WEBLZ_3:
                    myntvDom = HttpUtil.httpGet("http://www.weblz.com.cn/video/live3.html", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_WEBLZ_4:
                    myntvDom = HttpUtil.httpGet("http://www.weblz.com.cn/video/live4.html", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                default:
                    break;
            }

            if (!NullUtil.isNullObject(myntvDom)) {
                Pattern pattern = Pattern.compile("http://vod.luzhoutv.com/.*->video/mp4");
                Matcher matcher = pattern.matcher(myntvDom);
                if (matcher.find()) {
                    cacheSource = matcher.group(0);
                    cacheSource = cacheSource.replace("->video/mp4", "");
                    CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                    return cacheSource;
                }
            }
        } else {
            return cacheSource;
        }
        return null;
    }
}
