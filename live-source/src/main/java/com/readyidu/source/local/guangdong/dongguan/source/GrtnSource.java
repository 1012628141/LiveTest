package com.readyidu.source.local.guangdong.dongguan.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
        String url = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_GRTN_DONGGUAN1:
                url = HttpUtil.httpGet("http://live.grtn.cn/drm.php?url=http%3A%2F%2Fdslive%2Egrtn%2Ecn%2Fdgzh%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Egrtn%2Ecn%2Flive%2Fdgzh%2F&hash=596736987d6996218048c0424fe9c106&playerVersion=4%2E03");
                break;
            default:
                break;
        }
        if (NullUtil.isNullObject(url)) {
            return null;
        } else {
            return url;
        }
    }
}
