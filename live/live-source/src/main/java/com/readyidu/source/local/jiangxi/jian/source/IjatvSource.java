package com.readyidu.source.local.jiangxi.jian.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class IjatvSource extends Source {

    public IjatvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_IJATV_1:
                return HttpUtil.httpGet("http://www.ijatv.com/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Eijatv%2Ecom%2Fjatv1%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Eijatv%2Ecom%2Flive%2F&hash=88e5a280e36804be3c117d4ef717db55");
            case SourceConstants.SOURCE_IJATV_2:
                return HttpUtil.httpGet("http://www.ijatv.com/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Eijatv%2Ecom%2Fjatv2%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Eijatv%2Ecom%2Flive%2Fjatv2%2F&hash=905a706b338e8088783b37bf88d0590c");
            default:
                return null;
        }
    }
}
