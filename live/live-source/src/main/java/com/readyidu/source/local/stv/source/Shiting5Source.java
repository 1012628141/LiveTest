package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/22.
 */
public class Shiting5Source extends Source {

    public Shiting5Source(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
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
            default:
                break;
        }
        Pattern pattern = Pattern.compile("src=\"http://[a-z0-9A-Z./_:]+.m3u8");
        Matcher matcher = pattern.matcher(shiting5Stv);
        if (matcher.find()) {
            String src = matcher.group(0);
            if (!NullUtil.isNullObject(src)) {
                return src.replace("src=\"", "");
            }
        }
        return null;
    }
}
