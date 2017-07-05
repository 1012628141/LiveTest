package com.readyidu.source.local.anhui.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by chenyihao on 2017/6/27.
 */
public class AhtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public AhtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String ahtv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_AH_AHTV1:
                    ahtv = HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fjjsh%2Fhd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_AH_AHTV2:
                    ahtv = HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fahgj%2Fhd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_AH_AHTV3:
                    ahtv = HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fyspd%2Fhd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_AH_AHTV4:
                    ahtv = HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fzypd%2Fhd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_AH_AHTV5:
                    ahtv = HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fkjpd%2Fhd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_AH_AHTV6:
                    ahtv = HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fahgg%2Fhd%2Flive%2Em3u8");
                    break;
                default:
                    break;
            }
            if (NullUtil.isNullObject(ahtv)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, ahtv, CHACHE_TIMEOUT);
                return ahtv;
            }
        }else {
            return  cacheSource;
        }
    }
}
