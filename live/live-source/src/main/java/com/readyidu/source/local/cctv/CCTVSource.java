package com.readyidu.source.local.cctv;

import com.alibaba.fastjson.JSON;
import com.readyidu.source.base.Source;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import org.apache.http.util.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 2017/6/15
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public class CCTVSource extends Source {

    public CCTVSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String source = sourceId;

        if (TextUtils.isEmpty(source)) {
            return null;
        }

        String cacheResult = CacheUtil.get("source_cctv_vd_" + sourceId);
        if ( cacheResult != null ) {
            return cacheResult;
        }

        // Sources url: http://vdn.live.cntv.cn/api2/liveHtml5.do?channel=pa://cctv_p2p_hdcctv2&client=html5
        String javascript = "http://vdn.live.cntv.cn/api2/liveHtml5.do?channel=pa://cctv_p2p_hdcctv" + source +"&client=html5";
        String scriptResult = HttpUtil.httpGet(javascript);
        scriptResult = scriptResult.replace("var html5VideoData='", "");
        scriptResult = scriptResult.replace("';getHtml5VideoData(html5VideoData);", "");

        CCTV cctv = JSON.parseObject(scriptResult, CCTV.class);

        if ( cctv.getAck().equals("yes") ) {
            for (String value: cctv.getFlv_url().values()) {
                String result = parseURL(value);
                if ( result != null ) {
                    return result;
                }
            }

            for (String value: cctv.getHds_url().values()) {
                String result = parseURL(value);
                if ( result != null ) {
                    return result;
                }
            }
        }

        return null;
    }

    private String parseURL(String value) {
        try {
            URL url = new URL(value);
            String[] component = url.getPath().split("/");
            if ( !component[component.length - 1].contains(".") ) {
                CacheUtil.set("source_cctv_vd_" + sourceId, value, 3600);
                return value;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
