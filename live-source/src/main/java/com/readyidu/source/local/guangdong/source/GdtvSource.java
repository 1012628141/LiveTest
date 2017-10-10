package com.readyidu.source.local.guangdong.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class GdtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public GdtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        String gdtv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_GDTV_ZHUJIANG:
                gdtv = HttpUtil.httpGet("http://zj.gdtv.cn/m2o/channel/channel_info.php?id=26");
                break;
            case SourceConstants.SOURCE_GDTV_TIYU:
                gdtv = HttpUtil.httpGet("http://sports.gdtv.cn/m2o/channel/channel_info.php?id=27");
                break;
            case SourceConstants.SOURCE_GDTV_GONGGONG:
                gdtv = HttpUtil.httpGet("http://public.gdtv.cn/m2o/channel/channel_info.php?id=31");
                break;
            case SourceConstants.SOURCE_GDTV_XINWEN:
                gdtv = HttpUtil.httpGet("http://news.gdtv.cn/m2o/channel/channel_info.php?id=28");
                break;
            case SourceConstants.SOURCE_GDTV_GUOJI:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=30");
                break;
            case SourceConstants.SOURCE_GDTV_FANGCHAN:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=33");
                break;
            case SourceConstants.SOURCE_GDTV_HUIZHAN:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=34");
                break;
            case SourceConstants.SOURCE_GDTV_TVS1:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=93");
                break;
            case SourceConstants.SOURCE_GDTV_TVS2:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=7");
                break;
            case SourceConstants.SOURCE_GDTV_TVS3:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=36");
                break;
            case SourceConstants.SOURCE_GDTV_TVS4:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=37");
                break;
            case SourceConstants.SOURCE_GDTV_TVS5:
                gdtv = HttpUtil.httpGet("http://www.gdtv.cn/m2o/channel/channel_info.php?id=38");
                break;
            default:
                break;
        }

        JSONArray gdtvArray = JSON.parseArray(gdtv);
        if (gdtvArray != null && gdtvArray.size() > 0) {
            JSONObject gdtvObject = gdtvArray.getJSONObject(0);
            if (gdtvObject != null) {
                String m3u8 = gdtvObject.getString("m3u8");
                HashMap<String, String> header = new HashMap<String, String>();
                header.put("Referer", "http://star.gdtv.cn/");
                header.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1");
                return HeaderUtil.addHeader(m3u8, header);
            }
        }
        return null;
    }
}
