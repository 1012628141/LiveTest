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
        String cookie = "safedog-flow-item=; UM_distinctid=160687896591-0282c0f76ffd3e-16386656-1fa400-1606878965a1c6; acw_tc=AQAAAPK1mnTm8wsAayRL2qSBZBuz41PC; ASPSESSIONIDCABTDBQS=GPODJLHDDIFKHBFDOHCDILCH; CNZZDATA1092578=cnzz_eid%3D1766439046-1513580355-http%253A%252F%252Fwww.3xgd.com%252F%26ntime%3D1513580355; AJSTAT_ok_times=1; __51cke__=; AJSTAT_ok_pages=4; __tins__2195998=%7B%22sid%22%3A%201513581230027%2C%20%22vd%22%3A%204%2C%20%22expires%22%3A%201513583066867%7D; __51laig__=4";
        switch (sourceId) {
            case SourceConstants.SOURCE_HBTV_YCTV1:
                Dom = HttpUtil.httpGet("http://live.3xgd.com/getzburl.asp?ChannelID=1","","http://live.3xgd.com/?ChannelID=1",cookie);
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
