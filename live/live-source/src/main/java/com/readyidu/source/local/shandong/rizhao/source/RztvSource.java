package com.readyidu.source.local.shandong.rizhao.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/27.
 */
public class RztvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public RztvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String Dom = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_SDTV_RZTV1:
                    cacheSource = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fxwzh%2Fsd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_SDTV_RZTV2:
                    cacheSource = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fggpd%2Fsd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_SDTV_RZTV3:
                    cacheSource = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fkzpd%2Fsd%2Flive%2Em3u8");
                    break;
                case SourceConstants.SOURCE_SDTV_RZTV4:
                    cacheSource = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Ffcpd%2Fsd%2Flive%2Em3u8");
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

//    public static void main(String[] args) {
//        String sourceId = "source_sdtv_rztv4";
//        String Dom = null;
//        switch (sourceId) {
//            case SourceConstants.SOURCE_SDTV_RZTV1:
//                Dom = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fxwzh%2Fsd%2Flive%2Em3u8");
//                break;
//            case SourceConstants.SOURCE_SDTV_RZTV2:
//                Dom = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fggpd%2Fsd%2Flive%2Em3u8");
//                break;
//            case SourceConstants.SOURCE_SDTV_RZTV3:
//                Dom = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fkzpd%2Fsd%2Flive%2Em3u8");
//                break;
//            case SourceConstants.SOURCE_SDTV_RZTV4:
//                Dom = HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Ffcpd%2Fsd%2Flive%2Em3u8");
//                break;
//            default:
//                break;
//        }
//        System.out.print(Dom);
//    }
}
