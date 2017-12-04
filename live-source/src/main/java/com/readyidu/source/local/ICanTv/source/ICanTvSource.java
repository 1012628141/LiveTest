package com.readyidu.source.local.ICanTv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICanTvSource extends Source {
    public ICanTvSource(String sourceId, int index) {
        super(sourceId, index);
    }
    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId) {
            case SourceConstants.SOURCE_ICAN_STV_HNWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/habc.php?id=19");
                break;
        }
        if(!NullUtil.isNullObject(content)){
            String regex1 = "a: 'http:([\\s\\S]*?).m3u8[?]+([\\s\\S]*?)'";
            String regex2 = "f:'rtmp:([\\s\\S]*?)'";
            String regex3 = "f:'http:([\\s\\S]*?).flv[?]?([\\s\\S]*?)'";
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher = pattern1.matcher(content);
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(content);
            Pattern pattern3 = Pattern.compile(regex3);
            Matcher matcher3 = pattern3.matcher(content);

            if (matcher.find()){
                result = matcher.group().replace("a: '","").replace("\"","");
            }else if(matcher2.find()){
                result = matcher2.group().replace("f:'","").replace("\"","");
            }else if (matcher3.find()){
                result = matcher2.group().replace("f:'","").replace("\"","");
            }else {
                return null;
            }
        }
        return result ;
    }

    @Override
    public String getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
