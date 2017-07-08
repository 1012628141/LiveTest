package com.readyidu.source.local.hunan.zhuzhou.source;

import com.alibaba.fastjson.JSON;
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
 * Created by Administrator on 2017/6/22.
 */
public class ZztvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public ZztvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        // 优先从缓存中取
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String zztvDom = null;
            String url = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_HN_ZZTV1:
                    zztvDom = HttpUtil.httpGet("http://live.zzbtv.com/live/live122/800K/live122_index.flv");
                    url = "http://live.zzbtv.com/live/live122/800K/";
                    break;
                case SourceConstants.SOURCE_HN_ZZTV2:
                    zztvDom = HttpUtil.httpGet("http://live.zzbtv.com/live/live124/800K/live124_index.flv");
                    url = "http://live.zzbtv.com/live/live124/800K/";
                    break;
                default:
                    break;
            }

            if(!NullUtil.isNullObject(zztvDom)){
                Pattern pattern = Pattern.compile("2017.*.flv");
                Matcher matcher = pattern.matcher(zztvDom);
                if (matcher.find()) {
                    cacheSource = url+matcher.group(0);
                    CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                    return cacheSource;
                }
            }
        } else {
            return cacheSource;
        }
        return null;
    }

//    public  static void main(String[] args) {
//       String hntvDom = HttpUtil.httpGet("http://live.zzbtv.com/live/live122/800K/live122_index.flv");
//        Pattern pattern = Pattern.compile("2017.*.flv");
//        Matcher matcher = pattern.matcher(hntvDom);
//        if (matcher.find()) {
//            String url = matcher.group(0);
//            System.out.print(url);
//        }
//    }
}
