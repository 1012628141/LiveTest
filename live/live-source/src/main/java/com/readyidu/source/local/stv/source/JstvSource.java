package com.readyidu.source.local.stv.source;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/7/3.
 */
public class JstvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public JstvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    private String channelURL = "http://ws.live.jstv.com/play";
    private static String hexStr = "0123456789abcdef";

    public String getMd5(int timeStamp) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return BinaryToHexString(md5.digest(("!@#jsTvL1ve" + channelURL + "/62" + timeStamp).getBytes()));
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

    public String getUrl() {
        String URL = channelURL + "/62";
        int timeStamp = (int) (new Date().getTime() / 1000);
        String hash = null;
        int key = 0;
        try {
            hash = getMd5(timeStamp);
            key = transformInt(timeStamp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return URL + "?val=" + hash + "&tt=" + key + "&rand=" + Math.random();
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
        switch (sourceId) {
            case SourceConstants.SOURCE_JS_STV:
                result = getUrl();
                String jsonReturn = HttpUtil.httpGet(result);
                Pattern pattern = Pattern.compile("rtmp://[a-zA-z0-9./?=&~%-]*");
                Matcher matcher = pattern.matcher(jsonReturn);
                List<String> urlList = new ArrayList();
                while (matcher.find()) {
                    urlList.add(matcher.group());
                }
                return urlList.get(index - 1);
        }
        return null;
    }
}
