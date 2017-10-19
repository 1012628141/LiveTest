package com.readyidu.source.local.cctv.source;

import com.readyidu.pojo.SourceCheckResult;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import com.readyidu.util.SourceCheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/10/17.
 */
public class IPTVSource extends Source {
    public IPTVSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String content = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_IPTV_CCTV1:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=ffa6682d13d46462a1cc9724269ea953&vid=10001");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV2:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=1c380261643814ad4d7302eb5d475600&vid=10002");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV3:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=3c90c3a6805ddd251f278c6606ec9b58&vid=10003");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV4:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=983428e47753ecae8c77b056bd32134a&vid=10004");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV5:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=a1a32f6a037f3dca45f4aa2555e6d86c&vid=10005");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV6:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=147ef4ac688df4eeba1f41e01652f274&vid=10006");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV7:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=1de0cd162521665abf716d6a1508e7b4&vid=10007");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV8:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=c9111785e4cf1744f42af259a8812dae&vid=10008");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV9:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=192b892cd54839098f10f4920e56f6ea&vid=10009");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV10:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=71c21ab2b22b1e2f593a64cc5c3b8036&vid=10010");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV11:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&token=d542dc356d1bd79fb4ae7ff21e105a99&vid=10011");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV12:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&vid=10012");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV13:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&vid=10013");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV14:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&vid=10014");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV15:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&vid=10015");
                break;
            case SourceConstants.SOURCE_IPTV_CCTV5ADD:
                content = HttpUtil.httpGet("http://www.iptv.hk.cn/tv.php?act=play&vid=10016");
                break;
        }
        if (!NullUtil.isNullObject(content)) {
            Pattern pattern = Pattern.compile("value=\"http://[a-zA-z0-9./?=:]+");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                String str = matcher.group();
                String url = str.replace("value=\"", "");
                SourceCheckResult result = SourceCheck.playCheck(url);
                if (!NullUtil.isNullObject(result)&&result.isAvailable()&&result.getPixel().getWidth()>1200)
                {
                    return url + "$1";
                }
            }
        }
        return null;
    }
}
