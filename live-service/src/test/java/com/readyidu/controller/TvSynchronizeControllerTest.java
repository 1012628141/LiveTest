package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.model.PhoneDevice;
import com.readyidu.service.TvSynchronizeService;
import com.readyidu.tools.JPushTool;
import com.readyidu.tools.TestBaseConfig;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static junit.framework.TestCase.assertTrue;

public class TvSynchronizeControllerTest extends TestBaseConfig {
    private static final String MASTER_SECRET = "ef9f38dadd725270fea9e65b";
    private static final String APP_KEY = "6d798d4905318ea41b80f3e3";

    private static final String MESSAGE = "绑定成功";
    private static final String FAIL = "绑定失败";
    @Autowired
    private TvSynchronizeController tvSynchronizeController;

    @Autowired
    private TvSynchronizeService tvSynchronizeService;

    @Test
    public void getDevicesTest(){
        String devices = tvSynchronizeController.getDevices("1012628141");
        System.out.println(devices);
    }

    /*后台直接返回流给前台，需要的参数我拿不到  单元测试鄙人技术短浅，不会写 此注释警示*/
   /* @Test
    public void getQRCodeTest(){
        OutputStream outputStream=null;
        try {
           outputStream=new FileOutputStream("D:/111.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tvSynchronizeService.getQRCode("1012628141", (ServletOutputStream) outputStream);
    }*/
   @Test
   public void testbindingReq(){
       int acount = 123456;
       String deviceId = "abc";
       String phoneAlias = "1234";
       PhoneDevice phoneDevice = new PhoneDevice();
       phoneDevice.setDeviceId(deviceId);
       phoneDevice.setUserId(acount);
       phoneDevice.setPhoneAlias(phoneAlias);
       int num = 0 ;
       try {
           num = tvSynchronizeService.insertPhoneDevice(phoneDevice);
       }catch (Exception e){
           e.printStackTrace();
       }

       System.out.println(num);
       assertTrue(num>0);
       if (num > 0){
           JPushTool.sendPush(MASTER_SECRET, APP_KEY, MESSAGE, NetworkCode.TYPE_CHANGE);
       }else{
           JPushTool.sendPush(MASTER_SECRET, APP_KEY, FAIL, NetworkCode.TYPE_CHANGE);
       }
   }

}
