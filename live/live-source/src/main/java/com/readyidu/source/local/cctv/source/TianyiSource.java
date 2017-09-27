package com.readyidu.source.local.cctv.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import com.readyidu.util.TimeUtil;

import java.util.Date;

/**
 * Created by 123 on 2017/9/27.
 */
public class TianyiSource extends Source{
    public TianyiSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String content = null;
        String result = null;
        switch (sourceId)
        {
            case SourceConstants.SOURCE_TIANYI_CCTV1:
               content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=4275314&_="+ TimeUtil.getCurrentTime());
               break;
            case SourceConstants.SOURCE_TIANYI_CCTV2:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=4275324&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV3:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24448602&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV5:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24399588&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV6:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24399669&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV8:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=4275316&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV9:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=16223231&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV10:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=4275328&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV11:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24400307&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV12:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=4275329&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV13:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24401040&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV14:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=16223228&_="+ TimeUtil.getCurrentTime());
                break;
            case SourceConstants.SOURCE_TIANYI_CCTV5A:
                content = HttpUtil.httpGet("http://m.tv189.com/480/protected/controllers/getData.jsp?act=getRate&contid=24404614&_="+ TimeUtil.getCurrentTime());
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
