package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import com.readyidu.util.TimeUtil;
import org.apache.http.client.methods.HttpGet;

import java.sql.Time;

/**
 * Created by 123 on 2017/9/28.
 */
public class TianyiStvSource extends Source {
    public TianyiStvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String content = null;
        String result = null;
        switch (sourceId)
        {
            case SourceConstants.SOURCE_TIANYI_ANHUI_STV:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=4374343&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_LIAONING_STV:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=19205878&_="+TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_BEIJING_STV:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=19205864&_="+TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_SHENZHEN_STV:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24514770&_="+TimeUtil.getCurrentTime());
                break;
        }
        if (!NullUtil.isNullObject(content))
        {
            JSONObject jsonObject = JSON.parseObject(content);
            JSONObject rateUrls = jsonObject.getJSONObject("data").getJSONObject("rateUrls");
            switch (index)
            {
                case 1:
                    result = rateUrls.getString("defaultUrl");
                    break;
                case 2:
                    result = rateUrls.getString("hdUrl");
                    break;
                case 3:
                    result = rateUrls.getString("highUrl");
                    break;
            }
        }
        return result;
    }
}
