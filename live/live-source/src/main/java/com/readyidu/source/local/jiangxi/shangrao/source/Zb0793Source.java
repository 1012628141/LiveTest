package com.readyidu.source.local.jiangxi.shangrao.source;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ypf on 2017/6/24.
 */
public class Zb0793Source extends Source {


    public Zb0793Source(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
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
                        return newsJson.getString("pckey");
                    case 2:
                        return newsJson.getString("app");
                    default:
                        return newsJson.getString("pckey");
                }
            }
        }
        return null;
    }
}
