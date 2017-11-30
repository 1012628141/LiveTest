package com.readyidu.source.local.jiangsu.jiangsu.source;

import com.readyidu.service.CacheService;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/7/3.
 */
public class JstvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public JstvSource(String sourceId) {
        super(sourceId);
    }

    private static String hexStr = "0123456789abcdef";

    public String getMd5(int timeStamp, String url) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return BinaryToHexString(md5.digest(("!@#jsTvL1ve" + url + timeStamp).getBytes()));
    }

    private int transformInt(int param1) throws IOException {
        ByteArrayOutputStream boutput = new ByteArrayOutputStream();
        DataOutputStream doutput = new DataOutputStream(boutput);
        doutput.writeInt(param1);
        byte[] _loc2_ = boutput.toByteArray();
        byte[] _loc3_ = new byte[4];
        int _loc4_ = 0;
        while (_loc4_ < 4) {
            _loc3_[4 - _loc4_ - 1] = (byte) ((_loc2_[_loc4_] & 240 ^ 240 | (_loc2_[_loc4_] & 15) + 1 & 15));
            _loc4_++;
        }
        ByteBuffer _loc5_ = ByteBuffer.wrap(_loc3_);
        return _loc5_.getInt();
    }

    public String getUrl(String url) {
        int timeStamp = (int) (new Date().getTime() / 1000);
        String hash = null;
        int key = 0;
        try {
            hash = getMd5(timeStamp, url);
            key = transformInt(timeStamp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url + "?val=" + hash + "&tt=" + key + "&rand=" + Math.random();
    }


    public static String BinaryToHexString(byte[] bytes) {

        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
            hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
            result += hex + "";
        }
        return result;
    }

    @Override
    protected String source() {
        String result = null;
        String content = null ;
        switch (sourceId) {
            case SourceConstants.SOURCE_JSTV_JS1:
//                result = getUrl("http://ws.live.jstv.com/play/5");
//                break;
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=626064714");
                break;
            case SourceConstants.SOURCE_JSTV_JS2:
//                result = getUrl("http://ws.live.jstv.com/play/2");
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=626064693");
                break;
            case SourceConstants.SOURCE_JSTV_JS3:
//                result = getUrl("http://ws.live.jstv.com/play/9");
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=626065193");
                break;
            case SourceConstants.SOURCE_JSTV_JS4:
//                result = getUrl("http://ws.live.jstv.com/play/8");
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=626064697");
                break;
            case SourceConstants.SOURCE_JSTV_JS5:
//                result = getUrl("http://ws.live.jstv.com/play/7");
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=626064707 ");
                break;
            case SourceConstants.SOURCE_JSTV_JS6:
                result = getUrl("http://ws.live.jstv.com/play/29");
                break;
            case SourceConstants.SOURCE_JSTV_JS7:
                result = getUrl("http://ws.live.jstv.com/play/91");
                break;
            case SourceConstants.SOURCE_JSTV_JS8:
                content = HttpUtil.httpGet("http://live.api.hunantv.com/pc/getById?liveType=2&liveId=http://live.api.hunantv.com/pc/getById?liveType=2&liveId=339");
                break;
            case SourceConstants.SOURCE_JSTV_JS9:
//                result = getUrl("http://ws.live.jstv.com/play/28");
                content = HttpUtil.httpGet("http://m.cmvideo.cn/wap/resource/mh/share/migushare.jsp?cid=626064674");
                break;
            case SourceConstants.SOURCE_JSTV_JS10:
                result = getUrl("http://ws.live.jstv.com/play/27");
                break;
            case SourceConstants.SOURCE_JSTV_JS11:
                result = getUrl("http://ws.live.jstv.com/play/10");
                break;
            default:
                break;
        }
//        String jsonReturn = HttpUtil.httpGet(result);
//        Pattern pattern = Pattern.compile("rtmp://[a-zA-Z0-9./?=&~%-]*");
//        Matcher matcher = pattern.matcher(jsonReturn);
//        if (matcher.find()) {
//            result = matcher.group();
//        String content = HttpUtil.httpGet(result);
        Pattern pattern = Pattern.compile("src=\"http://[\\s\\S]*?.m3u8?[\\s\\S]*?\"");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            result = matcher.group().replace("src=\"","").replace("\"","");
        }else{
            pattern = Pattern.compile("http:[\\s\\S]*.m3u8[?]*[\\s\\S]*?\"");
            matcher = pattern.matcher(content);
            if (matcher.find()){
                result = matcher.group().replace("\\","").replace("\"","");
            }
        }
        return result;
    }
}
