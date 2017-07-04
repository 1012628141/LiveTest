package com.readyidu.source.local.sichuan.chengdu.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.PlayerEngineUtil;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/9.
 */
public class CditvSource extends Source {

    public CditvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        switch (index) {
            case 1:
                switch (sourceId) {
                    case SourceConstants.SOURCE_CDITV_1:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=1", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    case SourceConstants.SOURCE_CDITV_2:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=2", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_3:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=3", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_4:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=45", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_5:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=5", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_6:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=6", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_7:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=17", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_8:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=18", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_9:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=15", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_10:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=11", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_11:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=12", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_12:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=10", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_13:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=16", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_14:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=9", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    default:
                        return null;
                }
            case 2:
                switch (sourceId) {
                    case SourceConstants.SOURCE_CDITV_1:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=1&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_2:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=2&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_3:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=3&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_4:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=45&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_5:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=5&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_6:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=6&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_7:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=17&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_8:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=18&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_9:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=20", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_10:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=11&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_11:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=12&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_12:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=10&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_13:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=16&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    case SourceConstants.SOURCE_CDITV_14:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=9&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    default:
                        return null;
                }
            default:
                switch (sourceId) {
                    case SourceConstants.SOURCE_CDITV_1:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=1", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                    case SourceConstants.SOURCE_CDITV_2:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=2", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_3:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=3", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_4:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=45", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_5:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=5", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_6:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=6", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_7:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=17", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_8:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=18", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_9:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=15", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_10:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=11", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_11:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=12", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_12:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=10", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_13:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=16", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    case SourceConstants.SOURCE_CDITV_14:
                        return HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=9", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                    default:
                        return null;
                }
        }
    }
}
