package com.readyidu.source.local.jiangsu.wuxi.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class ThmzSource extends Source {

    public ThmzSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_THMZ_THMZ1:
//                return HttpUtil.httpGet("http://www2.thmz.com/m2o/player/drmx.php?url=http%3A%2F%2Fstream%2Ethmz%2Ecom%2Fwxtv1%2Fsd%2Flive%2Em3u8&time=1497786907725&refererurl=http%3A%2F%2Fv2%2Ethmz%2Ecom%2F&hash=51879d474e53fff83875cb59de8d9148&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "http://v2.thmz.com/");
            case SourceConstants.SOURCE_THMZ_THMZ2:
//                return HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?hash=34c6d15f884f983ed51712d60ff0e5f4&playerVersion=4%2E03&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fxhmz%2F&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv2%2Fsd%2Flive%2Em3u8&time=1496992909777");
            case SourceConstants.SOURCE_THMZ_THMZ3:
//                return HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fhzsh%2F&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv3%2Fsd%2Flive%2Em3u8&time=1496993252069&hash=ee3d882c59b0f57bcb69713ad579977d");
            case SourceConstants.SOURCE_THMZ_THMZ4:
//                return HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?hash=851a2704b31d6bcf47e20936debe396f&playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv4%2Fsd%2Flive%2Em3u8&time=1496993504008&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Futv%2F");
            case SourceConstants.SOURCE_THMZ_THMZ5:
//                return HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&hash=65d8e0cc2e53af3f886e37b8104bfcf6&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv5%2Fsd%2Flive%2Em3u8&time=1496993549288&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fhzse%2F");
            case SourceConstants.SOURCE_THMZ_THMZ6:
//                return HttpUtil.httpGet("http://www.hoolo.tv/m2o/player/drmh.php?playerVersion=4%2E03&hash=bcda4cc5c31ee2fb34d0e3c40cc4c7c6&url=http%3A%2F%2Fstream%2Ehoolo%2Etv%2Fhztv6%2Fsd%2Flive%2Em3u8&time=1496993605215&refererurl=http%3A%2F%2Ftv%2Ehoolo%2Etv%2Fwhpd%2F");
            default:
                return null;
        }
    }
}
