package com.readyidu.source.local.zhejiang.deqing.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import com.readyidu.util.PlayerEngineUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class YingxiSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public YingxiSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_YINGXI_YINGXITV1:
                    cacheSource = HttpUtil.httpGet("http://www.yingxi.tv/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2Eyingxi%2Etv%2Ffolder2%2Ffolder13%2F&hash=7d6ecc6d86f37e18a114f6056c232d38&url=http%3A%2F%2Flive%2Eyingxi%2Etv%2Fxwzh%2Fsd%2Flive%2Em3u8&time=1497523364032&playerVersion=4%2E03");
                    break;
                case SourceConstants.SOURCE_YINGXI_YINGXITV2:
                    cacheSource = HttpUtil.httpGet("http://www.yingxi.tv/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2Eyingxi%2Etv%2Ffolder2%2Ffolder14%2F&url=http%3A%2F%2Flive%2Eyingxi%2Etv%2Fylpd%2Fsd%2Flive%2Em3u8&time=1497523748024&playerVersion=4%2E03&hash=0db1a299da25007377fcf02de4bd3d03");
                    break;
                default:
                    break;
            }
            if (NullUtil.isNullObject(cacheSource)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, PlayerEngineUtil.addEngine(cacheSource, PlayerEngineUtil.Engine.ENGINE_EXO), CHACHE_TIMEOUT);
                return cacheSource;
            }
        } else {
            return cacheSource;
        }
    }
}
