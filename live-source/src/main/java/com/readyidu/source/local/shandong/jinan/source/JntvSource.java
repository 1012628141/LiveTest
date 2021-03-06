package com.readyidu.source.local.shandong.jinan.source;

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
public class JntvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public JntvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_SDTV_JNTV1:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts3%2Eijntv%2Ecn%2Fjnqtx%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                break;
            case SourceConstants.SOURCE_SDTV_JNTV2:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts1%2Eijntv%2Ecn%2Fjnds%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                break;
            case SourceConstants.SOURCE_SDTV_JNTV3:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts1%2Eijntv%2Ecn%2Fjnyd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                break;
            case SourceConstants.SOURCE_SDTV_JNTV4:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts2%2Eijntv%2Ecn%2Fjnyl%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                break;
            case SourceConstants.SOURCE_SDTV_JNTV5:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts2%2Eijntv%2Ecn%2Fjnsh%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                break;
            case SourceConstants.SOURCE_SDTV_JNTV6:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts1%2Eijntv%2Ecn%2Fjnsw%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                break;
            case SourceConstants.SOURCE_SDTV_JNTV7:
                cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts2%2Eijntv%2Ecn%2Fjnse%2Fsd1%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
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

//    public static void main(String[] args) {
//        String sourceId = "source_sdtv_jntv1";
//        String Dom = null;
//        switch (sourceId) {
//            case SourceConstants.SOURCE_SDTV_JNTV1:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts3%2Eijntv%2Ecn%2Fjnqtx%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_SDTV_JNTV2:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts1%2Eijntv%2Ecn%2Fjnds%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_SDTV_JNTV3:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts1%2Eijntv%2Ecn%2Fjnyd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_SDTV_JNTV4:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts2%2Eijntv%2Ecn%2Fjnyl%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_SDTV_JNTV5:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts2%2Eijntv%2Ecn%2Fjnsh%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_SDTV_JNTV6:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts1%2Eijntv%2Ecn%2Fjnsw%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_SDTV_JNTV7:
//                Dom = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts2%2Eijntv%2Ecn%2Fjnse%2Fsd1%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            default:
//                break;
//        }
//        System.out.print(Dom);
//    }
}
