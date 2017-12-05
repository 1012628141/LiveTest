package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.LunBoFromMapper;
import com.readyidu.mapper.PlayBillInfoMapper;
import com.readyidu.model.*;
import com.readyidu.playbill.model.Program;
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
            playBillInfoMapper.cleanBillInfo(channelId);
            SimpleDateFormat spd = new SimpleDateFormat("HH:mm");
            // TODO: 2017/11/28 加缓存
            List<LunBoBillFrom> dramaList = lunBoFromMapper.getFromByChannelId(channelId);
            long nexttime = currtentData;
            for (LunBoBillFrom drame : dramaList){
                int playDate = (int) ((nexttime - todayLong) / ONEDAYSTAMP);
                long length = (long) drame.getPlaytime() * 1000;
                playBillInfoMapper.insertBillInfo(new PlayBillInfo(drame.getMovieName(),spd.format(nexttime), TimeUtil.getTargetDayTime(playDate),channelId));
                nexttime = nexttime+length;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }



    @Override
    public String getDemandListByChannelId() {
        try{
            String cacheKey = SERVICE_RBK + CACHE_NAME + "getDemandListByChannelId";
            String cacheObj = cacheService.get(cacheKey);
            List<LunBoBillFrom> list = null;
            if (!NullUtil.isNullObject(cacheObj)) {
                list = JSON.parseArray(cacheObj,LunBoBillFrom.class);
            }else {
                list = lunBoFromMapper.selectFromByChannelId();
                cacheService.set(cacheKey, JSON.toJSONString(list),
                        CacheService.CACHE_TIMEOUT);
            }
            if(list != null && list.size() != 0){
                return JsonResult.toString(CODE_SUCCESS,list);
            }
            return JsonResult.toString(CODE_SUCCESS,"");
        }catch (Exception e){
            return JsonResult.toString(CODE_FAIL,"");
        }

    }


    @Override
    public List<DemandChannel> getDemandList() {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "DemandlList";
        String cacheObj = cacheService.get(cacheKey);
        List<DemandChannel> channelList = null;
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, DemandChannel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList= lunBoFromMapper.selectIntoChannel();
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
        // TODO: 2017/11/28 加缓存
        List<PlayBillInfo> todayProgram = playBillInfoMapper.selectBill(new PlayBillInfo(todayTime, channelId));
        List<PlayBillInfo> tommorrowProgram = playBillInfoMapper.selectBill(new PlayBillInfo(tomrrow, channelId));
        Map<String,Object> channelBill = new HashMap<>();
        if(todayProgram.size()!=0)
        {
            channelBill.put("todayProgram",todayProgram);
            channelBill.put("tommorrowProgram",tommorrowProgram);
        }
        else {
            List<Program> today = new ArrayList<>();
            List<Program> tommorrow = new ArrayList<>();
            today.add(new Program("暂无节目信息", "00:00"));
            tommorrow.add(new Program("暂无节目信息", "00:00"));
            channelBill.put("todayProgram",today);
            channelBill.put("tommorrowProgram", tommorrow);
        }
        return channelBill;
    }


    @Override
    public String selectDemandById(Integer id) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "DemandlSource"+id.toString();
        String cacheObj = cacheService.get(cacheKey);
        String source = null;
        if (!NullUtil.isNullObject(cacheObj)) {
            source = cacheObj;
        } else {
            source = lunBoFromMapper.selectDemandById(id);
            if (!source.isEmpty())
                // 信息缓存5分钟
                cacheService.set(cacheKey,source,CacheService.CACHE_TIMEOUT);
        }
        return source;

    }

    @Override
    public int reportDemand(Integer id) {
        return lunBoFromMapper.reportDemand(id);
    }

    @Override
    public boolean checkLunboBill(Integer channelId,String fileName) {
        // TODO: 2017/11/28 加缓存策略
        List<LunBoBillFrom> fileList = lunBoFromMapper.selectFileByChannelId(channelId);
        ListIterator<LunBoBillFrom> fileIterator = fileList.listIterator();
        while (fileIterator.hasNext())
        {
            LunBoBillFrom thisObj = fileIterator.next();
            if (thisObj.getFileName().equals(fileName))
            {
                if (fileIterator.hasNext())
                {
                    return true;
                }
                long currtentData = new Date().getTime();
                long todayLong = TimeUtil.getTodayLong();
                String todayTime = TimeUtil.getTodayTime();
                String tomrrow = TimeUtil.getTomorrowTime(currtentData);
                playBillInfoMapper.cleanBillInfo(channelId);
                SimpleDateFormat spd = new SimpleDateFormat("HH:mm");
                List<LunBoBillFrom> dramaList = lunBoFromMapper.getFromByChannelId(channelId);
                long nexttime = currtentData;
                playBillInfoMapper.insertBillInfo(
                        new PlayBillInfo(thisObj.getMovieName()
                                ,spd.format(nexttime)
                                , todayTime
                                ,channelId));
                nexttime = nexttime+(long)thisObj.getPlaytime()*1000;
                for (LunBoBillFrom drame : dramaList){
                    int playDate = (int) ((nexttime - todayLong) / ONEDAYSTAMP);
                    long length = (long) drame.getPlaytime() * 1000;
                    playBillInfoMapper.insertBillInfo(
                            new PlayBillInfo(drame.getMovieName()
                            ,spd.format(nexttime)
                            , TimeUtil.getTargetDayTime(playDate)
                            ,channelId));
                    nexttime = nexttime+length;
                }
                return true;
            }

        }
        return false;
    }
    @Override
    public List<NewChannel> selectDemandByTypeId(Integer typeid) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "DemandlListByTypeid"+typeid.toString();
        String cacheObj = cacheService.get(cacheKey);
        List<NewChannel> channelList = null;
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, NewChannel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList= lunBoFromMapper.selectDemandByTypeId(typeid);
            if (!channelList.isEmpty())
                // 信息缓存5分钟
                cacheService.set(cacheKey,JSON.toJSONString(channelList),CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public List<NewChannel> selectTvShowByChannelId(Integer channelId) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectTvShowByChannelId"+channelId.toString();
        String cacheObj = cacheService.get(cacheKey);
        List<NewChannel> channelList = null;
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, NewChannel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList= lunBoFromMapper.selectTvShowByChannelId(channelId);
            if (!channelList.isEmpty())
                // 信息缓存5分钟
                cacheService.set(cacheKey,JSON.toJSONString(channelList),CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }
}
