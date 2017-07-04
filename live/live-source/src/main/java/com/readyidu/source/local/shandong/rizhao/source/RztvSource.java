package com.readyidu.source.local.shandong.rizhao.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by Administrator on 2017/6/27.
 */
public class RztvSource extends Source {

    public RztvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String Dom = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_SDTV_RZTV1:
                return HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fxwzh%2Fsd%2Flive%2Em3u8");
            case SourceConstants.SOURCE_SDTV_RZTV2:
                return HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fggpd%2Fsd%2Flive%2Em3u8");
            case SourceConstants.SOURCE_SDTV_RZTV3:
                return HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Fkzpd%2Fsd%2Flive%2Em3u8");
            case SourceConstants.SOURCE_SDTV_RZTV4:
                return HttpUtil.httpGet("http://v.rzw.com.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream%2Erzw%2Ecom%2Ecn%2Ffcpd%2Fsd%2Flive%2Em3u8");
            default:
                return null;
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
