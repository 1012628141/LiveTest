package com.readyidu.source.local.guangdong.foshan.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class GrtnSource extends Source {

    public GrtnSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_GRTN_FOSHAN1:
                return HttpUtil.httpGet("http://live.grtn.cn/drm.php?url=http%3A%2F%2Fdslive%2Egrtn%2Ecn%2Ffszh%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Egrtn%2Ecn%2Flive%2Ffoshan%2F&hash=cd33b28138792bd1822b088a18f23303&playerVersion=4%2E03");
            default:
                return null;
        }
    }
}
