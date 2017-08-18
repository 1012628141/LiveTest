package com.readyidu.source.local.hubei.jingmen.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by Administrator on 2017/6/26.
 */
public class JmtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1200;

    public JmtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_HBTV_JMTV1:
                cacheSource = HttpUtil.httpGet("http://www.jmtv.com.cn/m2o/player/drm.php?url=http%3A%2F%2Flive%2Ejmtv%2Ecom%2Ecn%2Fxwzh%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                break;
            case SourceConstants.SOURCE_HBTV_JMTV2:
                cacheSource = HttpUtil.httpGet("http://www.jmtv.com.cn/m2o/player/drm.php?url=http%3A%2F%2Flive%2Ejmtv%2Ecom%2Ecn%2Fngpd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
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
