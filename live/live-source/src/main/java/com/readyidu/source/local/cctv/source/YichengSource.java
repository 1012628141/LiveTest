package com.readyidu.source.local.cctv.source;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/9/27.
 */
public class YichengSource extends Source {
    public YichengSource(String sourceId,int index) {
        super(sourceId,index);
    }

    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId){
//            case SourceConstants.SOURCL_YICHENG_CCTV_1 :
//                content = HttpUtil.httpGet("");
            case SourceConstants.SOURCL_YICHENG_CCTV_1 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=-1&dataType=4&nodeId=9000000000");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_2 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000012017092814001075940156826&dataType=4&nodeId=9000000001");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_3 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000022017092814001182886272338&dataType=4&nodeId=9000000002");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_4 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000032017092114001611055924959&dataType=4&nodeId=9000000003");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_5 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000052017092205002027177003133&dataType=4&nodeId=9000000005");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_6 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000072017092218002680251943204&dataType=4&nodeId=9000000007");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_TY :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=-1&dataType=4&nodeId=9000000006");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_7 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000082017092214002398241327656&dataType=4&nodeId=9000000008");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_8 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000082017092214002398241327656&dataType=4&nodeId=9000000008");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_9 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000102017092218003709270296008&dataType=4&nodeId=9000000010");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_10 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000112017092114003977854292984&dataType=4&nodeId=9000000011");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_11 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000122017092218004916726785183&dataType=4&nodeId=9000000012");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_12 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000132017092218005445283904915&dataType=4&nodeId=9000000013");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_13 :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000142017092205003921344903672&dataType=4&nodeId=9000000014");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_SR :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000152017092218005983974939034&dataType=4&nodeId=9000000015");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_YY :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000162017092205005444013998176&dataType=4&nodeId=9000000016");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_DZCJ :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001172017090415144833750190954&dataType=4&nodeId=9000000117");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_FYZQ :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000262017092514003857264336100&dataType=4&nodeId=9000000026");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_DSZN :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000582017092205031136077864667&dataType=4&nodeId=9000000058");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_NXSS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000312017092205021064708992935&dataType=4&nodeId=9000000031");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_YSWHJP :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000292017092205015122511018781&dataType=4&nodeId=9000000029");
                break;
            case SourceConstants.SOURCL_YICHENG_CCTV_NEWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=0&dataType=4&nodeId=9000000017");
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
