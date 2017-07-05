package com.readyidu.source.local.jiangsu.changzhou.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class CztvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public CztvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_CZTV_CZ1:
                    cacheSource = HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2F&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvxw%2Fsd%2Flive%2Em3u8&hash=376c42ecbd88beef5ea435da195d480a&time=1497860451916", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_CZTV_CZ2:
                    cacheSource = HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvds%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder33%2F&hash=d19962907d43ef2757894c7ee1b76029&time=1497860828373", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_CZTV_CZ3:
                    cacheSource = HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder34%2F&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvsh%2Fsd%2Flive%2Em3u8&hash=6553ce228f9aa8d422ac603cc84256fc&time=1497861010707", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_CZTV_CZ4:
                    cacheSource = HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvgg%2Fsd%2Flive%2Em3u8&hash=97ea1186ae3a115aa6d8b570355dd1e8&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder35%2F&time=1497861068223", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_CZTV_CZ5:
                    cacheSource = HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?hash=8863bb224d1f3ddd33326a58164f28fe&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Ftwpd%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder498%2F&time=1497861138441&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
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
