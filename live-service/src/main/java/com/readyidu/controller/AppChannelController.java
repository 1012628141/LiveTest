package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Auth;
import com.readyidu.constants.NetworkCode;
import com.readyidu.filter.HeaderFilter;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.pojo.BbsChannel;
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


    @ResponseBody
    @RequestMapping("/getQiniuToken")
    public String getQiNiuToken(){
        RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
        if (getAccessTimes(requestParamModel.getRemoteHost(),"getQiniuToken")<=3)
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, QiNiuUploadTool.getToken());
        return JsonResult.toString(NetworkCode.CODE_FAIL,"");
    }

    /**
     * 同步文件上传回调接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/callBackUpdate", produces = "application/json; charset=utf-8")
    public String callBackUpdate(int account, String key, String token) {
        String hasToken = cacheService.get(token);
        if (NullUtil.isNullObject(hasToken))
            return JsonResult.toString(NetworkCode.CODE_NOTOKEN, "");
        String confUrl = QiNiuUploadTool.CHAINURL + key;
        ConfInfo confInfo = new ConfInfo(account, key, confUrl);
        if (NullUtil.isNullObject(appChannelService.selectByAcount(account))) {
            appChannelService.insertConf(confInfo);
        } else {
            appChannelService.updateConfinfo(confInfo);
        }
        return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
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
    public String bundling(String token,String tvDeviceId){
        try {
            RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
            int account = requestParamModel.getAccount();
            if(!appChannelService.checkUserId(account)){
                return JsonResult.toString(NetworkCode.ACCOUNT_NOT_EXIST,"");
            }
            String cache = cacheService.get(token+tvDeviceId);
            if(!NullUtil.isNullObject(cache)){
                int code = appChannelService.checkBinding(account,tvDeviceId);
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
            List<BbsChannel> customizedList = appChannelService.getSourceList(url);
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

    @ResponseBody
    @RequestMapping("/checkByUserId")
    public String checkByUserId() {
        try {
            RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
            int account = requestParamModel.getAccount();
            return appChannelService.checkByUserId(account);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
    @RequestMapping("/updateDefinedName")
    public String updateDefinedName(String definedName){
        try {
            RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
            int account = requestParamModel.getAccount();
            appChannelService.updateDefinedName(account,definedName);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
}
