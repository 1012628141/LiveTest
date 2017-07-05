package com.readyidu.source.local.hubei.yichang.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/26.
 */
public class YctvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public YctvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String Dom = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_HBTV_YCTV1:
                    Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=1");
                    break;
                case SourceConstants.SOURCE_HBTV_YCTV2:
                    Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=2");
                    break;
                case SourceConstants.SOURCE_HBTV_YCTV3:
                    Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=11");
                    break;
                default:
                    break;
            }
            Pattern pattern = Pattern.compile("http://zb.3xgd.com:1935/.*.&wowzatokenhash=.*.=");
            Matcher matcher = pattern.matcher(Dom);
            if (matcher.find()) {
                Dom = matcher.group(0);
                CacheUtil.set(CACHE_NAME + sourceId, Dom, CHACHE_TIMEOUT);
            }
            return Dom;
        } else {
            return cacheSource;
        }
    }

//    public static void main(String[] args) {
//        String sourceId = "source_hbtv_yctv3";
//        String Dom = null;
//        switch (sourceId) {
//            case SourceConstants.SOURCE_HBTV_YCTV1:
//                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=1");
//                break;
//            case SourceConstants.SOURCE_HBTV_YCTV2:
//                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=2");
//                break;
//            case SourceConstants.SOURCE_HBTV_YCTV3:
//                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=11");
//                break;
//            default:
//                break;
//        }
//        Pattern pattern = Pattern.compile("http://zb.3xgd.com:1935/.*.&wowzatokenhash=.*.=");
//        Matcher matcher = pattern.matcher(Dom);
//        if (matcher.find()) {
//            Dom = matcher.group(0);
//        }
//        System.out.print(Dom);
//    }
}
