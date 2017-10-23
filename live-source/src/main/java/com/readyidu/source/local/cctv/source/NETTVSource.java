package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import org.omg.Dynamic.Parameter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/10/17.
 */
public class NETTVSource extends Source {
    public NETTVSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String content = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_NETTV_CCTV1:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv1.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV2:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv2.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV3:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv3.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV4:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv4.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV5:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv5.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV6:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv6.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV7:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv7.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV8:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv8.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV9:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv9.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV10:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv10.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV11:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv11.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV12:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv12.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV13:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv13.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV14:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv14.html");
                break;
            case SourceConstants.SOURCE_NETTV_CCTV15:
                content = HttpUtil.httpGet("http://www.nettv.live/cctv/cctv15.html");
                break;

        }
        if (content != null)
        { //rtmp://[a-zA-Z0-9./:_-]+
            Pattern pattern = Pattern.compile("rtmp://[a-zA-Z0-9./:_-]+");
            Matcher matcher = pattern.matcher(content);
            String regex = null ;
            if (matcher.find())
            {
                regex = matcher.group(0);
                return regex;
            }else
            {
                Pattern patternRtmp = Pattern.compile("http://[a-zA-Z0-9./:_]+.m3u8");
                Matcher matcher2 = patternRtmp.matcher(content);
                if (matcher2.find())
                {
                    regex = matcher2.group(0);
                    if (!regex.contains("vtime.cntv"))
                    {
                        return regex;
                    }
                }
            }
        }
        return null;
    }
}
