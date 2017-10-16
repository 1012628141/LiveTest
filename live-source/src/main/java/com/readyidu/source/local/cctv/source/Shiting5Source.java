package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/22.
 */
public class Shiting5Source extends Source {

    public Shiting5Source(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String shiting5Stv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_SHITING_CCTV1:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv1.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV2:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv2.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV3:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv3.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV4:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv4.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV5:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv5.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV6:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv6.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV7:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv7.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV8:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv8.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV9:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv9.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV10:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv10.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV11:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv11.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV12:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv12.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV13:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv13.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV14:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv14.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            case SourceConstants.SOURCE_SHITING_CCTV15:
                shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/cctv15.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                break;
            default:
                break;
        }

        if (!NullUtil.isNullObject(shiting5Stv)) {
            Pattern pattern = Pattern.compile("src=\"http://[a-z0-9A-Z-./_:]+.m3u8");
            Matcher matcher = pattern.matcher(shiting5Stv);
            if (matcher.find()) {
                String src = matcher.group(0);
                if (!NullUtil.isNullObject(src)) {
                    return src.replace("src=\"", "")+"$1";
                }
            }
        }
        return null;
    }
}
