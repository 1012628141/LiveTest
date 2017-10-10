package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;

import com.readyidu.util.DesUtil;
import com.readyidu.util.HttpUtil;
import sun.misc.BASE64Decoder;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/8/15.
 */
public class MiguStvSource extends Source {
    public MiguStvSource(String sourceId) {
        super(sourceId);
    }

    public static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static DecimalFormat df = new DecimalFormat("######0");

    @Override
    protected String source() {
        String url = null;
        url=getURl();
        url = url.replaceAll("[\u0001-\u0009]", "");
        return url;
//        desStr = clearFun(','+desStr+',');
//        desStr = desStr.substring(1,desStr.length()-2);
//        desStr.split(",");
//        String c = (String) DyMethodUtil.invokeMethod(desStr, null);
    }

    public String getURl() {
        Map<String, String> hasMap = getKeyAndValue();
        String desValue = hasMap.get("desValue");
        String desKey = hasMap.get("desKey");
        String url = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytea = DesUtil.DES_ECB_Decrypt(decoder.decodeBuffer(desValue), desKey.getBytes("UTF-8"));
            url = new String(bytea, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!url.contains("\ufffd")) {
            return url;
        }
        else
        {
            return getURl();
        }
    }

    public Map<String, String> getKeyAndValue() {
        Map<String, String> hasMap = new HashMap<>();
        String carouselSource = null;
        switch (sourceId){
            case SourceConstants.SOURCE_MIGU_STV_BJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154074");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JSWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623899368");
                break;
            case SourceConstants.SOURCE_MIGU_STV_DFWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619811679");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SDWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619618278");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SSWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624303319");
                break;
            case SourceConstants.SOURCE_MIGU_STV_AHWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878947");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HLJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624303427");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HBWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878953");
                break;
            case SourceConstants.SOURCE_MIGU_STV_LNWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878951");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GDWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608831231");
                break;
            case SourceConstants.SOURCE_MIGU_STV_TJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=627065430");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JSWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623899540");
                break;
            case SourceConstants.SOURCE_MIGU_STV_DFWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608790604");
                break;
            case SourceConstants.SOURCE_MIGU_STV_BJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=615912578");
                break;
            case SourceConstants.SOURCE_MIGU_STV_AHWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608780629");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HNWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609153594");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HUNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609153595");
                break;
            case SourceConstants.SOURCE_MIGU_STV_ZJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623539769");
                break;
            case SourceConstants.SOURCE_MIGU_STV_ZJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=622992650");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GDWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608831538");
                break;
            case SourceConstants.SOURCE_MIGU_STV_NFWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608917627");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SSWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624303317");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SDJY:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154353");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SDWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619618199");
                break;
            case SourceConstants.SOURCE_MIGU_STV_LNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623583504");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SCWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608880878");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779358");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HENWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779360");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GZWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779450");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HLJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779861");
                break;
            case SourceConstants.SOURCE_MIGU_STV_DNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609153805");
                break;
            case SourceConstants.SOURCE_MIGU_STV_TJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=627065515");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GSWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608907550");
                break;
            case SourceConstants.SOURCE_MIGU_STV_XZWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608907682");
                break;
            case SourceConstants.SOURCE_MIGU_STV_BTWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608914624");
                break;
            case SourceConstants.SOURCE_MIGU_STV_CQWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609024130");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608924994");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HEBWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609026126");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JLWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609020981");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SHANXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609022770");
                break;
            case SourceConstants.SOURCE_MIGU_STV_XMWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608935834");
                break;
            case SourceConstants.SOURCE_MIGU_STV_YNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154293");
                break;
            case SourceConstants.SOURCE_MIGU_STV_NMGWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608914971");
                break;
            case SourceConstants.SOURCE_MIGU_STV_NXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608914867");
                break;
            case SourceConstants.SOURCE_MIGU_STV_XJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779373");
                break;
            case SourceConstants.SOURCE_MIGU_STV_QHWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608915204");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154295");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HUBWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=615945699");
                break;
        }
        Pattern pattern = Pattern.compile("\"src\":_mv_addr\\('.+'\\)");
        Matcher mather = pattern.matcher(carouselSource);
        String desValue = null;

        if (mather.find()) {
            desValue = mather.group();
            desValue = desValue.trim().replace("\n", "");
        }
        desValue = desValue.substring(0, desValue.length() - 2).replace("\"src\":_mv_addr('", "");
        //var[A-Za-z0-9/*_=\\, \[\]$(){};/]*
        String desStr = null;
        pattern = Pattern.compile("var/\\\\*[A-Za-z0-9/*_=\\\\, \\[\\]$(){};/\\r\\n.^+~>&|-]*");
        mather = pattern.matcher(carouselSource);
//        System.out.println(mather.groupCount());
        if (mather.find()) {
            desStr = mather.group();
        }
        desStr = decodeUnicode(desStr);
        pattern = Pattern.compile("/\\*.*?\\*/");
        mather = pattern.matcher(desStr);
        while (mather.find()) {
            desStr = desStr.replace(mather.group(), "");
        }
        pattern = Pattern.compile("__[A-Za-z0-9]*\\([A-Za-z0-9.()&,/~^>_$|\\-\\r\\n]*");
        mather = pattern.matcher(desStr);
        String deStr = null;
        mather.find();
        if (mather.find()) {
            deStr = mather.group();
            desStr = mather.group();
            desStr = desStr.substring(0, desStr.length() - 2);
            desStr = desStr.substring(desStr.indexOf("(") + 1);
        }
        String[] strList = desStr.split(",");
        List<String> listUni = new ArrayList<>();
        for (String str : strList) {
            if (!str.contains("$")) {
                String cha = null;
                try {
                    cha = df.format(jse.eval(str));
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                if (cha != null) {
                    listUni.add(cha);
                }
            }
        }
        desStr = unicode2String(listUni);
        pattern = Pattern.compile("'[a-zA-z0-9]{10}'");
        mather = pattern.matcher(desStr);
        String desKey = null;
        if (mather.find()) {
            desKey = mather.group();
            desKey = desKey.substring(1, desKey.length() - 2);
            hasMap.put("desValue", desValue);
            hasMap.put("desKey", desKey);
            return hasMap;

        } else {
            return getKeyAndValue();
        }
    }

    public static String unicode2String(List<String> unicode) {

        StringBuffer string = new StringBuffer();


        for (int i = 1; i < unicode.size(); i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(unicode.get(i));

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }

    private static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
