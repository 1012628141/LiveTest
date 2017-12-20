package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.*;
import com.readyidu.service.*;
import com.readyidu.source.base.LiveManager;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.apache.commons.jexl2.UnifiedJEXL;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Resource(name = "lunBoFromService")
    LunBoFromService lunBoFromService;

    @Resource(name = "liveManager")
    LiveManager liveManager;

    @Resource(name = "cacheService")
    CacheService cacheService;

    private static final String CACHE_NAME = "tv_source";


    @Override
    public String selectChannelByKey(String key) {
        try {
            List<Channel> channels = channelService.selectChannelByKey(key);
            if (channels.size() == 0) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channels);
        } catch (Exception e) {
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
            if (source.contains("124.160.117.36")) {
                String ip = IpAdress;
                String operator = null;
                if (!NullUtil.isNullObject(ip)) {
                    operator = checkOperator(ip);
                }
                if (NullUtil.isNullObject(operator)) {
                    operator = "联通";
                }
                switch (operator) {
                    case "电信":
                        source = source.replace("124.160.117.36", "183.134.101.36");
                        break;
                    case "联通":
                        break;
                    case "移动":
                        source = source.replace("124.160.117.36", "218.205.92.125");
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
            Map<String, Object> dataJson = new HashMap<>();
            List<Channel> channelList = channelService.selectAllNew();
            List<DemandChannel> movieList = channelService.getMovieToSource();
            dataJson.put("channels", channelList);
            dataJson.put("movieList", movieList);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, dataJson);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String channelPlaybill(String channelId) {
        try {
            Map<String, Object> playBill = channelService.channelPlaybill(channelId);
            if (NullUtil.isNullObject(playBill)) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, playBill);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, playBill);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }


    @Override
    public String channelType() {
        try {
            List<ChannelType> channelTypeList = channelService.getChannelType();
            for (ChannelType channelType : channelTypeList) {
                if (channelType.getId() == 100) {
                    channelTypeList.remove(channelType);
                    break;
                }
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelTypeList);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String selectChannelInfoByKey(String key) {
        try {
            List<Object> channelInfo = new ArrayList<>();
            List<String>channelNameList = channelService.selectChannelIdByKey(key);
            if (channelNameList.size() == 0) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            for (String channelName:channelNameList) {
                String cacheKey = SERVICE_RBK + CACHE_NAME + "selectChannelInfoByKey" + channelName;
                Channel channel =null;
                Map<String, Object> dataMap = new HashMap<>();
                String channelObj = cacheService.get(cacheKey);
                if(!NullUtil.isNullObject(channelObj)){
                    dataMap = JSON.parseObject(channelObj,Map.class);
                }else {
                    channel = channelService.selectChannelByChannelName(channelName);
                    Map<String, Object> playBill = channelService.channelPlaybill(channel.getId().toString());
                    dataMap.put("channel", channel);
                    dataMap.put("playBill", playBill);
                    // 信息缓存5分钟
                    cacheService.set(cacheKey, JSON.toJSONString(dataMap), CacheService.CACHE_TIMEOUT);
                }
                channelInfo.add(dataMap);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfo);
        } catch (Exception e) {
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
                } else {
                    if (channelSourceService.updateIsDelete(source) != 0) {
                        return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
                    }
                }
            }
            return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getChannelList(String platformName) {
        try {
            Map<String, Object> dataJson = new HashMap<>();
            List<Channel> channelList = null;
            List<DemandChannel> movieList = null;
            if (!NullUtil.isNullObject(platformName) && platformName.equals("tv")) {
                channelList = channelService.getChannelWithoutSource();
//                movieList = channelService.getMovieToSource();
                movieList = lunBoFromService.selectIntoChannelWithOutFengmi();

            }
            else {
                channelList = channelService.selectAllNew();
                movieList = channelService.getMovieToSource();
            }
            dataJson.put("channels", channelList);
            dataJson.put("movieList", movieList);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, dataJson);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getSourceById(Integer id, String IpAdress) {
        try {
            String source = channelSourceService.selectSourceById(id);
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            if (source.startsWith("sourceUri://")) {
                source = sourceService.getSource(source);
            }
            if (source.contains("124.160.117.36")) {
                String ip = IpAdress;
                String operator = null;
                if (!NullUtil.isNullObject(ip)) {
                    operator = checkOperator(ip);
                }
                if (NullUtil.isNullObject(operator)) {
                    operator = "联通";
                }
                switch (operator) {
                    case "电信":
                        source = source.replace("124.160.117.36", "183.134.101.36");
                        break;
                    case "联通":
                        break;
                    case "移动":
                        source = source.replace("124.160.117.36", "218.205.92.125");
                        break;
                }
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, source);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getDemandById(Integer id, String IpAdress) {
        try {
            String source = lunBoFromService.selectDemandById(id);
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            if (source.startsWith("sourceUri://")) {
                source = liveManager.getChannelSource(source);
            }
            if (source.contains("124.160.117.35")) {
                String ip = IpAdress;
                String operator = null;
                if (!NullUtil.isNullObject(ip)) {
                    operator = checkOperator(ip);
                }
                if (NullUtil.isNullObject(operator)) {
                    operator = "联通";
                }
                switch (operator) {
                    case "电信":
                        source = source.replace("124.160.117.36", "183.134.101.36");
                        break;
                    case "联通":
                        break;
                    case "移动":
                        source = source.replace("124.160.117.36", "218.205.92.125");
                        break;
                }
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, source);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String insertReport(Integer sourceId, Boolean isLive) {
        try {
            if (isLive && channelSourceService.reportSourceByid(sourceId) != 0) {
                return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
            } else if (!isLive && lunBoFromService.reportDemand(sourceId) != 0) {
                return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
            }
            return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getNewChannelListByTypeId(String typeId,Integer id) {
        try {
            Map<String, Object> dataJson = new HashMap<>();
            String cacheAllkey = SERVICE_RBK + CACHE_NAME + "getNewChannelListByTypeId"+id.toString()+typeId;
            String cacheAll = cacheService.get(cacheAllkey);
            if (!NullUtil.isNullObject(cacheAll)){
                dataJson = JSON.parseObject(cacheAll,Map.class);
            }else {
                //获取直播播放列表根据typeid
                List<Integer>channelList = channelService.selectChannelByTypeId(typeId,id);
                //获取点播播放列表根据typeid
                List<NewChannel> movieList = lunBoFromService.selectDemandByTypeId(Integer.parseInt(typeId));
                List<NewChannel> channelsList = new ArrayList<NewChannel>();
                String cacheKey =null;
                NewChannel newChannel =null;
                SimpleDateFormat df = new SimpleDateFormat("MM-dd");
                String nowTime = df.format(new Date());
                String cacheObj = null;
                for (Integer channelId:channelList) {
                    cacheKey = "channel_playbill_"+channelId.toString()+"_"+nowTime;
                    //获取redis缓存数据
                    cacheObj = cacheService.get(cacheKey);
                    if (!NullUtil.isNullObject(cacheObj)){
                        newChannel = JSON.parseObject(cacheObj,NewChannel.class);
                        channelsList.add(newChannel);
                    }else {
                        //获取部分没有节目表的频道
                        newChannel = channelService.selectNewChannelById(channelId);
                        if (!NullUtil.isNullObject(newChannel.getC())){
                            channelsList.add(newChannel);
                        }
                    }
                }
                dataJson.put("channels", channelsList);
                dataJson.put("movieList", movieList);
                // 信息缓存5分钟
                if (!channelsList.isEmpty()||!movieList.isEmpty())
                    cacheService.set(cacheAllkey, JSON.toJSONString(dataJson), 60);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, dataJson);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    public String checkOperator(String IpAdress) {
        IpData ipData = new IpData(IpAdress);
        String searchResult = ipDataService.SelectIpOperator(ipData);
        if (!NullUtil.isNullObject(searchResult)) {
            return searchResult;
        }
        String httpResult = HttpUtil.httpGet("http://ipapi.ipip.net/find?addr=" + IpAdress, IPIP_TOKEN);
        JSONObject jsonResult = JSON.parseObject(httpResult);
        String data = jsonResult.getString("data");
        String[] info = data.split(",");
        String operator = info[4].replace("\"", "");
        if (!NullUtil.isNullObject(operator)) {
            ipData.setOperator(operator);
            ipDataService.insertIpData(ipData);
        }
        return operator;
    }
    @Override
    public String getTypeList(Integer id) {
        try {
            String type = null ;
            List<ChannelType> channelTypeList = channelService.getTypeList();
            type = channelService.getTypeById(id);
            channelTypeList.get(2).setType(type);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelTypeList);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String selectNewChannelInfoByKey(String key) {
        try {
            String cacheKey = SERVICE_RBK + CACHE_NAME + "APP_INFO_" + key;
            List<Object> channelInfo = new ArrayList<>();
            String channelObj = cacheService.get(cacheKey);
            if (!NullUtil.isNullObject(channelObj)) {
                channelInfo = JSON.parseArray(channelObj, Object.class);
                return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfo);
            }
            List<NewChannel> channels = channelService.selectAppChannelByKey(key);
            if (channels.size() == 0) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
//            for (Channel channel : channels) {
//                Map<String, Object> dataMap = new HashMap<>();
//                Map<String, Object> playBill = channelService.channelPlaybill(channel.getId().toString());
//                dataMap.put("channel", channel);
//                dataMap.put("playBill", playBill);
//                channelInfo.add(dataMap);
//            }
            if (!NullUtil.isNullObject(channels)) {
                cacheService.set(cacheKey, JSON.toJSONString(channels), CacheService.CACHE_TIMEOUT);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channels);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String selectTvShowByChannelId(Integer channelId) {
        try{
            List<NewChannel> channelList = lunBoFromService.selectTvShowByChannelId(channelId);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelList);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String selectTvChannelList(String platformName) {
        try {
            Map<String, Object> dataJson = new HashMap<>();
            List<Channel> channelList = null;
            List<DemandChannel> movieList = null;
            if (!NullUtil.isNullObject(platformName) && platformName.equals("tv")) {
                channelList = channelService.getChannelWithoutSource();
                movieList = lunBoFromService.getDemandList();
            } else {
                channelList = channelService.selectAllNew();
                movieList = channelService.getMovieToSource();
            }
            dataJson.put("channels", channelList);
            dataJson.put("movieList", movieList);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, dataJson);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
}