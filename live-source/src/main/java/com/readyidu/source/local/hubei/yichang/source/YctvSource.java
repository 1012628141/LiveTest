package com.readyidu.source.local.hubei.yichang.source;

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
 * Created by Administrator on 2017/6/26.
 */
public class YctvSource extends Source {

    public YctvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String Dom = null;
        String cookie = "safedog-flow-item=; UM_distinctid=15fde8740f914f-0da6de937de0ca-5b4a2c1d-100200-15fde8740fa1ab; acw_tc=AQAAACnkQQ/PLg8AayRL2qQwhdflkV23; ASPSESSIONIDACARCDSQ=IFDFBAACGLEMDNKKBCOHHECP; CNZZDATA1092578=cnzz_eid%3D1207074652-1511262008-http%253A%252F%252Fwww.3xgd.com%252F%26ntime%3D1511262008; AJSTAT_ok_pages=2; AJSTAT_ok_times=1; __tins__2195998=%7B%22sid%22%3A1511266981896%2C%22vd%22%3A2%2C%22expires%22%3A1511268787473%7D; __51cke__=; __51laig__=2";
        switch (sourceId) {
            case SourceConstants.SOURCE_HBTV_YCTV1:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/getzburl.asp?ChannelID=1","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36","http://live.3xgd.com/?ChannelID=1","safedog-flow-item=; UM_distinctid=15fde8740f914f-0da6de937de0ca-5b4a2c1d-100200-15fde8740fa1ab; acw_tc=AQAAACnkQQ/PLg8AayRL2qQwhdflkV23; ASPSESSIONIDACARCDSQ=IFDFBAACGLEMDNKKBCOHHECP; CNZZDATA1092578=cnzz_eid%3D1207074652-1511262008-http%253A%252F%252Fwww.3xgd.com%252F%26ntime%3D1511262008; AJSTAT_ok_pages=2; AJSTAT_ok_times=1; __tins__2195998=%7B%22sid%22%3A1511266981896%2C%22vd%22%3A2%2C%22expires%22%3A1511268787473%7D; __51cke__=; __51laig__=2");
                //Dom = HttpUtil.httpGet("http://live.3xgd.com/geturl.asp?ChannelID=1","", "http://live.kankanews.com/huikan/");
                break;
            case SourceConstants.SOURCE_HBTV_YCTV2:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/getzburl.asp?ChannelID=2","", "http://live.3xgd.com/?ChannelID=2",cookie);
                break;
            case SourceConstants.SOURCE_HBTV_YCTV3:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/getzburl.asp?ChannelID=11","", "http://live.3xgd.com/?ChannelID=11",cookie);
                break;
            default:
                break;
        }
        Pattern pattern = Pattern.compile("http://[a-zA-Z0-9./]+m3u8\\?[a-zA-Z0-9-._=&]+");
        Matcher matcher = pattern.matcher(Dom);
        if (matcher.find()) {
            Dom = matcher.group(0);
        }
        return Dom;
    }
}
