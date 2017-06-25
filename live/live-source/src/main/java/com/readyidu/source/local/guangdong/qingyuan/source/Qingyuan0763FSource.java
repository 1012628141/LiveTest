package com.readyidu.source.local.guangdong.qingyuan.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

/**
 * Created by yuzhang on 2017/6/24.
 */
public class Qingyuan0763FSource extends Source{

    public Qingyuan0763FSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_0763F_QINGYUAN1:
                return HttpUtil.httpGet("http://www.0763f.com/m2o/player/drmx.php?refererurl=http%3A%2F%2Fwww%2E0763f%2Ecom%2Flive%2Ffolder1230%2Ffolder147%2F&hash=8c83ee80050e6b76cc7d16efc9d18d8e&url=http%3A%2F%2Fstream1%2E0763f%2Ecom%2Fqyzh%2Fsd%2Flive%2Em3u8&playerVersion=4%2E03");
            case SourceConstants.SOURCE_0763F_QINGYUAN2:
                return HttpUtil.httpGet("http://www.0763f.com/m2o/player/drmx.php?playerVersion=4%2E03&refererurl=http%3A%2F%2Fwww%2E0763f%2Ecom%2Flive%2Ffolder1230%2Ffolder146%2F&url=http%3A%2F%2Fstream1%2E0763f%2Ecom%2Fqygg%2Fsd%2Flive%2Em3u8&hash=23bbede7a506f5039120975bd7e327eb");
            default:
                return null;
        }
    }
}
