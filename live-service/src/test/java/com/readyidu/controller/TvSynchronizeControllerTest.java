package com.readyidu.controller;

import com.readyidu.service.TvSynchronizeService;
import com.readyidu.tools.TestBaseConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TvSynchronizeControllerTest extends TestBaseConfig {
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

}
