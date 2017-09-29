package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

public class TvcatCarouselSource extends Source {
    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId){
            case SourceConstants.SOURCL_YICHENG_CCTV_1 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=-1&dataType=4&nodeId=9000000000");
                break;
        }
        return null;
    }

    public TvcatCarouselSource(String sourceId, int index) {
        super(sourceId, index);
    }
}
