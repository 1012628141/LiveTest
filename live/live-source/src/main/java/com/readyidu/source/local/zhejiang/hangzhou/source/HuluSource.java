package com.readyidu.source.local.zhejiang.hangzhou.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.service.CacheService;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;

/**
 * Created by yuzhang on 17/6/9.
 */
public class HuluSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public HuluSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (sourceId) {
                case SourceConstants.SOURCE_HULU_HTV1:
                    cacheSource = HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&refererurl=&hash=79123d0a0d03325c489ebeb42b06b2f4&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv1%2Fsd%2Flive%2Em3u8&time=1496647751605");
                    break;
                case SourceConstants.SOURCE_HULU_HTV2:
                    cacheSource = HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?hash=34c6d15f884f983ed51712d60ff0e5f4&playerVersion=4%2E03&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fxhmz%2F&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv2%2Fsd%2Flive%2Em3u8&time=1496992909777");
                    break;
                case SourceConstants.SOURCE_HULU_HTV3:
                    cacheSource = HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fhzsh%2F&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv3%2Fsd%2Flive%2Em3u8&time=1496993252069&hash=ee3d882c59b0f57bcb69713ad579977d");
                    break;
                case SourceConstants.SOURCE_HULU_HTV4:
                    cacheSource = HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?hash=851a2704b31d6bcf47e20936debe396f&playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv4%2Fsd%2Flive%2Em3u8&time=1496993504008&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Futv%2F");
                    break;
                case SourceConstants.SOURCE_HULU_HTV5:
                    cacheSource = HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&hash=65d8e0cc2e53af3f886e37b8104bfcf6&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv5%2Fsd%2Flive%2Em3u8&time=1496993549288&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fhzse%2F");
                    break;
                case SourceConstants.SOURCE_HULU_HTV6:
                    cacheSource = HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&hash=bcda4cc5c31ee2fb34d0e3c40cc4c7c6&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv6%2Fsd%2Flive%2Em3u8&time=1496993605215&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fwhpd%2F");
                    break;
                default:
                    break;
            }
            if (NullUtil.isNullObject(cacheSource)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                return cacheSource;
            }
        } else {
            return  cacheSource;
        }
    }
}
