package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.DesUtil;
import com.readyidu.util.HttpUtil;
import sun.misc.BASE64Decoder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BNDYH on 2017/8/16.
 */
public class CarouselSource extends Source {
    public CarouselSource(String sourceId) {
        super(sourceId);
    }

    public static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static DecimalFormat df = new DecimalFormat("######0");

    @Override
    protected String source() {
        String url = null;
        url = getURl();
        url = url.replaceAll("[\u0001-\u0009]", "");
        return url;
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
        } else {
            return getURl();
        }
    }

    public Map<String, String> getKeyAndValue() {
        Map<String, String> hasMap = new HashMap<>();
        String carouselSource = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_MIGU_CAROUSEL_SJJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=629068516");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DQRJBUT:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625155140");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_SDMZJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625498431");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JLJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625643517");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_HZSBQ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625520490");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_RYJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625827063");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DMFFL:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625525181");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_TLBBJ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625703337");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_PAXC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=627033503");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LTZPJ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625514969");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JYPD:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625774640");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LMBQT:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625521420");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_KTB:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625574493");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_SDJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625681367");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_ZJSN:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=617432318");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_ZJYS:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626157526");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JKZG:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626168301");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JDFYT:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626157538");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_KATVB:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623338112");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_TSYZPJ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625966779");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DKZXC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626157575");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LSSZPJ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625759619");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_MGFYT:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619495952");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_MGYSHD:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=617432495");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LDJ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625681368");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_XAJH:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625759558");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DFDYHD:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623674834");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LIVESHOWHD:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=617432328");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JPGCJ:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625574378");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_HSHBJP:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624999147");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_NDJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625774631");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_XXGJC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625526423");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_ZYXC:
                carouselSource = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=621640581");
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
