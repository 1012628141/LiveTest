package com.readyidu.source.local.hubei.wuhan.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/26.
 */
public class WhtvSource extends Source {

    public WhtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String Dom;
        Dom = HttpUtil.httpGet("http://115.231.22.25/player.whtv.com.cn/hhtv/liveChannel/PC/videoAll.jsonp");
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
                if (!res[17].isEmpty())
                    return res[17];
            default:
                return null;
        }
    }

//    public static void main(String[] args) {
//        String sourceId = "source_hbtv_whtv9";
//        String Dom;
//        String url = null;
//        Dom = HttpUtil.httpGet("http://115.231.22.25/player.whtv.com.cn/hhtv/liveChannel/PC/videoAll.jsonp");
//        Pattern pattern = Pattern.compile("http://live.whtv.com.cn/live/[a-z0-9]+\\?fmt=h264_700k_flv");
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
//            case SourceConstants.SOURCE_HBTV_WHTV1:
//                if (!res[1].isEmpty())
//                    url = res[1];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV2:
//                if (!res[3].isEmpty())
//                    url = res[3];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV3:
//                if (!res[5].isEmpty())
//                    url = res[5];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV4:
//                if (!res[7].isEmpty())
//                    url = res[7];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV5:
//                if (!res[9].isEmpty())
//                    url = res[9];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV6:
//                if (!res[11].isEmpty())
//                    url = res[11];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV7:
//                if (!res[13].isEmpty())
//                    url = res[13];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV8:
//                if (!res[15].isEmpty())
//                    url = res[15];
//                break;
//            case SourceConstants.SOURCE_HBTV_WHTV9:
//                if (!res[17].isEmpty())
//                    url = res[17];
//                break;
//            default:
//                break;
//        }
//        System.out.print(url);
//    }
}
