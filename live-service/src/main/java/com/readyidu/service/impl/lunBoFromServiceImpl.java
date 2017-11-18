package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.model.lunBoBillFrom;
import com.readyidu.service.CacheService;
import com.readyidu.service.lunBoFromService;
import com.readyidu.mapper.lunBoFromMapper;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.readyidu.constants.NetworkCode.CODE_FAIL;
import static com.readyidu.constants.NetworkCode.CODE_SUCCESS;
import static com.readyidu.service.BaseService.SERVICE_RBK;

@Service("lunBoFromService")
public class lunBoFromServiceImpl implements lunBoFromService {

    @Autowired
    private lunBoFromMapper lunBoFromMapper;
    @Autowired
    private CacheService cacheService;

    private static final String CACHE_NAME = "lunBo_";

    private  long timeStamp = 0;

    @Override
    public String getLunBoListByChannelId(Integer ChannelId,Integer sort) {
        try{
            String cacheKey = SERVICE_RBK + CACHE_NAME + "ChannelId" + ChannelId;
            List<lunBoBillFrom> list = null;
            String cacheObj = cacheService.get(cacheKey);
            list = lunBoFromMapper.getFromByChannelId(ChannelId);
            Map<String,List<Map>> table = new HashMap<>();
            table = getProgramTable(list,sort);
            cacheService.set(cacheKey,JsonResult.toString(CODE_SUCCESS,table),CacheService.CACHE_TWODAY_TIMEOUT);
            return JsonResult.toString(CODE_SUCCESS,"");
        }catch(Exception e ){
            return JsonResult.toString(CODE_FAIL,"");
        }
    }


    private Map<String,List<Map>> getProgramTable(List<lunBoBillFrom> list,Integer sort) {
        List<Map> todayMap = new ArrayList<Map>();
        List<Map> tomorrowMap = new ArrayList<Map>();
        Map<String,List<Map>> programTable = new HashMap<>();
        int length = list.size();
        String ShowTime = null;
        int startId = 10000;
        long time = System.currentTimeMillis();
        //获得第二天的0点时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.DAY_OF_YEAR,1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        long tomorrowTime = cal.getTime().getTime();
        //判断
        boolean start = false;
        boolean tomorrow = false;
        boolean today = true;
        //获得节目单
        for (int i = 0; i < length; i++) {
            int sortId = list.get(i).getSort();
            int playTime = list.get(i).getPlaytime();
            String MovieName = list.get(i).getMovieName();
            if (startId == i)
                break;
            Map<String, String> map = new HashMap<String, String>();
            if (sortId==sort) {
                    startId = i;
                    start = true;
                    ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
                    map.put("ChannelName", MovieName);
                    map.put("showTime", ShowTime);
                    todayMap.add(map);
                    if(i==length-1)
                        i=-1;
                    continue;
            }else if(start) {
                time = time + (long) (playTime * 1000);
                if(time>tomorrowTime){
                    if(!tomorrow) {
                        tomorrow=true;
                        today=false;
                        ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
                        map.put("ChannelName",MovieName);
                        map.put("showTime",ShowTime );
                        tomorrowMap.add(map);
                    }else if(tomorrow){
                        map.clear();
                         ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
                        map.put("channelName", MovieName);
                        map.put("showTime", ShowTime);
                        tomorrowMap.add(map);
                        if (i == length - 1)
                            i = -1;
                    }
                    }
                    if(today){
                    ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
                    map.put("channelName", MovieName);
                    map.put("showTime", ShowTime);
                    todayMap.add(map);
                    if (i == length - 1) {
                        i = -1;
                    }
                }
            }
        }
        programTable.put("tommorrowProgram",tomorrowMap);
        programTable.put("todayProgram",todayMap);
        return programTable;
    }
}
