package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HeaderUtil;
import com.readyidu.util.HttpUtil;

import java.util.HashMap;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class GdtvSource extends Source {

    public GdtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_GDTV_STV:
                String gdtvStv = HttpUtil.httpGet("http://star.gdtv.cn/m2o/channel/channel_info.php?id=25");
                JSONArray gdtvArray = JSON.parseArray(gdtvStv);
                if (gdtvArray != null && gdtvArray.size() > 0) {
                    JSONObject gdtvObject = gdtvArray.getJSONObject(0);
                    if (gdtvObject != null) {
                        String m3u8 = gdtvObject.getString("m3u8");
                        HashMap<String, String> header = new HashMap<String, String>();
                        header.put("Referer", "http://star.gdtv.cn/");
                        header.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1");
                        return HeaderUtil.addHeader(m3u8, header);
                    }
                }
            default:
                return null;
        }
    }
}
