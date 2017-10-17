package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/9/20.
 */
public class LiangStvSource extends Source{
    public LiangStvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        JSONObject obj =new JSONObject();
        String result = null;
        String playUrl = null;
        switch (sourceId){
            case SourceConstants.SOURCE_LIANG_LYWS:
                obj.put("videoId","5243");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_SZWS:
                obj.put("videoId","5204");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_LNWS:
                obj.put("videoId","5226");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_DNWS:
                obj.put("videoId","5198");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_BJWS:
                obj.put("videoId","3585");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_GXWS:
                obj.put("videoId","5270");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
        }
        if (!NullUtil.isNullObject(result))
        {
            JSONObject jsonObj = JSONObject.parseObject(result);
            String url = jsonObj.getJSONObject("content").getString("playUrl");
            String m3u8Content = HttpUtil.httpGet(url);
            System.out.print(m3u8Content);
            playUrl = m3u8Content.substring(m3u8Content.indexOf("http"));
        }
        return playUrl;
    }
}
