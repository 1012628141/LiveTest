package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/8/3.
 */
public class TvCatSource extends Source {
    private static final String CACHE_NAME = "source_";
    public TvCatSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String tvCatStv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_TVCAT_CCTV1:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608807420&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV2:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608807428&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV3:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=624878271&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV4:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608807424&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV5:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608788135&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV6:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=624878396&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV8:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=624878356&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
//                case SourceConstants.SOURCE_TVCAT_CCTV9:
//                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608920109&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
//                    break;
                case SourceConstants.SOURCE_TVCAT_CCTV13:
                    tvCatStv = HttpUtil.httpGet("http://a.hlyy.cc/migu-video.php?id=608807423&type=cctv&form=m", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1", null);
                    break;
                default:
                    break;
            }
            System.out.println(tvCatStv);
            if (tvCatStv!=null&&!"".equals(tvCatStv)){
                Pattern pattern = Pattern.compile("http://[A-Za-z0-9?=&.:/_+-]*");
                Matcher mather = pattern.matcher(tvCatStv);
                if (mather.find()) {
                    return  mather.group();
                }
            }
            return null;
        } else {
            return cacheSource;
        }
    }
}
