package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import org.apache.http.util.TextUtils;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/6/28.
 */
public class MgtvSource extends Source {
    private static final String CACHE_NAME = "source_";


    public MgtvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String source = sourceId;

        if (TextUtils.isEmpty(source)) {
            return null;
        }

        String cacheResult = CacheUtil.get(CACHE_NAME + sourceId+":"+index);
        if (cacheResult != null) {
            return cacheResult;
        }

        String mgapi=null;
        List<String> sourceList=new ArrayList();
        List<String> steamList=new ArrayList();
        switch (sourceId){
            case SourceConstants.SOURCE_MGTV_STV:
                mgapi= HttpUtil.httpGet("http://pcweb.api.mgtv.com/player/video?video_id=3987967");
        }
        //"stream_domain":\[.*\
        Pattern pattern1 = Pattern.compile("\"stream\":\\[.*\\]");
        Pattern pattern2 = Pattern.compile("\"stream_domain\":\\[.*\\]");
        Pattern pattern3 = Pattern.compile("/vod.do\\?\\w*[a-zA-Z0-9=&_~-]*");
        Pattern pattern4 = Pattern.compile("http://[a-z0-9.]*");
        Pattern pattern5 = Pattern.compile("http://[a-zA-z0-9./?=&~%]*");
        Matcher matcher1 = pattern1.matcher(mgapi);
        if (matcher1.find()){
            String apiUrl=matcher1.group();
            Matcher matcher2=pattern2.matcher(apiUrl);
            if (matcher2.find()) {
                Matcher matcher4= pattern4.matcher(matcher2.group());
                while (matcher4.find()){
                    steamList.add(matcher4.group());
                }
            }
            Matcher matcher3=pattern3.matcher(apiUrl);
            while (matcher3.find()){
                sourceList.add(matcher3.group());
            }
        }
        String resultUrl=null;
        switch (index){
            case 1:
                resultUrl=steamList.get(0)+sourceList.get(0);
                break;
            case 2:
                resultUrl=steamList.get(1)+sourceList.get(1);
                break;
            case 3:
                resultUrl=steamList.get(2)+sourceList.get(2);
                break;
        }
        String resultStr=HttpUtil.httpGet(resultUrl);
        Matcher matcher5=pattern5.matcher(resultStr);
        if (matcher5.find()){
            CacheUtil.set(CACHE_NAME + sourceId+":"+index, matcher5.group(), 300);
            return  matcher5.group();
        }
        return null;
    }
}
