package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FengmiSource extends Source {
    public FengmiSource(String sourceId,int index) {
        super(sourceId,index);
    }

    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        String regex = "<url>([\\s\\S]*?)</url>";
        List<String > list = new ArrayList<>();
        switch (sourceId){
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV1 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV2 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=3");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV3 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=4");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV4 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=5");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV5 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=6");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV5_add :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=10565");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV6 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=7");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV7 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=8");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV8 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=9");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV9 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=10");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV10 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=11");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV11 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=12");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV12 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=13");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV13 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=14");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV14 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=15");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV15 :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=16");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_FYZQ :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=400");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_SJDL :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=422");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_HJJC :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=423");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_GFJS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=888");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_GRFWQ :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=401");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_ZQZX :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1151");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_NEWS :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=1775");
                break;
            case SourceConstants.SOURCE_FENGMI_CCTV_CCTV_DOC :
                content = HttpUtil.httpGet("http://live.fengmizhibo.com:7856/api/tvlive2.0/channel_detail.action?channelid=11238");
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
            result = list.get(index) ;
        }

        return result + "$1";
    }
    public  byte[] decodeBase64(String input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj=mainMethod.invoke(null, input);
        return (byte[])retObj;
    }
}
