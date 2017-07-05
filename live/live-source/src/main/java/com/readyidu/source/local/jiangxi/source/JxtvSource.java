package com.readyidu.source.local.jiangxi.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

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
                case SourceConstants.SOURCE_JX_JXTV1:
                    jxtv = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv2.shtml");
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
            Pattern pattern = Pattern.compile("http://[Ll]ive02.*.m3u8");
            Matcher matcher = pattern.matcher(jxtv);
            String url = null;
            if (matcher.find()) {
                url = matcher.group(0);
                CacheUtil.set(CACHE_NAME + sourceId, url, CHACHE_TIMEOUT);
            }
            return url;
        } else {
            return cacheSource;
        }
    }
//    public  static void main(String[] args) {
//       String hntvDom = HttpUtil.httpGet("http://www.jxntv.cn/live/jxtv5.shtml");
//        Pattern pattern = Pattern.compile("http://[Ll]ive02.*.m3u8");
//        Matcher matcher = pattern.matcher(hntvDom);
//        String url=null;
//        if (matcher.find()) {
//            url = matcher.group(0);
//            System.out.print(url);
//        }
//    }
}
