package com.readyidu.controller;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.readyidu.model.ConfInfo;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.impl.AppChannelServiceImpl;
import com.readyidu.tools.QiNiuUploadTool;
import com.readyidu.tools.TestBaseConfig;
import com.readyidu.util.NullUtil;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * ChannelController Tester.
 *
 * @author ypf
 * @version 1.0
 */
public class AppChannelControllerTest extends TestBaseConfig {


    AppChannelService appChannelService =  new AppChannelServiceImpl();
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: callBackUpdate(HttpServletRequest request, HttpServletResponse response)
     */
//    @Test
//    public void testCallBackUpdate() throws Exception {
//            UpCompletionHandler upCompletionHandler = new UpCompletionHandler() {
//            RequestParamModel requestParamModel = new RequestParamModel("218.75.36.107:18911","113",null,"10000","123",null,null,null,100014,null);
//            @Override
//            public void complete(String s, ResponseInfo responseInfo, JSONObject jsonObject) {
//                if (responseInfo.isOK()){
//                    System.out.println("*************************************************************");
//                    String version = String.valueOf(requestParamModel.getVersion());
//                    assertTrue(!NullUtil.isNullObject(version));
//                    System.out.println(version);
//                    int acount = requestParamModel.getAccount();
//                    assertTrue(!NullUtil.isNullObject(acount));
//                    System.out.println(acount);
//                    String hash = jsonObject.getString("hash");
//                    assertTrue(!NullUtil.isNullObject(hash));
//                    System.out.println(hash);
//                    String confUrl = jsonObject.getString("callbackUrl") + hash ;
//                    assertTrue(!NullUtil.isNullObject(confUrl));
//                    System.out.println(confUrl);
//                    System.out.println("*************************************************************");
//                    ConfInfo confInfo = new ConfInfo();
//                    confInfo.setAcount(acount);
//                    confInfo.setConfUrl(confUrl);
//                    confInfo.setHash(hash);
//                    confInfo.setVersion(version);
//                    if (NullUtil.isNullObject(appChannelService.selectByAcount(acount))){
//                        appChannelService.insertConf(confInfo);
//                    }else {
//                        appChannelService.updateConfinfo(confInfo);
//                    }
//                }else {
//                    System.out.println("上传失败");
//                }
//            }
//        };
//       QiNiuUploadTool.upLoad("/Users/zhoujianyu/20E44898430ABB10E4783DECDB8778AA.gif",upCompletionHandler);


//    }
}
