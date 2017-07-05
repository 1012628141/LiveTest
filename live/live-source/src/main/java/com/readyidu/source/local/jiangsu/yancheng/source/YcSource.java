package com.readyidu.source.local.jiangsu.yancheng.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class YcSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public YcSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_0515_YC1:
                    cacheSource = HttpUtil.httpGet("http://www.0515yc.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2E0515yc%2Ecn%2Fyctv1%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2E0515yc%2Ecn%2Ftvlook%2Ffolder76%2F&hash=5cd5326a9cf36a4c4afb4a4b0053b412&playerVersion=4%2E03&time=1497865931458", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_0515_YC2:
                    cacheSource = HttpUtil.httpGet("http://www.0515yc.cn/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2E0515yc%2Ecn%2Ftvlook%2Ffolder77%2F&url=http%3A%2F%2Fstream%2E0515yc%2Ecn%2Fyctv2%2Fsd%2Flive%2Em3u8&hash=2ae00b2f0507db4afbf23b4e9235c7de&time=1497866988884&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_0515_YC3:
                    cacheSource = HttpUtil.httpGet("http://www.0515yc.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2E0515yc%2Ecn%2Fyctv3%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2E0515yc%2Ecn%2Ftvlook%2Ffolder78%2F&hash=de81b0c1bdce1294b31007ee464d853f&playerVersion=4%2E03&time=1497867059346", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_0515_YC4:
                    cacheSource = HttpUtil.httpGet("http://www.0515yc.cn/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2E0515yc%2Ecn%2Ftvlook%2Ffolder178%2F&playerVersion=4%2E03&url=http%3A%2F%2Fstream%2E0515yc%2Ecn%2Fyctv4%2Fsd%2Flive%2Em3u8&time=1497867110274&hash=0d3ca30e91554c1dee4f1db4af331544", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
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
