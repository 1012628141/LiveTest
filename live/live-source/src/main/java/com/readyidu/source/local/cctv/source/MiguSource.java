package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;

import com.readyidu.util.DesUtil;
import com.readyidu.util.HttpUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.krb5.internal.crypto.Des;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/8/15.
 */
public class MiguSource extends Source {
    public MiguSource(String sourceId) {
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
        String miguStv = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_MIGU_CCTV_1:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807427");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_1:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807420");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_2:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807428");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_3:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017193");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_3:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878271");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_4:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807424");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_5:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608788132");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_5:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608788135");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_6:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608919883");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_6:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878396");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_7:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609018153");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_8:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154254");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_8:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878356");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_9:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608920109");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_9:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006487");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_10:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608880731");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_10:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878405");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_11:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017121");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_12:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017191");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_13:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807423");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_13:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017205");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_14:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017204");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_14:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878440");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_15:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807408");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_ALB:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154345");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_FY:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006476");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_XBY:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006450");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_EY:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006446");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_XKDM:
                miguStv = HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154346");
                break;
        }

        Pattern pattern = Pattern.compile("\"src\":_mv_addr\\('.+'\\)");
        Matcher mather = pattern.matcher(miguStv);
        String desValue = null;

        if (mather.find()) {
            desValue = mather.group();
            desValue = desValue.trim().replace("\n", "");
        }
        desValue = desValue.substring(0, desValue.length() - 2).replace("\"src\":_mv_addr('", "");
        //var[A-Za-z0-9/*_=\\, \[\]$(){};/]*
        String desStr = null;
        pattern = Pattern.compile("var/\\\\*[A-Za-z0-9/*_=\\\\, \\[\\]$(){};/\\r\\n.^+~>&|-]*");
        mather = pattern.matcher(miguStv);
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
