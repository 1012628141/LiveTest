package com.readyidu.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.mapper.PhoneServiceMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.model.PhoneDevice;
import com.readyidu.model.PhoneService;
import com.readyidu.pojo.BbsChannel;
import com.readyidu.service.AppChannelService;
import com.readyidu.service.BaseService;
import com.readyidu.tools.QiNiuUploadTool;
import com.readyidu.tools.WebHttpTool;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service(value = "appChannelService")
public class AppChannelServiceImpl extends BaseService implements AppChannelService{

    @Autowired
    private PhoneDeviceMapper phoneDeviceMapper;

    @Autowired
    private PhoneServiceMapper phoneServiceMapper;

    @Autowired
    private ConfInfoMapper confInfoMapper;

    private static final String HTTP_POST_URL = "http://192.168.4.103:8815/user/queryUserByusid.do";

    @Transactional
    @Override
    public int checkBinding(int account, String TvDeviceId) {
        int code;
        try {
            //判断该机顶盒是否超过3个
            if(phoneDeviceMapper.getCountByDeviceId(TvDeviceId)<3){
                String deviceId_old = phoneDeviceMapper.selectDeviceIdByUserId(account);
                if (deviceId_old == TvDeviceId){
                    //小益账号已绑定该机顶盒
                    code = NetworkCode.BUNDLING_REPETITION;
                    return code;
                } else if (!deviceId_old.isEmpty()){
                    //小益账号绑定了其他机顶盒，则解绑
                    phoneDeviceMapper.delete(account);
                }
                PhoneDevice phoneDevice = new PhoneDevice();
                phoneDevice.setDeviceId(TvDeviceId);
                phoneDevice.setUserId(account);
                phoneDeviceMapper.insertDevice(phoneDevice);
                code = NetworkCode.BUNDLING_SUCCESS;
                return code;
            }else {
                code = NetworkCode.BUNDLING_LIMIT;
                return code;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return NetworkCode.BUNDLING_FAIL;
        }
    }

    @Override
    public boolean checkUserId(int userId) {
        Map<String, String> params = new HashMap<>();
        params.put("userId",String.valueOf(userId));
        try {
            String result =WebHttpTool.sendPost(HTTP_POST_URL,params);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String finalResult = JSONObject.parseObject(jsonObject.getString("data")).getString("result");
            if(finalResult=="true"){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public ConfInfo selectByAcount(Integer acount) {
        return confInfoMapper.selectByAcount(acount);
    }

    @Transactional
    @Override
    public void insertConf(ConfInfo confInfo) {
        confInfoMapper.insertConf(confInfo);
    }

    @Override
    public List<BbsChannel> getSourceList(String url) {
        List<BbsChannel> sourceList = new ArrayList<>();
        synchronized (url){
            String startStr =  "<div class=\"f14 mb10\" id=\"read_tpc\">";
            String content = HttpUtil.httpGet(url);
            String[] channels = null;
            int startIndex = content.indexOf(startStr);
            if (startIndex != -1) {
                content = content.substring(startIndex).replace(startStr,"").replace(" ","").replace("\n","");
                content = content.substring(0,content.indexOf("</div>"));
                channels = content.split("<br/>");
            }
            for (String channel : channels){
                String channelName = channel.substring(0, channel.indexOf(",<"));
                Pattern pattern = Pattern.compile("http://[A-Za-z0-9./_]+.m3u8");
                Matcher matcher = pattern.matcher(channel);
                String playUrl = null;
                if (matcher.find())
                {
                    playUrl = matcher.group();
                }
                sourceList.add(new BbsChannel(channelName,playUrl));
            }
            String fileDate = JsonResult.toString(NetworkCode.CODE_SUCCESS, sourceList);
            try {
                String resultKey = QiNiuUploadTool.byteUpdate(fileDate.getBytes("utf-8"));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sourceList;
    }

    @Override
    public String checkByUserId(int userId) {
        Map<String,String> map=new HashMap<>();
        String s = phoneDeviceMapper.selectDeviceIdByUserId(userId);
        if (NullUtil.isNullObject(s)){
            /*用户没有绑定 此处直接返回 return  */
            map.put("isBindling","false");
            map.put("isDefine","false");
            map.put("confUrl","");
            map.put("defineName","");
            return  JsonResult.toString(NetworkCode.CODE_SUCCESS,map);
        }
        /*用户有自定义源*/
        PhoneService phoneService=phoneServiceMapper.selectByUserId(userId);
        if (!NullUtil.isNullObject(phoneService)){
            map.put("isBindling","true");
            map.put("isDefine","true");
            map.put("confUrl",phoneService.getConfUrl());
            map.put("defineName",phoneService.getDefineName());
            return  JsonResult.toString(NetworkCode.CODE_SUCCESS,map);

        }
        map.put("isBindling","true");
        map.put("isDefine","false");
        map.put("confUrl","");
        map.put("defineName","");
        return  JsonResult.toString(NetworkCode.CODE_SUCCESS,map);
    }

    @Transactional
    @Override
    public void updateConfinfo(ConfInfo confInfo) {
        confInfoMapper.updateConfinfo(confInfo);
    }

    @Transactional
    @Override
    public void updateDefinedName(int userId,String definedName) {
        try {
            PhoneService phoneService = new PhoneService();
            phoneService.setUserId(userId);
            phoneService.setDefineName(definedName);
            phoneServiceMapper.updateDefinedName(phoneService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


