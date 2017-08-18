package com.readyidu.source.local.hubei.wuhan.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/26.
 */
public class WhtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1200;

    public WhtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String Dom;
        Dom = HttpUtil.httpGet("http://115.231.22.25/player.whtv.com.cn/hhtv/liveChannel/PC/videoAll.jsonp", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", "http://www.whtv.com.cn/tv/1/online/");
        Pattern pattern = Pattern.compile("http://live.whtv.com.cn/live/[a-z0-9]+\\?fmt=h264_700k_flv");
        Matcher matcher = pattern.matcher(Dom);
        ArrayList<String> tempList = new ArrayList<>();
        while (matcher.find()) {
            tempList.add(matcher.group());
        }
        String[] res = new String[tempList.size()];
        int i = 0;
        for (String temp : tempList) {
            res[i] = temp;
            i++;
        }
        switch (sourceId) {
            case SourceConstants.SOURCE_HBTV_WHTV1:
                if (!res[1].isEmpty())
                    return res[1];
            case SourceConstants.SOURCE_HBTV_WHTV2:
                if (!res[3].isEmpty())
                    return res[3];
            case SourceConstants.SOURCE_HBTV_WHTV3:
                if (!res[5].isEmpty())
                    return res[5];
            case SourceConstants.SOURCE_HBTV_WHTV4:
                if (!res[7].isEmpty())
                    return res[7];
            case SourceConstants.SOURCE_HBTV_WHTV5:
                if (!res[9].isEmpty())
                    return res[9];
            case SourceConstants.SOURCE_HBTV_WHTV6:
                if (!res[11].isEmpty())
                    return res[11];
            case SourceConstants.SOURCE_HBTV_WHTV7:
                if (!res[13].isEmpty())
                    return res[13];
            case SourceConstants.SOURCE_HBTV_WHTV8:
                if (!res[15].isEmpty())
                    return res[15];
            case SourceConstants.SOURCE_HBTV_WHTV9:
                if (!res[16].isEmpty())
                    return res[16];
            default:
                break;
        }
        return null;
    }
}
