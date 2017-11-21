package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.*;
import com.readyidu.service.*;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/9/30.
 */
@Service("tvSourceService")
public class TvSourceServiceImpl extends BaseService implements TvSourceService {
    private static final String IPIP_TOKEN = "30e93b06b4a738f4bf233566a83f30f02ba6c093";
    @Resource(name = "channelMapper")
    private ChannelMapper channelMapper;

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "routerService")
    private RouterService routerService;

    @Resource(name = "sourceService")
    SourceService sourceService;

    @Resource(name = "channelSourceService")
    ChannelSourceService channelSourceService;

    @Resource(name = "ipDataService")
    IpDataService ipDataService;

    @Resource(name = "cacheService")
    CacheService cacheService;

    private static final String CACHE_NAME = "channel_";



    @Override
    public String selectChannelByKey(String key) {
        try {
            List<Channel> channels = channelService.selectChannelByKey(key);
            if (channels.size() == 0) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channels);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getSourceByIp(String sourceUri, String IpAdress) {
        try {
            String source = sourceService.getSource(sourceUri);
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.CODE_FAIL, "");
            }
            if (source.contains("60.190.249.8"))
            {
                String ip = IpAdress;
                String operator = null;
                if (!NullUtil.isNullObject(ip))
                {
                    operator = checkOperator(ip);
                }
                if (NullUtil.isNullObject(operator))
                {
                    operator = "联通";
                }
                switch (operator){
                    case "电信":
                        break;
                    case "联通":
                        source = source.replace("60.190.249.8","101.71.36.8");
                        break;
                    case "移动":
                        source = source.replace("60.190.249.8","218.205.92.189");
                        break;
                }
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, new Source(source));
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getSource(String sourceUri) {
        try {
            String source = sourceService.getSource(sourceUri);
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, new Source(source));
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getChannelList() {
        try {
            Map<String,Object> dataJson = new HashMap<>();
            List<Channel> channelList = channelService.selectAllNew();
            List<Channel> movieList = channelService.getMovieToSource();
            dataJson.put("channels",channelList);
            dataJson.put("movieList",movieList);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,dataJson);
        }catch (Exception e)
        {
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

    @Override
    public String channelPlaybill(String channelId) {
        try {
            Map<String, Object> playBill = channelService.channelPlaybill(channelId);
            if (NullUtil.isNullObject(playBill))
            {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400,playBill);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,playBill);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }


    @Override
    public String channelType() {
        try {
            List<ChannelType> channelTypeList = channelService.getChannelType();
            for(ChannelType channelType :channelTypeList)
            {
                if (channelType.getId()==100)
                {
                    channelTypeList.remove(channelType);
                    break;
                }
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,channelTypeList);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

    @Override
    public String selectChannelInfoByKey(String key) {
        try {
//            String cacheKey = SERVICE_RBK + CACHE_NAME + "INFO_"+key;
            List<Object> channelInfo = new ArrayList<>();
//            String channelObj = cacheService.get(cacheKey);
//            if (!NullUtil.isNullObject(channelObj)){
//                channelInfo = JSON.parseArray(channelObj,Object.class);
//                return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfo    );
//            }
            List<Channel> channels = channelService.selectChannelByKey(key);
            if (channels.size() == 0) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            for (Channel channel : channels)
            {
                Map<String,Object> dataMap = new HashMap<>();
                Map<String, Object> playBill = channelService.channelPlaybill(channel.getId().toString());
                dataMap.put("channel",channel);
                dataMap.put("playBill",playBill);
                channelInfo.add(dataMap);
            }
//            if (!NullUtil.isNullObject(channelInfo))
//            {
//                cacheService.set(cacheKey,JSON.toJSONString(channelInfo),CacheService.CACHE_TIMEOUT);
//            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfo);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String insertReport(String source) {
        // Check if update
        try {
            if (!TextUtils.isEmpty(source)) {
                ChannelSource channelDeath = channelSourceService.getDeathBySource(source);
                if (channelDeath != null) {
                    return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
                }
                else {
                    if (channelSourceService.updateIsDelete(source) != 0) {
                        return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
                    }
                }
            }
            return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
        }catch (Exception e)
        {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getChannelList(String platformName) {
        return null;
    }

    public String checkOperator(String IpAdress) {
        IpData ipData = new IpData(IpAdress);
        try {
            String searchResult = ipDataService.SelectIpOperator(ipData);
            if (!NullUtil.isNullObject(searchResult))
            {
                return searchResult;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String httpResult = HttpUtil.httpGet("http://ipapi.ipip.net/find?addr=" + IpAdress, IPIP_TOKEN);
        JSONObject jsonResult = JSON.parseObject(httpResult);
        String data = jsonResult.getString("data");
        String[] info = data.split(",");
        String operator = info[4].replace("\"", "");
        if (!NullUtil.isNullObject(operator))
        {
            ipData.setOperator(operator);
            ipDataService.insertIpData(ipData);
        }
        return operator;
    }
}
