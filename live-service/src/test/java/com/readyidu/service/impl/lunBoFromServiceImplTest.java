//package com.readyidu.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.readyidu.mapper.LunBoFromMapper;
//import com.readyidu.model.LunBoBillFrom;
//import com.readyidu.service.CacheService;
//import com.readyidu.tools.TestBaseConfig;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import static org.junit.Assert.assertTrue;
//
//public class lunBoFromServiceImplTest extends TestBaseConfig {
//
//    @Autowired
//    private LunBoFromMapper lunBoFromMapper;
//    @Autowired
//    private CacheService cacheService;
//
//    private static final String CACHE_NAME = "lunBo_";
//
//    private  long timeStamp = 0;
//
//    @Test
//    public void getLunBoListByChannelId() throws Exception {
//        int  ChannelId = 5050;
//        int  sort = 4;
//        List<LunBoBillFrom> list = null;
//        list = lunBoFromMapper.getFromByChannelId(ChannelId);
//
//
//
//        Map<String,List<Map>> table = new HashMap<>();
//        table = getProgramTable(list,sort);
//        System.out.println(table);
//        assertTrue(!table.isEmpty());
//    }
//
//
//    private Map<String,List<Map>> getProgramTable(List<LunBoBillFrom> list, Integer sort) {
//        List<Map> todayMap = new ArrayList<Map>();
//        List<Map> tomorrowMap = new ArrayList<Map>();
//        Map<String,List<Map>> programTable = new HashMap<>();
//        int length = list.size();
//        String ShowTime = null;
//        int startId = 10000;
//        long time = System.currentTimeMillis();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date(time));
//        cal.add(Calendar.DAY_OF_YEAR,1);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        long tomorrowTime = cal.getTime().getTime();
//        boolean start = false;
//        boolean tomorrow = false;
//        boolean today = true;
//        for (int i = 0; i < length; i++) {
//            int sortId = list.get(i).getSort();
//            int playTime = list.get(i).getPlaytime();
//            String MovieName = list.get(i).getMovieName();
//            if (startId == i)
//                break;
//            Map<String, String> map = new HashMap<String, String>();
//            if (sortId==sort) {
//                    startId = i;
//                    start = true;
//                    ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
//                    map.put("ChannelName", MovieName);
//                    map.put("showTime", ShowTime);
//                    todayMap.add(map);
//                    if(i==length-1)
//                        i=-1;
//                    continue;
//            }else if(start) {
//                time = time + (long) (playTime * 1000);
//                if(time>tomorrowTime){
//                    if(!tomorrow) {
//                        tomorrow=true;
//                        today=false;
//                        ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
//                        map.put("ChannelName",MovieName);
//                        map.put("showTime",ShowTime );
//                        tomorrowMap.add(map);
//                    }else if(tomorrow){
//                        map.clear();
//                         ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
//                        map.put("channelName", MovieName);
//                        map.put("showTime", ShowTime);
//                        tomorrowMap.add(map);
//                        if (i == length - 1) {
//                            i = -1;
//                        }
//                    }
//                    }
//                    if(today){
//                    ShowTime = new SimpleDateFormat("HH:mm").format(new Date(time));
//                    map.put("channelName", MovieName);
//                    map.put("showTime", ShowTime);
//                    todayMap.add(map);
//                    if (i == length - 1) {
//                        i = -1;
//                    }
//                }
//            }
//        }
//        programTable.put("tommorrowProgram",tomorrowMap);
//        programTable.put("todayProgram",todayMap);
//        return programTable;
//    }
//
//    @Test
//    public void getDemandListByChannelId() throws Exception {
//        List<LunBoBillFrom>   list = lunBoFromMapper.selectFromByChannelId();
//
//        System.out.println(list);
//        assertTrue(!list.isEmpty());
//
//    }
//
//}
