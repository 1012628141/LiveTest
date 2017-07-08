package com.readyidu.source.local.stv.source;

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
 * Created by 123 on 2017/6/28.
 */
public class CqtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public CqtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String cqtv = null;
            switch (sourceId) {
                case SourceConstants.SOURCE_CQTV_STV:
                    cqtv = HttpUtil.httpGet("http://app.cbg.cn/?app=activity&controller=wwsp&action=hlive_md5&callback=jQuery17205951347704536105_1498642636828&ch=%2Fapp_2%2F_definst_%2Fls_2.stream%2Fchunklist.m3u8&_=1498642724973");
                    //http:\/\/sjlivecdn.cbg.cn\/201706281738\/159577efb835be6bdb9c0396518ead0e\/app_2\/_definst_\/ls_2.stream\/chunklist.m3u8
                    cqtv = cqtv.replace("ï»¿jQuery17205951347704536105_1498642636828(\"", "").replace("\")", "").replace("\\", "");
                    break;
            }
            if (NullUtil.isNullObject(cqtv)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, cqtv, CHACHE_TIMEOUT);
                return cqtv;
            }
        } else {
            return cacheSource;
        }
    }
}
