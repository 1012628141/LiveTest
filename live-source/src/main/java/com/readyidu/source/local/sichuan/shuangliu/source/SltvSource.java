package com.readyidu.source.local.sichuan.shuangliu.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

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
        String sltv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_SLTV_1:
                sltv = HttpUtil.httpGet("http://media.sltv.net:82//sltv/liveChannel/PC/videoAll.jsonp", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://www.sltv.net/webtv/live/");
                break;
            default:
                break;
        }
        sltv = sltv.replace("channels_jsonpCallback(", "");
        sltv = sltv.substring(0, sltv.length() - 1);
        JSONArray sltvArray = null;
        System.out.println(sltv);
        try {
            sltvArray = JSON.parseArray(sltv);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("*********json**********");
        System.out.println(sltvArray);
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
                                return urlObj.getString("url");
                            }
                        case 2:
                            if (screenShot.size() > 1) {
                                urlObj = screenShot.getJSONObject(1);
                                if (!NullUtil.isNullObject(urlObj)) {
                                    return urlObj.getString("url");
                                }
                            }
                        default:
                            urlObj = screenShot.getJSONObject(0);
                            if (!NullUtil.isNullObject(urlObj)) {
                                return urlObj.getString("url");
                            }
                            return null;
                    }
                }
            }

        }
        return null;
    }
}
