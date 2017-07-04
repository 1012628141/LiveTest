package com.readyidu.source.local.jilin.jilin.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by Administrator on 2017/6/27.
 */
public class JltvSource extends Source {

    public JltvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_JLTV_JLTV1:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fdspd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV2:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fshpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV3:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fyspd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV4:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fxcpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV5:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fggpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV6:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Ffzpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV7:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fdbxq%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV8:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Flqpd%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            case SourceConstants.SOURCE_JLTV_JLTV9:
                return HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream1%2Ejlntv%2Ecn%2Fjlws%2Fsd%2Flive%2Em3u8","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0",null);
            default:
                return null;
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
