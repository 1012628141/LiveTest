package com.readyidu.controller;

import com.alibaba.fastjson.JSONArray;
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
    @RequestMapping("/callBackUpdate")
    public String callBackUpdate(HttpServletRequest request){
        //回调地址
        Auth auth = Auth.create(QiNiuUploadTool.accessKey, QiNiuUploadTool.secretKey);
        String callbackUrl = "http://218.75.36.107:11116/app/callBackUpdate";
        //定义回调内容的组织格式，与上传策略中的callbackBodyType要保持一致
        //String callbackBodyType = "application/x-www-form-urlencoded"; //回调鉴权的签名包括请求内容callbackBody
        String callbackBodyType = "application/x-www-form-urlencoded";//回调鉴权的签名不包括请求内容
        /**
         * 这两个参数根据实际所使用的HTTP框架进行获取
         */
        //通过获取请求的HTTP头部Authorization字段获得
        String callbackAuthHeader = request.getHeader("Authorization");
        System.out.println(request);
        //通过读取回调POST请求体获得，不要设置为null
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte[] callbackBody  = new byte[contentLength];
        try {
            for (int i = 0; i < contentLength;) {

                int readlen = request.getInputStream().read(callbackBody, i,
                        contentLength - i);
                if (readlen == -1) {
                    break;
                }
                i += readlen;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(callbackBody));
        boolean validCallback = auth.isValidCallback(callbackAuthHeader, callbackUrl, callbackBody, callbackBodyType);
        if(validCallback){
            JSONArray jsonArray = JSONArray.parseArray(new String(callbackBody));
            int acount = jsonArray.getInteger(3);
            String hash = jsonArray.getString(1);
            String bucket = jsonArray.getString(2);
            String confUrl = bucket + hash ;
            ConfInfo confInfo = new ConfInfo();
            confInfo.setHash(hash);
            confInfo.setVersion("131");
            confInfo.setConfUrl(confUrl);
            if(NullUtil.isNullObject(appChannelService.selectByAcount(acount))){
                appChannelService.insertConf(confInfo);
            }else {
                appChannelService.updateConfinfo(confInfo);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
        }else {
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
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
