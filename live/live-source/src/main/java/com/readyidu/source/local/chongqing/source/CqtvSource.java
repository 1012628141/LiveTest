package com.readyidu.source.local.chongqing.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/24.
 */
public class CqtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public CqtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        // 优先从缓存中取
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String cqtvDom = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_CQ_CQTV1:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_3.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV2:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_6.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV3:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_10.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV4:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_17.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV5:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_11.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV6:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_18.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV7:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_19.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV8:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_9.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV9:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_12.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV10:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_16.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV11:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_20.stream%2Fchunklist.m3u8");
                    break;
                case SourceConstants.SOURCE_CQ_CQTV12:
                    cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_5.stream%2Fchunklist.m3u8");
                    break;
                default:
                    break;
            }

            if (!NullUtil.isNullObject(cqtvDom)) {
                Pattern pattern = Pattern.compile("http.*.m3u8");
                Matcher matcher = pattern.matcher(cqtvDom);
                if (matcher.find()) {
                    cacheSource = matcher.group(0);
                    cacheSource = cacheSource.replace("\\", "");
                    CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                }
            }
            return cacheSource;
        } else {
            return cacheSource;
        }
    }

//    public  static void main(String[] args) {
//       String cqtvDom = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&ch=%2Fapp_2%2F_definst_%2Fls_2.stream%2Fchunklist.m3u8");
//        Pattern pattern = Pattern.compile("http.*.m3u8");
//        Matcher matcher = pattern.matcher(cqtvDom);
//        if (matcher.find()) {
//            String url = matcher.group(0);
//            url = url.replace("\\","");
//            System.out.print(url);
//        }
//    }
}
