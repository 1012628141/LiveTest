package com.readyidu.source.local.jiangsu.taizhou.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class MytaizhouSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public MytaizhouSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_MY_TAIZHOU1:
                    cacheSource = HttpUtil.httpGet("http://www.mytaizhou.net/m2o/player/drmx.php?refererurl=http%3A%2F%2Fwww%2Emytaizhou%2Enet%2Ffolder114%2Ffolder368%2Ffolder369%2F&hash=4c49d8bf5864385abed119f404b1ac64&url=http%3A%2F%2Fstream1%2Emytaizhou%2Enet%2Fxwzh%2Fsd%2Flive%2Em3u8&time=1497867995640&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_MY_TAIZHOU2:
                    cacheSource = HttpUtil.httpGet("http://www.mytaizhou.net/m2o/player/drmx.php?refererurl=http%3A%2F%2Fwww%2Emytaizhou%2Enet%2Ffolder114%2Ffolder368%2Ffolder370%2Findex%2Ehtml&hash=45276d63d91d7fa93b0b27a8645614fc&url=http%3A%2F%2Fstream1%2Emytaizhou%2Enet%2Fjjsh%2Fsd%2Flive%2Em3u8&time=1497868377580&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    break;
                case SourceConstants.SOURCE_MY_TAIZHOU3:
                    cacheSource = HttpUtil.httpGet("http://www.mytaizhou.net/m2o/player/drmx.php?hash=9f814fc77e52771a3f6f569a4cab413c&url=http%3A%2F%2Fstream1%2Emytaizhou%2Enet%2Fysyl%2Fsd%2Flive%2Em3u8&time=1497868441901&refererurl=http%3A%2F%2Fwww%2Emytaizhou%2Enet%2Ffolder114%2Ffolder368%2Ffolder371%2Findex%2Ehtml&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
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
