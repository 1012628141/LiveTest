package com.readyidu.source.local.zhejiang.deqing.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class YingxiSource extends Source {

    public YingxiSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_YINGXI_YINGXITV1:
                return HttpUtil.httpGet("http://www.yingxi.tv/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2Eyingxi%2Etv%2Ffolder2%2Ffolder13%2F&hash=7d6ecc6d86f37e18a114f6056c232d38&url=http%3A%2F%2Flive%2Eyingxi%2Etv%2Fxwzh%2Fsd%2Flive%2Em3u8&time=1497523364032&playerVersion=4%2E03");
            case SourceConstants.SOURCE_YINGXI_YINGXITV2:
                return HttpUtil.httpGet("http://www.yingxi.tv/m2o/player/drm.php?refererurl=http%3A%2F%2Fwww%2Eyingxi%2Etv%2Ffolder2%2Ffolder14%2F&url=http%3A%2F%2Flive%2Eyingxi%2Etv%2Fylpd%2Fsd%2Flive%2Em3u8&time=1497523748024&playerVersion=4%2E03&hash=0db1a299da25007377fcf02de4bd3d03");
            default:
                return null;
        }
    }
}
