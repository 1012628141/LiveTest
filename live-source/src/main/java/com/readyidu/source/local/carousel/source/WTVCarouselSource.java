package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

public class WTVCarouselSource extends Source {
    public WTVCarouselSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId){
            case SourceConstants.SOURCE_WTV_CAROUSEL_JPJC :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=615810094");
            break;
            case SourceConstants.SOURCE_WTV_CAROUSEL_FSYY :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=615809771");
                break;
            case SourceConstants.SOURCE_WTV_CAROUSEL_QCTX :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=616059928");
                break;
            case SourceConstants.SOURCE_WTV_CAROUSEL_EYL :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=608796678");
                break;
            case SourceConstants.SOURCE_WTV_CAROUSEL_DZCJ :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=608780949");
                break;
            case SourceConstants.SOURCE_WTV_CAROUSEL_CTY :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=616201434");
                break;
            case SourceConstants.SOURCE_WTV_CAROUSEL_INYT :
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=608796940");
                break;
        }
        if(content != null && !"".equals(content)){
            String videoStr = content.substring(content.indexOf("<video"),content.indexOf("</video>"));
            result = videoStr.substring(videoStr.indexOf("http"),videoStr.indexOf("\"",14));
        }
        return result;
    }
}
