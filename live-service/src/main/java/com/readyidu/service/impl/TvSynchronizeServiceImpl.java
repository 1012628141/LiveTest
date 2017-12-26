package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.mapper.PhoneServiceMapper;
import com.readyidu.mapper.TvDeviceMapper;
import com.readyidu.model.PhoneDevice;
import com.readyidu.model.PhoneService;
import com.readyidu.model.TvDevice;
import com.readyidu.service.CacheService;
import com.readyidu.service.TvSynchronizeService;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import com.readyidu.util.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import java.util.*;


@Service(value = "tvSynchronizeService")
public class TvSynchronizeServiceImpl implements TvSynchronizeService{
    @Autowired
    private TvDeviceMapper tvDeviceMapper;

    @Autowired
    private PhoneDeviceMapper phoneDeviceMapper;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private  PhoneServiceMapper phoneServiceMapper;

    /*app端扫描后该访问的地址*/
    private static final String QRDecodeUrl = "app/bundling";

    private static final String BindlingDevice="BindlingDevice";


    /*获取绑定的设备列表*/
    @Override
    public String getDevices(String deviceId) {
        /*如果传参为空 返回请求成功代码 空数据*/
        if (NullUtil.isNullObject(deviceId)){
            return JsonResult.toString(NetworkCode.CODE_SUCCESS_NULL, "");
        }
        /*查询缓存服务器  如果有 直接返回 如果没有查询数据库*/
        String bindlingJson = cacheService.get(BindlingDevice + deviceId);
        if (!NullUtil.isNullObject(bindlingJson)){
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, JSON.parseArray(bindlingJson,PhoneDevice.class));
        }
        List<PhoneDevice> phoneDevices = phoneDeviceMapper.listByDeviceId(deviceId);
        /*存入缓存数据库*/
        System.out.println(phoneDevices);
        if (phoneDevices.size()==0){
           return JsonResult.toString(NetworkCode.CODE_SUCCESS_NULL, "");
        }
        cacheService.set(BindlingDevice+deviceId,JSON.toJSONString(phoneDevices),cacheService.CACHE_TIMEOUT30);
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,phoneDevices);
    }

    /*获得自定义源*/
    @Override
    public List<PhoneService> getCostomizeSourceList(String deviceId) {
        return phoneServiceMapper.getConfUrlAndUserIdByDeviceId(deviceId);
    }


    /*获取二维码*/
    @Override
    public void getQRCode(String tvDeviceId,String tvAlias,ServletOutputStream outputStream) {
       /*1.业务要求：判断数据库是否存在该机顶盒数据  如果没有新增*/
        TvDevice tvDevice=tvDeviceMapper.getByDeviceId(tvDeviceId);

        if (NullUtil.isNullObject(tvDevice)){
          /*2.如果为空调用 其他接口方法生成新的设备数据*/
            int i = addTvDevice(tvDeviceId,tvAlias);
        }
        /*判断获取设备的别名是否与传递的一致，一致才继续执行*/
        if (tvAlias.equals(tvDevice.getTvAlias())) {
        /*3.标识唯一性，生成令牌*/
            String token = UUID.randomUUID().toString();
            Map<String, String> map = new HashMap<>();
            map.put("QRDecodeUrl", QRDecodeUrl);
            map.put("token", token);
            map.put("tvDeviceId", tvDeviceId);
            map.put("tvAlias", tvAlias);
            String tvDeviceContent = JSON.toJSONString(map);
        /*4.redis 作为定时器  设置为30 分钟 客户端扫描二维码后 获取令牌 后台验证如果存在此令牌则验证通过*/
            cacheService.set(token + tvDeviceId, "1", CacheService.CACHE_TIMEOUT30);
            try {
                QRCodeUtil.encode(tvDeviceContent, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Transactional
    @Override
    public int addTvDevice(String tvDeviceId,String tvAlias) {
        if (NullUtil.isNullObject(tvDeviceId)){
            return 0;
        }
        TvDevice tvDevice=new TvDevice();
        tvDevice.setTvAlias(tvAlias);
        tvDevice.setDeviceId(tvDeviceId);
        tvDevice.setCreareTime(new Date());
        tvDevice.setIsDelete(0);
        return tvDeviceMapper.insertTvDevice(tvDevice);
    }
}
