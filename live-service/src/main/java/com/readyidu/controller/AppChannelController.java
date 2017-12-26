package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Auth;
import com.readyidu.constants.NetworkCode;
import com.readyidu.filter.HeaderFilter;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.CacheService;
import com.readyidu.tools.QiNiuUploadTool;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
    @ResponseBody
    @RequestMapping("/callBackUpdate")
    public String callBackUpdate(HttpServletRequest request){
        JSONObject callBackObj = null;
        try {
            callBackObj = QiNiuUploadTool.parseCallBack(request);
            if(!NullUtil.isNullObject(callBackObj)){
                int acount = callBackObj.getInteger("acount");
                String hash = callBackObj.getString("hash");
                String confUrl = QiNiuUploadTool.CHAINURL + hash ;
                ConfInfo confInfo = new ConfInfo(acount,hash,confUrl);
                if(NullUtil.isNullObject(appChannelService.selectByAcount(acount))){
                    appChannelService.insertConf(confInfo);
                }else {
                    appChannelService.updateConfinfo(confInfo);
                }
                return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
            }else {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400,"");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
    @ResponseBody
    @RequestMapping("/updatetest")
    public String updatetest(){
        String result = QiNiuUploadTool.upLoadWithCallBack("/Users/Documents/movie.py");
        return result;
    }

    /**
     * app端手机绑定
     * @return
     */
    @ResponseBody
    @RequestMapping("/bundling")
    public String bundling(String token,String appAlias,String tvAlias){
        try {
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
        } catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

    /**
     * app端获取自定义频道列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCustomizedList")
    public String getCustomizedList(String url){
        try {
            List<String> customizedList = appChannelService.getSourceList(url);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,customizedList);
        } catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }


    private int getAccessTimes(String remoteHost,String interFaceName){
        String cacheKey = remoteHost + interFaceName + "countNum";
        String accessTimes = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(accessTimes)&&!accessTimes.equals("null"))
            return Integer.valueOf(accessTimes) + 1;
        return 0;
    }
}
