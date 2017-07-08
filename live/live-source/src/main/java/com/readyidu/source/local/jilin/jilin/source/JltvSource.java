package com.readyidu.source.local.jilin.jilin.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/27.
 */
public class JltvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public JltvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_JLTV_JLTV1:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fdspd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV2:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fshpd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV3:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fyspd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV4:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fxcpd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV5:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fggpd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV6:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Ffzpd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV7:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fdbxq%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV8:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Flqpd%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                case SourceConstants.SOURCE_JLTV_JLTV9:
                    cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fjlws%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                default:
                    break;
            }
            if (NullUtil.isNullObject(cacheSource)) {
                return null;
            } else {
                HashMap<String, String> header = new HashMap<String, String>();
                header.put("Referer", "http://player.hoge.cn/player.swf");
                CacheUtil.set(CACHE_NAME + sourceId, HeaderUtil.addHeader(cacheSource, header), CHACHE_TIMEOUT);
                return HeaderUtil.addHeader(cacheSource, header);
            }
        } else {
            return cacheSource;
        }
    }

//    public static void main(String[] args) {
//        String sourceId = "source_jltv_jltv5";
//        String Dom = null;
//        switch (sourceId) {
//            case SourceConstants.SOURCE_JLTV_JLTV1:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fdspd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV2:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fshpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV3:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fyspd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV4:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fxcpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV5:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fggpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV6:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Ffzpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV7:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fdbxq%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            case SourceConstants.SOURCE_JLTV_JLTV8:
//                Dom = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Flqpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
//                break;
//            default:
//                break;
//        }
//        System.out.print(Dom);
//    }
}
