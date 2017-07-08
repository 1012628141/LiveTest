package com.readyidu.source.local.stv.source;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ypf on 2017/6/24.
 */
public class JxtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public JxtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String jxtv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_JX_JXSTV:
                    jxtv = HttpUtil.httpGet("http://soplayer.jxtvcn.com.cn//jxwlgbdst/liveChannel/IOS/a2451f3fd022438eb3bc38c3ffbfd57d.jsonp", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", "http://www.jxntv.cn/live/");
                    break;
                default:
                    break;
            }
            JSONObject jxtvObj = JSON.parseObject(jxtv.replace("success_jsonpCallback(", "").replace(")", ""));
            if (!NullUtil.isNullObject(jxtvObj)) {
                CacheUtil.set(CACHE_NAME + sourceId, jxtvObj.getString("C_Address"), CHACHE_TIMEOUT);
                return jxtvObj.getString("C_Address");
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
