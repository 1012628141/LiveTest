package com.readyidu.source.local.jiangxi.shangrao.source;

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
public class Zb0793Source extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public Zb0793Source(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String zb = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_ZB0793_1:
                    zb = HttpUtil.httpGet("http://0793tv.cn/api/live?terminal=touch&client=liveonline_&pull_type=stop&channel=srtv1&page=0", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X) AppleWebKit/602.4.6 (KHTML, like Gecko) Mobile/14D27", "http://0793tv.cn/live/");
                    break;
                case SourceConstants.SOURCE_ZB0793_2:
                    zb = HttpUtil.httpGet("http://0793tv.cn/api/live?terminal=touch&client=liveonline_&pull_type=stop&channel=srtv2&page=0", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X) AppleWebKit/602.4.6 (KHTML, like Gecko) Mobile/14D27", "http://0793tv.cn/live/");
                    break;
                case SourceConstants.SOURCE_ZB0793_3:
                    zb = HttpUtil.httpGet("http://0793tv.cn/api/live?terminal=touch&client=liveonline_&pull_type=stop&channel=srtv3&page=0", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X) AppleWebKit/602.4.6 (KHTML, like Gecko) Mobile/14D27", "http://0793tv.cn/live/");
                    break;
                case SourceConstants.SOURCE_ZB0793_4:
                    zb = HttpUtil.httpGet("http://0793tv.cn/api/live?terminal=touch&client=liveonline_&pull_type=stop&channel=srtv4&page=0", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X) AppleWebKit/602.4.6 (KHTML, like Gecko) Mobile/14D27", "http://0793tv.cn/live/");
                    break;
                default:
                    break;
            }
            if (!NullUtil.isNullObject(zb)) {
                zb = zb.replace("(", "").replace(")", "");
                JSONObject zbJson = JSONObject.parseObject(zb);
                JSONObject newsJson = zbJson.getJSONObject("news");
                if (!NullUtil.isNullObject(newsJson)) {
                    switch (index) {
                        case 1:
                            CacheUtil.set(CACHE_NAME + sourceId, newsJson.getString("pckey"), CHACHE_TIMEOUT);
                            return newsJson.getString("pckey");
                        case 2:
                            CacheUtil.set(CACHE_NAME + sourceId, newsJson.getString("app"), CHACHE_TIMEOUT);
                            return newsJson.getString("app");
                        default:
                            break;
                    }
                }
            }
            return null;
        } else  {
            return cacheSource;
        }
    }
}
