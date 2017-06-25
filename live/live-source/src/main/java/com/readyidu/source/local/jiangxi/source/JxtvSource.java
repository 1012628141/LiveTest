package com.readyidu.source.local.jiangxi.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ypf on 2017/6/24.
 */
public class JxtvSource extends Source {

    public JxtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String jxtv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_JX_JXTV1:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv2.shtml" );
                break;
            case SourceConstants.SOURCE_JX_JXTV2:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv3.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV3:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv4.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV4:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv5.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV5:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv6.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV6:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv7.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV7:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv8.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV8:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv9.shtml");
                break;
            case SourceConstants.SOURCE_JX_JXTV9:
                jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv10.shtml");
                break;
            default:
                break;
        }
        Pattern pattern = Pattern.compile("http.*.Live02.jxtvcn.com.cn.*.m3u8");
        Matcher matcher = pattern.matcher(jxtv);
        String url=null;
        if (matcher.find()) {
            url = matcher.group(0);
        }
        return url;
    }
}
