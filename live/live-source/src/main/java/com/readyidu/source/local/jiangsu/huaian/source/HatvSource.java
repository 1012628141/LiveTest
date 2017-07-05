package com.readyidu.source.local.jiangsu.huaian.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by ypf on 2017/6/20.
 */
public class HatvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public HatvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_HA_BCTV1:
                    cacheSource = HttpUtil.httpGet("http://www.habctv.com/m2o/player/drm.php?time=1497944545880&url=http%3A%2F%2Fstream%2Ehabctv%2Ecom%2Fxwzh%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03&refererurl=http%3A%2F%2Fwww%2Ehabctv%2Ecom%2Flive%2Fxwzhpd%2F&hash=bbc07165f4cf784a7550aa8d81b7f079", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_HA_BCTV2:
                    cacheSource = HttpUtil.httpGet("http://www.habctv.com/m2o/player/drm.php?time=1497944630146&url=http%3A%2F%2Fstream%2Ehabctv%2Ecom%2Fhagg%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03&hash=993a57d451e5f8c4a1b3193799e957a7&refererurl=http%3A%2F%2Fwww%2Ehabctv%2Ecom%2Flive%2Fhaggpd%2F", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_HA_BCTV3:
                    cacheSource = HttpUtil.httpGet("http://www.habctv.com/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2Ehabctv%2Ecom%2Flive%2Fysylpd%2F&time=1497944697182&playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ehabctv%2Ecom%2Fysyl%2Fsd%2Flive%2Em3u8&hash=bf9c835bec446dc39c20c367f3a8befa", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
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
