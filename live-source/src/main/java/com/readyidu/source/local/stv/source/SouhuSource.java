package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/25.
 */
public class SouhuSource extends Source {
    public SouhuSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String content = null;
        switch (sourceId){
            case SourceConstants.SOURCE_SOUHU_BEIJING_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/307.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_ANHUI_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/140.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_GUANGDONG_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/329.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_SHENZHEN_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/367.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_HEILONGJIANG_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/83.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_SHANDONG_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/131.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_JIANGXI_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/173.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_TIANJING_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/274.json?api_key=f351515304020cad28c92f70f002261");
                break;
            case SourceConstants.SOURCE_SOUHU_SICHUAN_STV:
                content = HttpUtil.httpGet("http://live.m.tv.sohu.com/api/live/v1/stations/285.json?api_key=f351515304020cad28c92f70f002261");
                break;
        }
        if (!NullUtil.isNullObject(content))
        {
            JSONObject result = JSON.parseObject(content);
            JSONObject data = result.getJSONObject("data");
            if (!NullUtil.isNullObject(data))
            {
                return data.getJSONObject("tvStation").getString("liveUrl");
            }
        }
        return null;
    }
}
