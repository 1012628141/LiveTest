package com.readyidu.controller;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.constants.NetworkCode;
import com.readyidu.filter.HeaderFilter;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.CacheService;
import com.readyidu.tools.QiNiuUploadTool;
import com.readyidu.tools.WebHttpTool;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * App端数据绑定接口
 * Created by 123 on 2017/12/25.
 */
@Controller
@RequestMapping("/app")
public class AppChannelController {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private AppChannelService appChannelService;

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
    public String callBackUpdate(){
        return null;
    }

    /**
     * app端手机绑定
     * @return
     */
    @RequestMapping("/bundling")
    public String bundling(String token,String appAlias,String tvAlias){
        RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
        int account = requestParamModel.getAccount();
        if(!appChannelService.checkUserId(account)){
            return JsonResult.toString(NetworkCode.ACCOUNT_NOT_EXIST,"");
        }
        String deviceId = requestParamModel.getDeviceId();
        String cache = cacheService.get(token+deviceId);
        if(!NullUtil.isNullObject(cache)){
            int code = appChannelService.checkBinding(account,deviceId,tvAlias,appAlias);
            return JsonResult.toString(code,"");
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL,"");
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
