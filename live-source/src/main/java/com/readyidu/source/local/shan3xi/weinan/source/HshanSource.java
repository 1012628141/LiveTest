package com.readyidu.source.local.shan3xi.weinan.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

/**
 * Created by yuzhang on 2017/6/29.
 */
public class HshanSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public HshanSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_HSNAN_1:
                cacheSource = HttpUtil.httpGet("http://ww.hshan.com/m2o/player/drm.php?hash=428e763602ca39b70033e83c0c628c9b&refererurl=http%3A%2F%2Flive%2Ehshan%2Ecom%2Fxwpd%2F&url=http%3A%2F%2Fstream1%2Ehshan%2Ecom%2Fxwzh%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                break;
            case SourceConstants.SOURCE_HSNAN_2:
                cacheSource = HttpUtil.httpGet("http://ww.hshan.com/m2o/player/drm.php?refererurl=http%3A%2F%2Flive%2Ehshan%2Ecom%2Fhspd%2F&url=http%3A%2F%2Fstream1%2Ehshan%2Ecom%2Fhspd%2Fsd%2Flive%2Em3u8&hash=b0c3987f95479db951eeb78e8b0bc323&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                break;
            case SourceConstants.SOURCE_HSNAN_3:
                cacheSource = HttpUtil.httpGet("http://ww.hshan.com/m2o/player/drm.php?refererurl=http%3A%2F%2Flive%2Ehshan%2Ecom%2Fdspd%2F&hash=73396199a341600b86c2d3422be6bbdb&url=http%3A%2F%2Fstream1%2Ehshan%2Ecom%2Fdspd%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                break;
            case SourceConstants.SOURCE_HSNAN_4:
                cacheSource = HttpUtil.httpGet("http://ww.hshan.com/m2o/player/drm.php?refererurl=http%3A%2F%2Flive%2Ehshan%2Ecom%2Fggpd%2F&hash=810d628e9c60ea67e7dd28b77bfaeb58&url=http%3A%2F%2Fstream1%2Ehshan%2Ecom%2Fggpd%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                break;
            default:
                break;
        }
        if (NullUtil.isNullObject(cacheSource)) {
            return null;
        } else {
            return cacheSource;
        }
    }
}
