package com.readyidu.source.local.hubei.jingmen.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by Administrator on 2017/6/26.
 */
public class JmtvSource extends Source {

    public JmtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_HBTV_JMTV1:
                return HttpUtil.httpGet("http://www.jmtv.com.cn/m2o/player/drm.php?url=http%3A%2F%2Flive%2Ejmtv%2Ecom%2Ecn%2Fxwzh%2Fsd%2Flive%2Em3u8");
            case SourceConstants.SOURCE_HBTV_JMTV2:
                return HttpUtil.httpGet("http://www.jmtv.com.cn/m2o/player/drm.php?url=http%3A%2F%2Flive%2Ejmtv%2Ecom%2Ecn%2Fngpd%2Fsd%2Flive%2Em3u8");
            default:
                return null;
        }
    }

//    public static void main(String[] args) {
//        String sourceId = "source_hbtv_jmtv1";
//        String Dom = null;
//        switch (sourceId) {
//            case SourceConstants.SOURCE_HBTV_JMTV1:
//                Dom = HttpUtil.httpGet("http://www.jmtv.com.cn/m2o/player/drm.php?url=http%3A%2F%2Flive%2Ejmtv%2Ecom%2Ecn%2Fxwzh%2Fsd%2Flive%2Em3u8");
//                break;
//            case SourceConstants.SOURCE_HBTV_JMTV2:
//                Dom = HttpUtil.httpGet("http://www.jmtv.com.cn/m2o/player/drm.php?url=http%3A%2F%2Flive%2Ejmtv%2Ecom%2Ecn%2Fngpd%2Fsd%2Flive%2Em3u8");
//                break;
//            default:
//                break;
//        }
//        System.out.print(Dom);
//    }
}
