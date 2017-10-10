package com.readyidu.source.local.carousel.source;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/9.
 */
public class YichengCarouselSource extends Source {
    public YichengCarouselSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId){
            case SourceConstants.SOURCL_YICHENG_SPECIAL_TXWK:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001282017092709091745474101770&dataType=4&nodeId=9000000128");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_RJLB:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000662017090416340956946977780&dataType=4&nodeId=9000000066");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_ZQZYP:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000672017092712234071450054701&dataType=4&nodeId=9000000067");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_DM:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001262017092712275107093981963&dataType=4&nodeId=9000000126");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_TT:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001242017092211145506317264498&dataType=4&nodeId=9000000124");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_SS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001252017092211161550573513691&dataType=4&nodeId=9000000125");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_JQ:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001222017092617590133975925837&dataType=4&nodeId=9000000122");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_XZ:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001232017092015071932101867316&dataType=4&nodeId=9000000123");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_LS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000652017092115445162296235128&dataType=4&nodeId=9000000065");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_GQ:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=900000012104228739&dataType=4&nodeId=9000000121");
                break;
            case SourceConstants.SOURCL_YICHENG_SPECIAL_GM:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=900000012095151410&dataType=4&nodeId=9000000120");
                break;
        }
        if (!NullUtil.isNullObject(content)){
            JSONObject jsonObject = JSONObject.parseObject(content);
            JSONObject resulturls = jsonObject.getJSONArray("playUrls").getJSONObject(0) ;
            String uri = resulturls.getString("playurl");
            String m3u8 = HttpUtil.httpGet(uri).substring(HttpUtil.httpGet(uri).lastIndexOf("\"")+1).trim();
            String resultM3u8 = null ;
            if(m3u8.startsWith("http://")){ //判断m3u8是否以http：开头，若是直接返回m3u8
                resultM3u8 = m3u8 ;
            }else if(m3u8.startsWith("../")){ //判断m3u8是否是相对路径，若是，根据路径返回m3u8
                int cnt = 0;
                int offset = 0;
                while((offset = m3u8.indexOf("../", offset)) != -1){
                    offset = offset + "../".length();
                    cnt++;
                }
                String subM3u8 = m3u8.substring(m3u8.lastIndexOf("../"+2));
                String subUri = null ;
                for (int i=0;i<cnt+1;i++){
                    subUri = uri.substring(0,uri.lastIndexOf("/"));
                }
                resultM3u8 = subUri + subM3u8 ;
            }else if(m3u8.startsWith("/")){ //将m3u8拼接在根目录后
                resultM3u8 = uri.substring(0,uri.indexOf("/")) + m3u8;
            }else {//在目录后将m3u8替换
                resultM3u8 = uri.substring(0,uri.lastIndexOf("/")+1) + m3u8 ;
                System.out.print(resultM3u8);
            }
            switch (index){
                case 0:
                    result = resultM3u8 ;
                    break;
                case 1:
                    result = new StringBuffer(resultM3u8).insert(resultM3u8.indexOf("/",30),"hd").insert(resultM3u8.lastIndexOf(".")+2,"hd").toString(); //将普清节目转化成高清节目
                    System.out.print(result);
                    break;
            }
        }
        return result;
    }
}
