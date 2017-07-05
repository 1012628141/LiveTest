package com.readyidu.source.local.sichuan.shuangliu.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 2017/6/27.
 */
public class SltvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public SltvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String sltv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_SLTV_1:
                    sltv = HttpUtil.httpGet("http://media.sltv.net:82//sltv/liveChannel/PC/videoAll.jsonp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://www.sltv.net/webtv/live/");
                    break;
                default:
                    break;
            }

            JSONArray sltvArray = JSON.parseArray(sltv);
            if (sltvArray != null && sltvArray.size() > 0) {
                JSONObject sltvObj = sltvArray.getJSONObject(0);
                if (!NullUtil.isNullObject(sltvObj)) {
                    JSONArray screenShot = sltvObj.getJSONArray("C_ScreenShot");
                    JSONObject urlObj = null;
                    if (screenShot != null && screenShot.size() > 0) {
                        switch (index) {
                            case 1:
                                urlObj = screenShot.getJSONObject(0);
                                if (!NullUtil.isNullObject(urlObj)) {
                                    CacheUtil.set(CACHE_NAME + sourceId, urlObj.getString("url"), CHACHE_TIMEOUT);
                                    return urlObj.getString("url");
                                }
                            case 2:
                                if (screenShot.size() > 1) {
                                    urlObj = screenShot.getJSONObject(1);
                                    if (!NullUtil.isNullObject(urlObj)) {
                                        CacheUtil.set(CACHE_NAME + sourceId, urlObj.getString("url"), CHACHE_TIMEOUT);
                                        return urlObj.getString("url");
                                    }
                                }
                            default:
                                urlObj = screenShot.getJSONObject(0);
                                if (!NullUtil.isNullObject(urlObj)) {
                                    CacheUtil.set(CACHE_NAME + sourceId, urlObj.getString("url"), CHACHE_TIMEOUT);
                                    return urlObj.getString("url");
                                }
                                return null;
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
