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
            case SourceConstants.SOURCE_YINGXI_YINGXITV2 :
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
            case SourceConstants.SOURCL_YICHENG_STV_BJWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000822017092514014576060247515&dataType=4&nodeId=9000000082");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_HBWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000932017092218041585891747059&dataType=4&nodeId=9000000093");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_YNWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001092017092218060910580489954&dataType=4&nodeId=9000000109");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_LNWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000962017092218043345970167285&dataType=4&nodeId=9000000096");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_JXWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000952017092218042784222473216&dataType=4&nodeId=9000000095");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_JLWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000942017092218042199911258312&dataType=4&nodeId=9000000094");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_HEBWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000912017092514030840490431969&dataType=4&nodeId=9000000091");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_HLJWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000922017092218041044147484431&dataType=4&nodeId=9000000092");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_CQWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000842017092514015588888070114&dataType=4&nodeId=9000000084");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_GSWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000892017092514022557362382826&dataType=4&nodeId=9000000089");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_SCWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001042017092218053730666425077&dataType=4&nodeId=9000000104");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_SXWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001032017092218053106922253581&dataType=4&nodeId=9000000103");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_QHWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001002017092218050432185068150&dataType=4&nodeId=9000000100");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_NMGWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000982017092218044881240756879&dataType=4&nodeId=9000000098");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_XZWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001062017092214043599051041548&dataType=4&nodeId=9000000106");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_KBWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001082017092615571553882230096&dataType=4&nodeId=9000000108");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_SDWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000762017092214023739082942088&dataType=4&nodeId=9000000076");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_BTWS :
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000832017092514015297846836230&dataType=4&nodeId=9000000083");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_YBWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000992017092218045783819460382&dataType=4&nodeId=9000000099");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_TJWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001052017092218054354534203291&dataType=4&nodeId=9000000105");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_GDWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000872017092514021414840994256&dataType=4&nodeId=9000000087");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_FJWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000862017092514020960571248287&dataType=4&nodeId=9000000086");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_GZWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000902017092514030324332951220&dataType=4&nodeId=9000000090");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_GXWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000882017092514022003139296234&dataType=4&nodeId=9000000088");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_SZWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001022017092218052487000438728&dataType=4&nodeId=9000000102");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_XJWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000001072017092218060206431773366&dataType=4&nodeId=9000000107");
                break;
            case SourceConstants.SOURCL_YICHENG_STV_LYWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000972017092214040823352115077&dataType=4&nodeId=9000000097");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_CN_A:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000402017092218014718637853353&dataType=4&nodeId=9000000040");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_CN_B:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000342017092218014406939224191&dataType=4&nodeId=9000000034");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_YN_A:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000412017092218015029338807374&dataType=4&nodeId=9000000041");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_YN_B:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000422017092218015557183668433&dataType=4&nodeId=9000000042");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_YR_A:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000432017092218020656692211792&dataType=4&nodeId=9000000043");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_YR_B:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000442017092218020957438861027&dataType=4&nodeId=9000000044");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_MZ_A:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000452017092218021254233296165&dataType=4&nodeId=9000000045");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_MZ_B:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000462017092218021560594659435&dataType=4&nodeId=9000000046");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_BS_A:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000472017092218021874585849250&dataType=4&nodeId=9000000047");
                break;
            case SourceConstants.SOURCL_YICHENG_PANDA_BS_B:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=90000000482017092218022173626910615&dataType=4&nodeId=9000000048");
                break;
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
            case SourceConstants.SOURCL_YICHENG_CCTV_NEWS:
                content = HttpUtil.httpGet("http://m.cctv4g.com/cntv/clt/getPlayUrl.msp?contId=0&dataType=4&nodeId=9000000017");
                break;
        }
        if (!NullUtil.isNullObject(content)){
            JSONObject jsonObject = JSONObject.parseObject(content);
            JSONObject resulturls = jsonObject.getJSONArray("playUrls").getJSONObject(0) ;
            String uri = resulturls.getString("playurl");
            switch (index){
                case 0:
                    result = uri ;
                    break;
                case 1:
                    String newContent = HttpUtil.httpGet(uri);
                    StringBuffer res = new StringBuffer(newContent.substring(newContent.indexOf("http")));
                    result = res.insert(res.indexOf("/",31),"hd").insert(res.lastIndexOf("."),"hd").toString(); //将普清节目转化成高清节目
            }
        }
        return result;
    }
}
