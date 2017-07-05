package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSON;
import com.readyidu.source.base.Source;
import com.readyidu.source.model.CNTV;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CNTVSource extends Source {
    private static final Logger log = LoggerFactory.getLogger(CNTVSource.class);
    private static final String CACHE_NAME = "source_";

    public CNTVSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String source = sourceId;

        if (TextUtils.isEmpty(source)) {
            return null;
        }

        String cacheResult = CacheUtil.get(CACHE_NAME + sourceId);
        if (cacheResult != null) {
            return cacheResult;
        }

        String cntvJs = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_CNTV_XIAMENSTV:
                cntvJs = "http://vdn.live.cntv.cn/api2/liveHtml5.do?channel=pa://cctv_p2p_hdxiamen&client=html5";
                break;
            default:
                break;
        }

        // Sources url: http://vdn.live.cntv.cn/api2/liveHtml5.do?channel=pa://cctv_p2p_hdcctv2&client=html5
        String scriptResult = HttpUtil.httpGet(cntvJs);
        scriptResult = scriptResult.replace("var html5VideoData='", "");
        scriptResult = scriptResult.replace("';getHtml5VideoData(html5VideoData);", "");

        CNTV cntv = JSON.parseObject(scriptResult, CNTV.class);

        if (cntv.getAck().equals("yes")) {
            switch (index) {
                case 1:
                    for (String value : cntv.getHls_url().values()) {
                        if (!NullUtil.isNullObject(value)) {
                            CacheUtil.set(CACHE_NAME + sourceId, value, 1800);
                            return value;
                        }
                    }
                case 2:
                    for (String value : cntv.getFlv_url().values()) {
                        if (!NullUtil.isNullObject(value)) {
                            CacheUtil.set(CACHE_NAME + sourceId, value, 1800);
                            return value;
                        }
                    }
                case 3:
                    for (String value : cntv.getHds_url().values()) {
                        if (!NullUtil.isNullObject(value)) {
                            CacheUtil.set(CACHE_NAME + sourceId, value, 1800);
                            return value;
                        }
                    }
                default:
                    for (String value : cntv.getHls_url().values()) {
                        if (!NullUtil.isNullObject(value)) {
                            CacheUtil.set(CACHE_NAME + sourceId, value, 1800);
                            return value;
                        }
                    }
            }
        }

        return null;
    }
}
