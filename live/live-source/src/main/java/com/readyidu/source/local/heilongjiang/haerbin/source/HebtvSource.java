package com.readyidu.source.local.heilongjiang.haerbin.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/27.
 */
public class HebtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1200;

    public HebtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String Dom = null;
        Dom = HttpUtil.httpGet("http://medias.hrbtv.net//hrbwltv/liveChannel/PC/videoAll.jsonp");
        Pattern pattern = Pattern.compile("http://streamings.hrbtv.net/live/[a-z0-9]+\\?fmt=h264_400k_flv");
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
            case SourceConstants.SOURCE_HLJTV_HEBTV1:
                if (!res[0].isEmpty()) {
                    return res[0];
                }
                break;
            case SourceConstants.SOURCE_HLJTV_HEBTV2:
                if (!res[1].isEmpty()) {
                    return res[1];
                }
                break;
            case SourceConstants.SOURCE_HLJTV_HEBTV3:
                if (!res[2].isEmpty()) {
                    return res[2];
                }
                break;
            case SourceConstants.SOURCE_HLJTV_HEBTV4:
                if (!res[3].isEmpty()) {
                    return res[3];
                }
                break;
            case SourceConstants.SOURCE_HLJTV_HEBTV5:
                if (!res[4].isEmpty()) {
                    return res[4];
                }
                break;
            default:
                break;
        }
        return null;
    }

//    public static void main(String[] args) {
//        String sourceId = "source_hljtv_hebtv6";
//        String Dom;
//        String url = null;
//        Dom = HttpUtil.httpGet("http://medias.hrbtv.net//hrbwltv/liveChannel/PC/videoAll.jsonp");
//        Pattern pattern = Pattern.compile("http://streamings.hrbtv.net/live/[a-z0-9]+\\?fmt=h264_400k_flv");
//        Matcher matcher = pattern.matcher(Dom);
//        ArrayList<String> tempList = new ArrayList<>();
//        while (matcher.find()) {
//            tempList.add(matcher.group());
//        }
//        String[] res = new String[tempList.size()];
//        int i = 0;
//        for (String temp : tempList) {
//            res[i] = temp;
//            i++;
//        }
//        switch (sourceId) {
//            case SourceConstants.SOURCE_HLJTV_HEBTV1:
//                if (!res[0].isEmpty())
//                    url = res[0];
//                break;
//            case SourceConstants.SOURCE_HLJTV_HEBTV2:
//                if (!res[1].isEmpty())
//                    url = res[1];
//                break;
//            case SourceConstants.SOURCE_HLJTV_HEBTV3:
//                if (!res[2].isEmpty())
//                    url = res[2];
//                break;
//            case SourceConstants.SOURCE_HLJTV_HEBTV4:
//                if (!res[3].isEmpty())
//                    url = res[3];
//                break;
//            case SourceConstants.SOURCE_HLJTV_HEBTV5:
//                if (!res[4].isEmpty())
//                    url = res[4];
//                break;
//            default:
//                break;
//        }
//        System.out.print(res.length);
//    }
}
