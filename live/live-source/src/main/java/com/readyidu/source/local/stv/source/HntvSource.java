package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yuzhang on 2017/6/25.
 */
public class HntvSource extends Source {

    public HntvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String hntvStv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_HNTV_STV:
                hntvStv = HttpUtil.httpGet("http://www.hntv.tv/soms4/web/jwzt/player/live_ipad_player.jsp?channelId=135");
                break;
            default:
                break;
        }
        Pattern pattern = Pattern.compile("http://live.hntv.tv:9600/live/live1/500k/tzwj_video.m3u8\\?KEY1=[a-z0-9]+&KEY2=[a-z0-9]+");
        Matcher matcher = pattern.matcher(hntvStv);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }
}
