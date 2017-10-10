package com.readyidu.source.local.cctv.source;

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
public class LiangTVSource extends Source{
    public LiangTVSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        JSONObject obj =new JSONObject();
        String result = null;
        String playUrl = null;
        switch (sourceId){
            case SourceConstants.SOURCE_LIANG_CCTV1:
                obj.put("videoId","5250");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV2:
                obj.put("videoId","3567");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV3:
                obj.put("videoId","5251");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV4:
                obj.put("videoId","5248");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV7:
                obj.put("videoId","5253");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV8:
                obj.put("videoId","5254");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV9:
                obj.put("videoId","5255");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV10:
                obj.put("videoId","5256");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV11:
                obj.put("videoId","5257");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV12:
                obj.put("videoId","5258");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV13:
                obj.put("videoId","5247");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV14:
                obj.put("videoId","5246");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
            case SourceConstants.SOURCE_LIANG_CCTV15:
                obj.put("videoId","5259");
                result = HttpUtil.sendPost("http://appproxy.gx-newmedia.com/videoDetailInfo.do",obj.toString());
                break;
        }
        if (!NullUtil.isNullObject(result))
        {
            JSONObject jsonObj = JSONObject.parseObject(result);
            playUrl = jsonObj.getJSONObject("content").getString("playUrl");
        }
        return playUrl;
    }
}
