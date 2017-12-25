package com.readyidu.controller;


import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.storage.UploadManager;
import com.readyidu.constants.NetworkCode;
import com.readyidu.filter.HeaderFilter;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.CacheService;
import com.readyidu.service.impl.AppChannelServiceImpl;
import com.readyidu.tools.QiNiuUploadTool;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * App端数据绑定接口
 * Created by 123 on 2017/12/25.
 */
@Controller
@RequestMapping("/app")
public class AppChannelController {

    @Autowired
    private CacheService cacheService;

    private AppChannelService appChannelService = new AppChannelServiceImpl();

    @RequestMapping("/getQiniuToken")
    public String getQiNiuToken(){
        RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
        if (getAccessTimes(requestParamModel.getRemoteHost(),"getQiniuToken")<=3)
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, QiNiuUploadTool.getToken());
        return JsonResult.toString(NetworkCode.CODE_FAIL,"");
    }

    /**
     * 同步文件上传回调接口
     * @return
     */
    @RequestMapping("/callBackUpdate")
    public String callBackUpdate(final RequestParamModel requestParamModel){
        new UpCompletionHandler(){
            @Override
            public void complete(String s, ResponseInfo info, org.json.JSONObject res) {
                if (info.isOK()){
                    String version = String.valueOf(requestParamModel.getVersion());
                    int acount = requestParamModel.getAccount();
                    String hash = res.getString("hash");
                    String confUrl = res.getString("callbackUrl") + hash ;
                    ConfInfo confInfo = new ConfInfo();
                    confInfo.setAcount(acount);
                    confInfo.setConfUrl(confUrl);
                    confInfo.setHash(hash);
                    confInfo.setVersion(version);
                    if (NullUtil.isNullObject(appChannelService.selectByAcount(acount))){
                        appChannelService.insertConf(confInfo);
                    }else {
                        appChannelService.updateConfinfo(confInfo);
                    }
                }
            }
        };

        return null;
    }

    /**
     * app端手机绑定
     * @return
     */
    @RequestMapping("/bundling")
    public String bundling(String token){
        RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
        int account = requestParamModel.getAccount();
        String deviceId = requestParamModel.getDeviceId();
        if(!NullUtil.isNullObject(cacheService.get(token+deviceId))){

        }
        return null;
    }

    /**
     * app端获取自定义频道列表
     * @return
     */
    @RequestMapping("/getCustomizedList")
    public String getCustomizedList(){
        return null;
    }

    private int getAccessTimes(String remoteHost,String interFaceName){
        String cacheKey = remoteHost + interFaceName + "countNum";
        String accessTimes = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(accessTimes)&&!accessTimes.equals("null"))
            return Integer.valueOf(accessTimes) + 1;
        return 0;
    }
}
