package com.readyidu.source.local.stv.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/22.
 */
public class Shiting5Source extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public Shiting5Source(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String shiting5Stv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_SHITING_TIANJIN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/tianjinweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_HENAN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/henanweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_GUIZHOU_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/guizhouweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_FENGHUANG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/fenghuangweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_BEIJING_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/btv1.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_CHONGQING_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/chongqingweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_HUNAN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/hunanweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_ZHEJIANG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/zhejiangweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_JIANGSU_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/jiangsuweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_ANHUI_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/anhuiweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_GUANGDONG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/guangdongweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_LVYOU_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/lvyouweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_GUANGXI_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/guangxiweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_HUBEI_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/hubeiweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_JIANGXI_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/jiangxiweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_SHANDONG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/shandongweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_SICHUAN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/sichuanweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_SHENZHEN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/shenzhenweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_HEBEI_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/hebeiweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_SHANXI_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/sanxiweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_LIAONING_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/liaoningweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_JILIN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/jilinweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_YUNNAN_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/yunnanweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_HEILONGJIANG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/heilongjiangweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_GANSU_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/gansuweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_XINJIANG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/xinjiangweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_NEIMENG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/neimengguweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_XIZANG_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/xizangweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_SHITING_NINGXIA_STV:
                    shiting5Stv = HttpUtil.httpGet("http://m.shiting5.com/tv/ningxiaweishi.html", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                default:
                    break;
            }
            System.out.println(shiting5Stv  );
            if (!NullUtil.isNullObject(shiting5Stv)) {
                Pattern pattern = Pattern.compile("src=\"http://[a-z0-9A-Z-./_:]+.m3u8");
                Matcher matcher = pattern.matcher(shiting5Stv);
                if (matcher.find()) {
                    String src = matcher.group(0);
                    if (!NullUtil.isNullObject(src)) {
                        src = src.replace("src=\"", "");
                        CacheUtil.set(CACHE_NAME + sourceId, src, CHACHE_TIMEOUT);
                        return src;
                    }
                }
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
