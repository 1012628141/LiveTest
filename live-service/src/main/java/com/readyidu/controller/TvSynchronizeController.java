package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.filter.HeaderFilter;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.constants.NetworkCode;
import com.readyidu.model.PhoneDevice;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.model.PhoneService;
import com.readyidu.service.TvSourceService;
import com.readyidu.service.TvSynchronizeService;
import com.readyidu.service.impl.TvSynchronizeServiceImpl;
import com.readyidu.tools.JPushTool;
import com.readyidu.util.JsonResult;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 123 on 2017/12/25.
 */
@Controller

public class TvSynchronizeController {

    private static final String MASTER_SECRET = "58a7d407914ec1e6d21f9ee2";
    private static final String APP_KEY = "392671d7ee2901353acdc13e";

    private static final String MESSAGE = "绑定成功";
    private static final String FAIL = "绑定失败";
    @Autowired
    private TvSynchronizeService tvSynchronizeService;



    /**
     * 获取二维码
     * @param deviceId 机顶盒识别id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getQRCode")
    public String getQRCode(String deviceId, String tvAlias, HttpServletRequest request){
        if (!NullUtil.isNullObject(deviceId)&&!NullUtil.isNullObject(tvAlias)){
            String contextPath = request.getSession().getServletContext().getRealPath("/");
            return tvSynchronizeService.getQRCode(deviceId,tvAlias,contextPath);

        }
        return JsonResult.toString(NetworkCode.CODE_FAIL,"");
    }

    /**
     * 获取绑定设备列表
     * @return 绑定的设备的信息
     * @param  deviceId 设备Id
     */
    @ResponseBody
    @RequestMapping(value="/getDevices" )
    public String getDevices(String deviceId){
        return tvSynchronizeService.getDevices(deviceId);
    }

    /**
     * 获取绑定设备自定义源列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/DevicesChannels",method= RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String DevicesChannels(HttpServletRequest request){
        try{
            String deviceId = request.getParameter("deviceId");
            List<PhoneService> phoneServiceList = tvSynchronizeService.getCostomizeSourceList(deviceId);
            if(!phoneServiceList.isEmpty()){
                return JsonResult.toString(NetworkCode.CODE_SUCCESS,phoneServiceList);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS_NULL,"");
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

    /**
     * tv端绑定确认接口-
     * @return
     */
    @RequestMapping("/bindingReq")
    public String bindingReq(String phoneAlias,Integer userId){
        try{
            RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
            String deviceId = requestParamModel.getDeviceId();
            PhoneDevice phoneDevice = new PhoneDevice();
            phoneDevice.setDeviceId(deviceId);
            phoneDevice.setUserId(userId);
            phoneDevice.setPhoneAlias(phoneAlias);
            int num = tvSynchronizeService.insertPhoneDevice(phoneDevice);
            if (num > 0){
                JPushTool.sendPush(MASTER_SECRET, APP_KEY, MESSAGE, NetworkCode.BUNDLING_SUCCESS);
                return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
            }else{
                JPushTool.sendPush(MASTER_SECRET, APP_KEY, FAIL, NetworkCode.BUNDLING_FAIL);
                return JsonResult.toString(NetworkCode.CODE_FAIL,"");
            }
        }catch (Exception e){
            JPushTool.sendPush(MASTER_SECRET, APP_KEY, FAIL, NetworkCode.BUNDLING_FAIL);
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

    /**
     * tv端解除绑定确认接口
     * @return String 状态码
     */
    @ResponseBody
    @RequestMapping("/unBind")
     public String unBind(String userId){
        return  tvSynchronizeService.removePhoneByDeviceId(userId);
     }
}
