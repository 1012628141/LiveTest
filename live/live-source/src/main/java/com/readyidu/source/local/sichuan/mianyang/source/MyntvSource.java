package com.readyidu.source.local.sichuan.mianyang.source;

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

public class MyntvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public MyntvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        // 优先从缓存中取
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String myntvDom = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_MYNTV_1:
                    myntvDom = HttpUtil.httpGet("http://myntv.cn/Article/wldst/mytv1.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_2:
                    myntvDom = HttpUtil.httpGet("http://myntv.cn/Article/wldst/mytv2.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_3:
                    myntvDom = HttpUtil.httpGet("http://myntv.cn/Article/wldst/mytv3.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_4:
                    myntvDom = HttpUtil.httpGet("http://myntv.cn/Article/wldst/mytv4.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_5:
                    myntvDom = HttpUtil.httpGet("http://www.myntv.cn/Article/wldst/dyjy.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_6:
                    myntvDom = HttpUtil.httpGet("http://www.myntv.cn/Article/wldst/xnc.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_7:
                    myntvDom = HttpUtil.httpGet("http://www.myntv.cn/Article/wldst/myly.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_8:
                    myntvDom = HttpUtil.httpGet("http://www.myntv.cn/Article/wldst/myjt.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                case SourceConstants.SOURCE_MYNTV_9:
                    myntvDom = HttpUtil.httpGet("http://www.myntv.cn/Article/wldst/zhxx.asp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    break;
                default:
                    break;
            }

            if (!NullUtil.isNullObject(myntvDom)) {
                Pattern pattern = Pattern.compile("http://cdn1.myntv.cn/.*->video/mp4");
                Matcher matcher = pattern.matcher(myntvDom);
                if (matcher.find()) {
                    cacheSource = matcher.group(0);
                    cacheSource = cacheSource.replace("->video/mp4", "").replace("/playlist.m3u8","").replace("andwsTime=", "&wsTime=");
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
