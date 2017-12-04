package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICanStvSource extends Source {
    public ICanStvSource(String sourceId, int index) {
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
            case SourceConstants.SOURCE_ICAN_STV_JSWS:
                return "rtmp://202.195.240.8:1935/iptv/jshd";
//                content = HttpUtil.httpGet("");
//                break;
            case SourceConstants.SOURCE_ICAN_STV_ZJWS:
                return "http://www.icantv.cn/hls/zjtv/zjws.m3u8";
//                content = HttpUtil.httpGet("");
//                break;
            case SourceConstants.SOURCE_ICAN_STV_AHWS:
                return "http://r.gslb.lecloud.com/live/hls/201704243000000wn19/desc.m3u8";
//                content = HttpUtil.httpGet("");
//                break;
            case SourceConstants.SOURCE_ICAN_STV_DFWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/knews.php?id=dfws");
                break;
            case SourceConstants.SOURCE_ICAN_STV_GDWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdws");
                break;
            case SourceConstants.SOURCE_ICAN_STV_HLJWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljws");
                break;
            case SourceConstants.SOURCE_ICAN_STV_HBWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/mg.php?id=624878953");
                break;
            case SourceConstants.SOURCE_ICAN_STV_NMGWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/qqzb.php?id=100103800");
                break;
            case SourceConstants.SOURCE_ICAN_STV_SCWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/rtmp.php?streamUrl=rtmp://live2.ycsmcn.com:1935/SRT_Live/SCTV1_9178");
                break;
            case SourceConstants.SOURCE_ICAN_STV_GXWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/qqzb.php?id=100104000");
                break;
            case SourceConstants.SOURCE_ICAN_STV_YNWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/qqzb.php?id=100104400");
                break;
            case SourceConstants.SOURCE_ICAN_STV_GZWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/qqzb.php?id=100102800");
                break;
            case SourceConstants.SOURCE_ICAN_STV_QHWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/qqzb.php?id=100101600");
                break;
            case SourceConstants.SOURCE_ICAN_STV_SHANXIWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/qqzb.php?id=100006400");
                break;
//            case SourceConstants.SOURCE_ICAN_STV_GDNFWS:
//                content = HttpUtil.httpGet("http://live.tv.sohu.com/live/player_json.jhtml?encoding=utf-8&lid=333&type=1&callback=jsonp");
//                break;
            case SourceConstants.SOURCE_ICAN_STV_BTWS:
                return "http://www.icantv.cn/rtmp.php?streamUrl=rtmp://v.btzx.com.cn/live/weishi.stream";
//                content = HttpUtil.httpGet("");
//                break;
            case SourceConstants.SOURCE_ICAN_STV_LYWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/m3u8.php?streamUrl=http://stream1.hnntv.cn/lyws/sd/live.m3u8");
                break;
            case SourceConstants.SOURCE_ICAN_STV_SSWS:
                content = HttpUtil.httpGet("http://www.icantv.cn/m3u8.php?streamUrl=http://stream1.hnntv.cn/ssws/sd/live.m3u8");
                break;
//            case SourceConstants.SOURCE_ICAN_STV_:
//                content = HttpUtil.httpGet("");
//                break;

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
                result = matcher.group().replace("a: '","").replace("\'","");

            }else if(matcher2.find()){
                result = matcher2.group().replace("f:'","").replace("\'","");

            }else if (matcher3.find()){
                result = matcher2.group().replace("f:'","").replace("\'","");

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
