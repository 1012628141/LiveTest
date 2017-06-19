package com.readyidu.source.local.jiangsu.changzhou.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class CztvSource extends Source {

    public CztvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_CZTV_CZ1:
                return HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2F&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvxw%2Fsd%2Flive%2Em3u8&hash=376c42ecbd88beef5ea435da195d480a&time=1497860451916", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
            case SourceConstants.SOURCE_CZTV_CZ2:
                return HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvds%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder33%2F&hash=d19962907d43ef2757894c7ee1b76029&time=1497860828373", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
            case SourceConstants.SOURCE_CZTV_CZ3:
                return HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder34%2F&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvsh%2Fsd%2Flive%2Em3u8&hash=6553ce228f9aa8d422ac603cc84256fc&time=1497861010707", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
            case SourceConstants.SOURCE_CZTV_CZ4:
                return HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Fcztvgg%2Fsd%2Flive%2Em3u8&hash=97ea1186ae3a115aa6d8b570355dd1e8&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder35%2F&time=1497861068223", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
            case SourceConstants.SOURCE_CZTV_CZ5:
                return HttpUtil.httpGet("http://www.cztv.tv/m2o/player/drm.php?hash=8863bb224d1f3ddd33326a58164f28fe&url=http%3A%2F%2Fstream%2Ecztv%2Etv%2Ftwpd%2Fsd%2Flive%2Em3u8&refererurl=http%3A%2F%2Fwww%2Ecztv%2Etv%2Fitv%2Ffolder498%2F&time=1497861138441&playerVersion=4%2E03", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
            default:
                return null;
        }
    }
}
