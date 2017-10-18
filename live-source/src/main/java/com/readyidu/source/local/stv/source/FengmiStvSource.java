package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FengmiStvSource extends Source{
    public FengmiStvSource(String sourceId,int index) {
        super(sourceId,index);
    }

    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        String regex = "<url>([\\s\\S]*?)</url>";
        List<String > list = new ArrayList<>();
        switch (sourceId){
            case SourceConstants.SOURCE_FENGMI_STV_HNWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1786");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_BJWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1788");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_SZWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1790");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_JSWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1784");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_DFWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1789");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_GDWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1791");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HLJWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1792");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HBWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=10390");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_TJWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=10476");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HEBWSHD :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=10620");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_BJWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=60");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HNWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=46");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_GDWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=70");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_DFWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=81");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_SZWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=93");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HBWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=47");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_LNWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=36");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_SXWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=40");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_QHWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=592");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_GZWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=48");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HEBWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=37");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HENWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=38");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_JSWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=44");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_GXWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=50");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_CQWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=59");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_GSWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=52");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_AHWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=42");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_XZWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=54");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_JXWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=45");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_XJWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=55");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_NMGWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=56");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_YNWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=49");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_SCWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=58");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_TJWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=57");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_JLWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=35");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_SHANXWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=39");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_NXWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=53");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_DNWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=51");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_XMWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=337");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_NFWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=102");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_HLJWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=34");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_LYWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=31");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_BTWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1476");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_NLWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=10884");
                break;
            case SourceConstants.SOURCE_FENGMI_STV_SSWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=11001");
                break;

        }
        if(content != null && content != ""){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                String base64Url = matcher.group();
                if(!base64Url.contains("http://img.")){
                    try {
                        String url = new String(decodeBase64(base64Url.substring(14, base64Url.indexOf("]"))));
                        if (!(url.contains("ivi") || url.contains("pa://"))) {
                            list.add(url);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(list != null){
            result = list.get(index)+"$1";
        }

        return result;
    }
    public  byte[] decodeBase64(String input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj=mainMethod.invoke(null, input);
        return (byte[])retObj;
    }
}
