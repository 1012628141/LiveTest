package com.readyidu.source.local.hubei.yichang.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/26.
 */
public class YctvSource extends Source {

    public YctvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String Dom = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_HBTV_YCTV1:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=1");
                break;
            case SourceConstants.SOURCE_HBTV_YCTV2:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=2");
                break;
            case SourceConstants.SOURCE_HBTV_YCTV3:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=11");
                break;
        }
        Pattern pattern = Pattern.compile("http://zb.3xgd.com:1935/.*.&wowzatokenhash=.*.=");
        Matcher matcher = pattern.matcher(Dom);
        if (matcher.find()) {
            Dom = matcher.group(0);
        }
        return Dom;
    }

//    public static void main(String[] args) {
//        String sourceId = "source_hbtv_yctv3";
//        String Dom = null;
//        switch (sourceId) {
//            case SourceConstants.SOURCE_HBTV_YCTV1:
//                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=1");
//                break;
//            case SourceConstants.SOURCE_HBTV_YCTV2:
//                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=2");
//                break;
//            case SourceConstants.SOURCE_HBTV_YCTV3:
//                Dom = HttpUtil.httpGet("http://live.3xgd.com/?ChannelID=11");
//                break;
//            default:
//                break;
//        }
//        Pattern pattern = Pattern.compile("http://zb.3xgd.com:1935/.*.&wowzatokenhash=.*.=");
//        Matcher matcher = pattern.matcher(Dom);
//        if (matcher.find()) {
//            Dom = matcher.group(0);
//        }
//        System.out.print(Dom);
//    }
}
