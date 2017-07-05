package com.readyidu.source.local.sichuan.chengdu.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.*;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/9.
 */
public class CditvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public CditvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            switch (index) {
                case 1:
                    switch (sourceId) {
                        case SourceConstants.SOURCE_CDITV_1:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=1", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_2:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=2", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_3:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=3", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_4:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=45", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_5:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=5", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_6:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=6", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_7:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=17", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_8:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=18", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_9:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=15", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_10:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=11", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_11:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=12", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_12:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=10", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_13:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=16", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_14:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=9", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        default:
                            break;
                    }
                case 2:
                    switch (sourceId) {
                        case SourceConstants.SOURCE_CDITV_1:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=1&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_2:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=2&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_3:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=3&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_4:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=45&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_5:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=5&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_6:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=6&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_7:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=17&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_8:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=18&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_9:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=20", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_10:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=11&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_11:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=12&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_12:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=10&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_13:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=16&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_14:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=9&videotype=m3u8&type=", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                            break;
                        default:
                            break;
                    }
                default:
                    switch (sourceId) {
                        case SourceConstants.SOURCE_CDITV_1:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&catid=192&id=1", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/602.3.12 (KHTML, like Gecko) Version/10.0.2 Safari/602.3.12", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_2:
                            cacheSource =  HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=2", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_3:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=3", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_4:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=45", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_5:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=5", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_6:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=6", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_7:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=17", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_8:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=18", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_9:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=15", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_10:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=11", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_11:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=12", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_12:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=10", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_13:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=16", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        case SourceConstants.SOURCE_CDITV_14:
                            cacheSource = HttpUtil.httpGet("http://www.cditv.cn/api.php?op=live&type=live&catid=192&id=9", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", null);
                            break;
                        default:
                            break;
                    }
            }
            if (NullUtil.isNullObject(cacheSource)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                return cacheSource;
            }
        } else {
            return cacheSource;
        }
    }
}
