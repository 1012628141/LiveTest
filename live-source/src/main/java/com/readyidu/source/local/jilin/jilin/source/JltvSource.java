package com.readyidu.source.local.jilin.jilin.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/27.
 */
public class JltvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public JltvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        Long time = new Date().getTime();
        long timeStamp = System.currentTimeMillis();
//        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
//        if (NullUtil.isNullObject(cacheSource)) {
        switch (sourceId) {
            case SourceConstants.SOURCE_JLTV_JLTV1://都市 http://stream1.jlntv.cn/dspd/sd/live.m3u8?_upt=9894a0dc1499771454
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/dspd/sd/live.m3u8&hash=97c0b067dd6770b3b69f2ea861242b5f&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder481/&time=" + time, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV2://生活 http://stream1.jlntv.cn/shpd/sd/live.m3u8?_upt=4e4f35ad1499771481
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/shpd/sd/live.m3u8&hash=318986fd0997d963b6fa3e18f84a3bfc&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder432/&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV3://影视 http://stream1.jlntv.cn/yspd/sd/live.m3u8?_upt=d6438bcf1499771514
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/yspd/sd/live.m3u8&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder433/&hash=5d679a8b6322b5b79727c9c42de76006&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV4://乡村  http://stream1.jlntv.cn/xcpd/sd/live.m3u8?_upt=3c08aaab1499771586
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/xcpd/sd/live.m3u8&hash=f2f7e0a5c4dcf848f98a81c10dd7ef80&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder482/&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV5://公共 http://stream1.jlntv.cn/xcpd/sd/live.m3u8?_upt=3c08aaab1499771586
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/ggpd/sd/live.m3u8&hash=f423922513246be824d29f928cc0fdb3&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder483/&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV6://综艺  http://stream1.jlntv.cn/fzpd/sd/live.m3u8?_upt=739d01d51499771663
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/fzpd/sd/live.m3u8&hash=a7f5e0db8f522db53c8d46ec9b5e319f&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder434/&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV7://东北戏曲 http://stream1.jlntv.cn/dbxq/sd/live.m3u8?_upt=d740f37f1499771743
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/dbxq/sd/live.m3u8&hash=7beef5f813c05ed135e47588047f1cab&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder485/&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV8://篮球 http://stream1.jlntv.cn/lqpd/sd/live.m3u8?_upt=7690078b1499771778
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/lqpd/sd/live.m3u8&refererurl=http://www.jlntv.cn/folder430/folder484/index.html&playerVersion=4.03&hash=29e78606b37f0a072a8537854dce892a&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            case SourceConstants.SOURCE_JLTV_JLTV9://家有购物 http://stream1.jlntv.cn/jygw/sd/live.m3u8?_upt=da5d446f1499771800
                cacheSource = HttpUtil.httpGet("http://v.jlntv.cn/m2o/player/drm.php?url=http://stream1.jlntv.cn/jygw/sd/live.m3u8&hash=6a940d08664458ad2c0359196bf7d952&playerVersion=4.03&refererurl=http://www.jlntv.cn/folder430/folder435/index.html&time=" + timeStamp, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://player.hoge.cn/player.swf");
                break;
            default:
                break;
        }
        if (NullUtil.isNullObject(cacheSource)) {
            return null;
        } else {
//                HashMap<String, String> header = new HashMap<String, String>();
//                header.put("Referer", "http://player.hoge.cn/player.swf");
//                header.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
//                CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
            return cacheSource;
        }
//        } else {
//            return cacheSource;
//        }
    }
}
