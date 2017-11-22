package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.LunBoFromMapper;
import com.readyidu.mapper.PlayBillInfoMapper;
import com.readyidu.model.*;
import com.readyidu.service.BaseService;
import com.readyidu.service.CacheService;
import com.readyidu.service.LunBoFromService;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import com.readyidu.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.readyidu.constants.NetworkCode.CODE_FAIL;
import static com.readyidu.constants.NetworkCode.CODE_SUCCESS;

@Service("lunBoFromService")
public class LunBoFromServiceImpl extends BaseService implements LunBoFromService {

    @Autowired
    private LunBoFromMapper lunBoFromMapper;

    @Autowired
    private PlayBillInfoMapper playBillInfoMapper;

    @Autowired
    private CacheService cacheService;

    private static final String CACHE_NAME = "lunBo_";

    private  long timeStamp = 0;

    private static long ONEDAYSTAMP = 86400000;



    @Override
    public boolean refreshChannelBill(Integer channelId) {
        try {
            long currtentData = new Date().getTime();
            long todayLong = TimeUtil.getTodayLong();
            String todayTime = TimeUtil.getTodayTime();
            String tomrrow = TimeUtil.getTomorrowTime(currtentData);
            playBillInfoMapper.cleanBillInfo(todayTime);
            playBillInfoMapper.cleanBillInfo(tomrrow);
            SimpleDateFormat spd = new SimpleDateFormat("HH:mm");
            List<LunBoBillFrom> dramaList = lunBoFromMapper.getFromByChannelId(channelId);
            long nexttime = currtentData;
            for (LunBoBillFrom drame : dramaList){
                String playDate = nexttime - todayLong < ONEDAYSTAMP ? TimeUtil.getTodayTime() : TimeUtil.getTomorrowTime(currtentData);
                long length = (long) drame.getPlaytime() * 1000;
                playBillInfoMapper.insertBillInfo(new PlayBillInfo(drame.getMovieName(),spd.format(nexttime), playDate,channelId));
                nexttime = nexttime+length;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public String getDemandListByChannelId() {
        List<LunBoBillFrom> list = null;
        try{
            list = lunBoFromMapper.selectFromByChannelId();
            if(list != null && list.size() != 0){
                return JsonResult.toString(CODE_SUCCESS,list);
            }
            return JsonResult.toString(CODE_SUCCESS,"");
        }catch (Exception e){
            return JsonResult.toString(CODE_FAIL,"");
        }

    }


    @Override
    public List<Channel> getDemandList() {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "DemandlList";
        String cacheObj = cacheService.get(cacheKey);
        List<Channel> channelList = null;
        cacheObj =null;
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList= lunBoFromMapper.selectIntoChannel();
            if (channelList.size()!=0)
            // 信息缓存5分钟
                cacheService.set(cacheKey,JSON.toJSONString(channelList),CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }
    @Override
    public Map<String, Object> getChannelBill(Integer channelId) {
        long currtentData = new Date().getTime();
        String todayTime = TimeUtil.getTodayTime();
        String tomrrow = TimeUtil.getTomorrowTime(currtentData);
        List<PlayBillInfo> todayProgram = playBillInfoMapper.selectBill(new PlayBillInfo(todayTime, channelId));
        List<PlayBillInfo> tommorrowProgram = playBillInfoMapper.selectBill(new PlayBillInfo(tomrrow, channelId));
        Map<String,Object> channelBill = new HashMap<>();
        channelBill.put("todayProgram",todayProgram);
        channelBill.put("tommorrowProgram",tommorrowProgram);
        return channelBill;
    }

    @Override
    public String selectDemandById(Integer id) {
        return lunBoFromMapper.selectDemandById(id);
    }

}
