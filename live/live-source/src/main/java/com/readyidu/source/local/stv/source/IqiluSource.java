package com.readyidu.source.local.stv.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/24.
 */
public class IqiluSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public IqiluSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String iqiluStv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_IQILU_STV:
                iqiluStv = HttpUtil.httpGet("http://v.iqilu.com/live/sdtv/", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            default:
                break;
        }
        Pattern pattern = Pattern.compile("http://hlsgs.iqilu.com/live/sdtv/index.m3u8\\?sign=[a-z0-9]+&t=[a-z0-9]+");
        Matcher matcher = pattern.matcher(iqiluStv);
        if (matcher.find()) {
            String src = matcher.group(0);
            if (!NullUtil.isNullObject(src)) {
                HashMap<String, String> header = new HashMap<String, String>();
                header.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1");
                return HeaderUtil.addHeader(src, header);
            }
        }
        return null;
    }
}
