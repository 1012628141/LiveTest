package com.readyidu.source.local.anhui.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by chenyihao on 2017/6/27.
 */
public class AhtvSource extends Source {
    public AhtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String ahtv=null;
        switch (sourceId){
            case SourceConstants.SOURCE_AH_AHTV1:
                ahtv= HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fjjsh%2Fhd%2Flive%2Em3u8&time=1498530940947&refererurl=http%3A%2F%2Fv%2Eahtv%2Ecn%2Flive%2Fjjlive%2F&hash=63f9c5a08b22a35b29bb87302d380634&playerVersion=4%2E03");
                break;
            case SourceConstants.SOURCE_AH_AHTV2:
                ahtv= HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?hash=e90350278666953875365447c91ebb37&url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fahgj%2Fhd%2Flive%2Em3u8&time=1498531038582&refererurl=http%3A%2F%2Fv%2Eahtv%2Ecn%2Flive%2Fgjlive%2F&playerVersion=4%2E03");
                break;
            case SourceConstants.SOURCE_AH_AHTV3:
                ahtv= HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?playerVersion=4%2E03&hash=da921ce68e2f002880998e3c5c99067d&url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fyspd%2Fhd%2Flive%2Em3u8&time=1498531251355&refererurl=http%3A%2F%2Fv%2Eahtv%2Ecn%2Flive%2Fyslive%2F");
                break;
            case SourceConstants.SOURCE_AH_AHTV4:
                ahtv= HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fzypd%2Fhd%2Flive%2Em3u8&time=1498531373349&refererurl=http%3A%2F%2Fv%2Eahtv%2Ecn%2Flive%2Fzylive%2F&hash=c83a12398266ccb2de988a13476cef16&playerVersion=4%2E03");
                break;
            case SourceConstants.SOURCE_AH_AHTV5:
                ahtv= HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?playerVersion=4%2E03&url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fkjpd%2Fhd%2Flive%2Em3u8&time=1498531536928&hash=17afa9aac293dc08ac93f7f07065663b&refererurl=http%3A%2F%2Fv%2Eahtv%2Ecn%2Flive%2Fkjlive%2F");
                break;
            case SourceConstants.SOURCE_AH_AHTV6:
                ahtv= HttpUtil.httpGet("http://www.ahtv.cn/m2o/player/drm.php?playerVersion=4%2E03&hash=5eef2f5ff974f1ec088ed9bd3766a118&url=http%3A%2F%2Fstream2%2Eahtv%2Ecn%2Fahgg%2Fhd%2Flive%2Em3u8&time=1498531651898&refererurl=http%3A%2F%2Fv%2Eahtv%2Ecn%2Flive%2Fgglive%2F");
                break;
        }
        return ahtv;
    }
}
