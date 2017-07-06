package com.readyidu.source.local.zhejiang.shaoxing.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/9.
 */

public class SxtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public SxtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String sourceData = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_SXTV_NBTV1:
                    sourceData = HttpUtil.httpGet("http://www.sxtv.com.cn/m2o/channel/channel_info.php?id=2");
                    break;
                case SourceConstants.SOURCE_SXTV_NBTV2:
                    sourceData = HttpUtil.httpGet("http://www.sxtv.com.cn/m2o/channel/channel_info.php?id=10");
                    break;
                case SourceConstants.SOURCE_SXTV_NBTV3:
                    sourceData = HttpUtil.httpGet("http://www.sxtv.com.cn/m2o/channel/channel_info.php?id=11");
                    break;
                default:
                    break;
            }
            JSONArray sourceJsonArray = JSON.parseArray(sourceData);
            if (sourceJsonArray.size() >= 1) {
                JSONObject sourceJson = sourceJsonArray.getJSONObject(0);
                if (sourceJson != null) {
                    CacheUtil.set(CACHE_NAME + sourceId, sourceJson.getString("m3u8"), CHACHE_TIMEOUT);
                    return sourceJson.getString("m3u8");
                }
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
