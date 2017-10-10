package com.readyidu.source.local.shandong.shandong.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/27.
 */
public class SdtvSource extends Source {

    private static final String CACHE_NAME = "source_";
    private static final int CHACHE_TIMEOUT = 1800;

    public SdtvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String cacheSource = null;
        switch (sourceId) {
            case SourceConstants.SOURCE_SDTV_SD1:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=57&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD2:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=69&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD3:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=73&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD4:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=61&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD5:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=71&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD6:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=65&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD7:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=63&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD8:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=75&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD9:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=77&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            case SourceConstants.SOURCE_SDTV_SD10:
                cacheSource = HttpUtil.httpGet("http://mbp.allook.cn/ajax/MbpRequest.do?cls=CustomerVisit_add02&prevLoad=0&definition=sd&visitValue=67&os_type=ios&product=1&customerId=-1&version=ios-v4.2&virtualId=1e97998113663c4b63b8108f5e4d12546d86&viewLength=0&terminal=1&visitType=liveVideo&channel=AppStore");
                break;
            default:
                break;
        }
        Pattern pattern = Pattern.compile("http://zb.allook.cn:80/live.*.m3u8[a-zA-Z0-9./?]*");
        Matcher matcher = pattern.matcher(cacheSource);
        if (matcher.find()) {
            cacheSource = matcher.group(0);
            return cacheSource;
        } else {
            return null;
        }
    }

//    public String getC(int c,int a){
//        while (c>=a){
//            c=c/a;
//        }
//        c=c%a;
//        String result;
//        if(c>35){
//           char c1 = toString().charAt(c+29);
//            result = String.valueOf(c1);
//        } else {
//            result = String.valueOf(Long.toString(c,36));
//        }
//        return result;
//    }
}