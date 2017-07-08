package com.readyidu.source.local.zhejiang.pinghu.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

/**
 * Created by yuzhang on 17/6/9.
 */
public class XigoSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public XigoSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_XIGO_XIGOTV1:
                    cacheSource = HttpUtil.httpGet("http://www.xigo.tv/m2o/player/drm.php?url=http%3A%2F%2Flive1%2Exigo%2Etv%2Fxwzh%2Fsd%2Flive%2Em3u8&time=1497522462969&refererurl=http%3A%2F%2Fv%2Exigo%2Etv%2F&hash=38799569cf5b2ce5c54f99a359def88c&playerVersion=4%2E03");
                    break;
                case SourceConstants.SOURCE_XIGO_XIGOTV2:
                    cacheSource = HttpUtil.httpGet("http://www.xigo.tv/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Flive1%2Exigo%2Etv%2Fmsxs%2Fsd%2Flive%2Em3u8&time=1497522947572&hash=fd47daf715494b11db5c1d49b93442f7&refererurl=http%3A%2F%2Fv%2Exigo%2Etv%2Fmsxx%2F");
                    break;
                default:
                    break;
            }
            if (NullUtil.isNullObject(cacheSource)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                return cacheSource;
            }
        } else {
            return cacheSource;
        }
    }
}
