package com.readyidu.source.local.zhejiang.source;

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
public class CztvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public CztvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String sourceData = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_CZTV_2:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/102.json");
                    break;
                case SourceConstants.SOURCE_CZTV_3:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/103.json");
                    break;
                case SourceConstants.SOURCE_CZTV_4:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/104.json");
                    break;
                case SourceConstants.SOURCE_CZTV_5:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/105.json");
                    break;
                case SourceConstants.SOURCE_CZTV_6:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/106.json");
                    break;
                case SourceConstants.SOURCE_CZTV_7:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/107.json");
                    break;
                case SourceConstants.SOURCE_CZTV_8:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/108.json");
                    break;
                case SourceConstants.SOURCE_CZTV_9:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/109.json");
                    break;
                case SourceConstants.SOURCE_CZTV_10:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/110.json");
                    break;
                case SourceConstants.SOURCE_CZTV_11:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/111.json");
                    break;
                case SourceConstants.SOURCE_CZTV_12:
                    sourceData = HttpUtil.httpGet("http://d.cztvcloud.com/config/live/112.json");
                    break;
                default:
                    break;
            }

            JSONObject sourceJson = JSON.parseObject(sourceData);
            if (sourceJson != null) {
                JSONObject sourceUrl = sourceJson.getJSONObject("playurl");
                if (sourceUrl != null) {
                    JSONArray sourceArray = sourceUrl.getJSONArray("dispatch");
                    if (sourceArray != null && sourceArray.size() > 0) {
                        JSONObject sourceDispatch = sourceArray.getJSONObject(0);
                        if (sourceDispatch != null) {
                            JSONArray urlArray = sourceDispatch.getJSONArray("url");
                            if (urlArray != null && urlArray.size() > 0) {
                                JSONObject m3u8Json = urlArray.getJSONObject(0);
                                if (m3u8Json != null) {
                                    JSONArray m3u8Array = m3u8Json.getJSONArray("yf_m3u8");
                                    if (m3u8Array != null && m3u8Array.size() > 0) {
                                        JSONObject sourceUrlData = m3u8Array.getJSONObject(0);
                                        if (sourceUrlData != null) {
                                            String sourceResult = sourceUrlData.getString("");
                                            CacheUtil.set(CACHE_NAME + sourceId, sourceUrlData.getString("超清"), CHACHE_TIMEOUT);
                                            return sourceUrlData.getString("超清");
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
