package com.readyidu.source.local.shandong.shandong.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Administrator on 2017/6/27.
 */
public class SdtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public SdtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = CacheUtil.get(CACHE_NAME + sourceId);
        if (NullUtil.isNullObject(cacheSource)) {
            String js = HttpUtil.httpGet("http://liveauth.iqilu.com/nc_gs?channel=typd&callback=callback_iqp_1","Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1"," http://v.iqilu.com/live/typd/");
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine scriptEngine = factory.getEngineByName("javascript");
            try {
               String result = scriptEngine.eval(js).toString();
                System.out.print(result);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            switch (sourceId) {
                case SourceConstants.SOURCE_SDTV_JNTV1:
                    cacheSource = HttpUtil.httpGet("http://wwwapi.ijntv.cn/m2o/player/drm/drmJh56F4.php?url=http%3A%2F%2Fts3%2Eijntv%2Ecn%2Fjnqtx%2Fsd%2Flive%2Em3u8", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0", null);
                    break;
                default:
                    break;
            }
            if (NullUtil.isNullObject(cacheSource)) {
                return null;
            } else {
                CacheUtil.set(CACHE_NAME + sourceId, cacheSource, CHACHE_TIMEOUT);
                return cacheSource;
            }
        } else {
            return cacheSource;
        }
    }

    public static void main(String[] args) {
        String js = HttpUtil.httpGet("http://liveauth.iqilu.com/nc_gs?channel=typd&callback=callback_iqp_1","Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1"," http://v.iqilu.com/live/typd/");
//        HtmlUnitDriver webDriver = new HtmlUnitDriver();
//        ScriptEngineManager factory = new ScriptEngineManager();
//        ScriptEngine scriptEngine = factory.getEngineByName("javascript");
//        try {
//            js = js.replace("eval","document.write");
//            scriptEngine.eval(js);
//            String result = (String)scriptEngine.eval(js);
//            System.out.print(result);
//            Invocable inv = (Invocable)scriptEngine;
//            System.out.print(result);
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
    }
}