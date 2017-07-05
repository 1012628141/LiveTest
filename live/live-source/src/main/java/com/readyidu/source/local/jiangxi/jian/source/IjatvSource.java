package com.readyidu.source.local.jiangxi.jian.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class IjatvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public IjatvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_IJATV_1:
                    cacheSource = HttpUtil.httpGet("http://www.ijatv.com/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Eijatv%2Ecom%2Fjatv1%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Eijatv%2Ecom%2Flive%2F&hash=88e5a280e36804be3c117d4ef717db55");
                    break;
                case SourceConstants.SOURCE_IJATV_2:
                    cacheSource = HttpUtil.httpGet("http://www.ijatv.com/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Eijatv%2Ecom%2Fjatv2%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Eijatv%2Ecom%2Flive%2Fjatv2%2F&hash=905a706b338e8088783b37bf88d0590c");
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
