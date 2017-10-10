package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/8/3.
 */
public class TvCatSource extends Source {
    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public TvCatSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
            String tvCatStv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_TVCAT_HUNAN_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=603996975&type=vip&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_ZHEJIANG_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=623539769&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_JIANGSU_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=623899368&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_DONGFANG_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=619811679&type=live&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_ANHUI_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=624878947&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_BEIJING_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=615912578&type=migu&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CHONGQING_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=609024130&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_TIANJIN_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=627065430&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_GUANGDONG_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608831231&type=migu&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_SHANDONG_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=619618278&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_SHENZHEN_STV:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=604326724&type=cmv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                default:
                    break;
            }
            if (tvCatStv!=null&&!"".equals(tvCatStv)){
                Pattern pattern = Pattern.compile("http://[A-Za-z0-9?=&.:/%_-]*");
                Matcher mather = pattern.matcher(tvCatStv);
                if (mather.find()) {
                    return  mather.group();
                }
            }
            return null;
    }
}
