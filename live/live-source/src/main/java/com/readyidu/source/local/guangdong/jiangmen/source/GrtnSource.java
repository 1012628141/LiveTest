package com.readyidu.source.local.guangdong.jiangmen.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class GrtnSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public GrtnSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_GRTN_JIANGMEN1:
                cacheSource = HttpUtil.httpGet("http://live.grtn.cn/drm.php?url=http%3A%2F%2Fdslive%2Egrtn%2Ecn%2Fjmzh%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Egrtn%2Ecn%2Flive%2Fjmzh%2F&hash=a68403af3e75ec4c1ee03a01aa3d24be&playerVersion=4%2E03");
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
}
