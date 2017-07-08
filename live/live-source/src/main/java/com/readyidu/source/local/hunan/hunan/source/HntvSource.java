package com.readyidu.source.local.hunan.hunan.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/22.
 */
public class HntvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public HntvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        // 优先从缓存中取
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String hntvDom = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_HN_HNTV1:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=229&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV2:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=484&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV3:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=344&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV4:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=261&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV5:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=280&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV6:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=267&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV7:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=346&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV8:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=269&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV9:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=254&definition=std");
                    break;
                case SourceConstants.SOURCE_HN_HNTV10:
                    hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=230&definition=std");
                    break;
                default:
                    break;
            }
            JSONObject sourceJson = JSON.parseObject(hntvDom);
            if (sourceJson != null) {
                JSONObject sourceUrl = sourceJson.getJSONObject("data");
                if (sourceUrl != null) {
                   String url;
                   url= sourceUrl.getString("url");
                    if (url!=null){
                        CacheUtil.set(CACHE_NAME + sourceId, url, CHACHE_TIMEOUT);
                        return url;
                    }
                }
            }
        } else {
            return cacheSource;
        }
        return null;
    }

//    public  static void main(String[] args) {
//       String hntvDom = HttpUtil.httpGet("http://mpp.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlMPP?version=PCweb_1.0&platform=4&buss_id=2000001&channel_id=229&definition=std");
//        JSONObject sourceJson = JSON.parseObject(hntvDom);
//        if (sourceJson != null) {
//            JSONObject sourceUrl = sourceJson.getJSONObject("data");
//            if (sourceUrl != null) {
//                String url;
//                url= sourceUrl.getString("url");
//                if (url!=null){
//                    System.out.print(url);
//                }
//            }
//        }
//    }
}
