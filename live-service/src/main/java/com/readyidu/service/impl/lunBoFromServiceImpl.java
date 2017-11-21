package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.LunBoFromMapper;
import com.readyidu.model.LunBoBillFrom;
import com.readyidu.playbill.model.Program;
import com.readyidu.service.CacheService;
import com.readyidu.service.lunBoFromService;
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
    private LunBoFromMapper lunBoFromMapper;

    @Autowired
    private CacheService cacheService;

    private static final String CACHE_NAME = "lunBo_";

    private  long timeStamp = 0;

    @Override
    public String getLunBoListByChannelId(Integer channelId,Integer sort) {
        try{
            String cacheKey = SERVICE_RBK + CACHE_NAME + "ChannelId" +channelId;
            List<LunBoBillFrom> list = null;
            String cacheObj = cacheService.get(cacheKey);
            list = lunBoFromMapper.getFromByChannelId(channelId);
            Map<String,List> table = new HashMap<>();
            table = getProgramTable(list,sort);

            cacheService.set(cacheKey,JsonResult.toString(CODE_SUCCESS,table),CacheService.CACHE_TWODAY_TIMEOUT);
            return JsonResult.toString(CODE_SUCCESS,table);
        }catch(Exception e ){
            return JsonResult.toString(CODE_FAIL,"");
        }
    }


    private Map<String,List> getProgramTable(List<LunBoBillFrom> list, Integer sort) {
        List<Program> todayList = new ArrayList<Program>();
        List<Program> tomorrowList = new ArrayList<Program>();
        Map<String,List> programTable = new HashMap<>();
        String ShowTime = null;
        //获得当前时间、第二天0点时间
        long time = System.currentTimeMillis();
        long tomorrowTime = GetTomorrowTime(time);
        //判断
        boolean start = false;
        boolean tomorrow = false;
        boolean today = true;
        //获得节目单
        int startId = 10000;
        int length = list.size();
        for (int i = 0; i < length; i++) {
            LunBoBillFrom lunBoBillFrom = list.get(i);
            int sortId = lunBoBillFrom.getSort();
            int playTime = lunBoBillFrom.getPlaytime();
            String MovieName = lunBoBillFrom.getMovieName();
            if (startId == i)
                break;

            if (sortId==sort) {
                startId = i;
                start = true;
                todayList.add(SetMovie(MovieName,time));
                if(i==length-1)
                    i=-1;
                continue;
            }else if(start) {
                time = time + (long) (playTime * 1000);
                if(time>tomorrowTime){
                    if(!tomorrow) {
                        tomorrow=true;
                        today=false;
                        tomorrowList.add(SetMovie(MovieName,time));
                    }else if(tomorrow){
                        tomorrowList.add(SetMovie(MovieName,time));
                        if (i == length - 1) {
                            i = -1;
                        }
                    }
                }
                if(today){
                    todayList.add(SetMovie(MovieName,time));
                    if (i == length - 1) {
                        i = -1;
                    }
                }
            }
        }
        programTable.put("tomorrowProgram",tomorrowList);
        programTable.put("todayProgram",todayList);
        return programTable;
    }

    private Program SetMovie(String MovieName,long time){
        String ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
        Program program = new Program(MovieName,ShowTime);
        return program;
    }

    private long GetTomorrowTime(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.DAY_OF_YEAR,1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime().getTime();
    }


    @Override
    public String getDemandListByChannelId(Integer ChannelId  ) {
        List<LunBoBillFrom> list = null;

        try{
            list = lunBoFromMapper.selectFromByChannelId(ChannelId);
            if(list != null && list.size() != 0){
                return JsonResult.toString(CODE_SUCCESS,list);
            }
            return JsonResult.toString(CODE_SUCCESS,"");
        }catch (Exception e){
            return JsonResult.toString(CODE_FAIL,"");
        }

    }

}
