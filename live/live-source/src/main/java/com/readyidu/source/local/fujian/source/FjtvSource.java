package com.readyidu.source.local.fujian.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 17/6/9.
 */
public class FjtvSource extends Source {

    public FjtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_FJTV_1:
                return HttpUtil.httpGet("http://v.fjtv.net/m2o/player/drml.php?refererurl=http%3A%2F%2F1%2Efjtv%2Enet%2F&url=http%3A%2F%2Fstream5%2Efjtv%2Enet%2Fzhpd%2Fsd%2Flive%2Em3u8&time=1498210384869&hash=aface73ac35e64d9ae8e937da35d66b1&playerVersion=4%2E03","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36","http://1.fjtv.net/");
            case SourceConstants.SOURCE_FJTV_2:
                return HttpUtil.httpGet("http://v.fjtv.net/m2o/player/drml.php?url=http%3A%2F%2Fstream5%2Efjtv%2Enet%2Fggpd%2Fsd%2Flive%2Em3u8&time=1498210806218&hash=6ddba5d17e7a945b057daa73f77ddb57&refererurl=http%3A%2F%2Fggpd%2Efjtv%2Enet%2F&playerVersion=4%2E03","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36","http://1.fjtv.net/");
            case SourceConstants.SOURCE_FJTV_3:
                return HttpUtil.httpGet("http://v.fjtv.net/m2o/player/drml.php?url=http%3A%2F%2Fstream5%2Efjtv%2Enet%2Fxwpd%2Fsd%2Flive%2Em3u8&time=1498210876310&playerVersion=4%2E03&refererurl=http%3A%2F%2Fnews%2Efjtv%2Enet%2F&hash=2652a72562ee399f16a291f2991eea35","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36","http://1.fjtv.net/");
            case SourceConstants.SOURCE_FJTV_5:
                return HttpUtil.httpGet("http://v.fjtv.net/m2o/player/drml.php?refererurl=http%3A%2F%2Fdspd%2Efjtv%2Enet%2F&url=http%3A%2F%2Fstream6%2Efjtv%2Enet%2Fdspd%2Fsd%2Flive%2Em3u8&time=1498211055332&hash=5e00976a97dfce3453a324380cfbad23&playerVersion=4%2E03","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36","http://1.fjtv.net/");
            case SourceConstants.SOURCE_FJTV_6:
                return HttpUtil.httpGet("http://v.fjtv.net/m2o/player/drml.php?refererurl=http%3A%2F%2Fwww%2Efjtv%2Enet%2Ffolder526%2Ffolder533%2F&url=http%3A%2F%2Fstream6%2Efjtv%2Enet%2Fjjpd%2Fsd%2Flive%2Em3u8&time=1498211107925&hash=f8379529b2044ed245adc51e1df9bf15&playerVersion=4%2E03","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36","http://1.fjtv.net/");
            case SourceConstants.SOURCE_FJTV_8:
                return HttpUtil.httpGet("http://v.fjtv.net/m2o/player/drml.php?refererurl=http%3A%2F%2Ffj%2D9%2Efjtv%2Enet%2F&url=http%3A%2F%2Fstream6%2Efjtv%2Enet%2Fchild%2Fsd%2Flive%2Em3u8&time=1498211406277&hash=19c8d95931307060d397c2d1e6c472f9&playerVersion=4%2E03","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36","http://1.fjtv.net/");
            default:
                return null;
        }
    }
}
