package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.RouterMappingMapper;
import com.readyidu.mapper.ChannelClassMapper;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.RouterMapping;
import com.readyidu.service.CacheService;
import com.readyidu.service.RouterService;
import com.readyidu.smartcore.hanlp.dto.SmartWord;
import com.readyidu.smartcore.hanlp.service.CustomerDictService;
import com.readyidu.util.NullUtil;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017/7/5
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Service("routerService")
public class RouterServiceImpl implements RouterService {

    @Resource(name = "routerMappingMapper")
    private RouterMappingMapper routerMappingMapper;

    @Resource(name = "cacheService")
    private CacheService cacheService;

    @Resource(name = "customerDictService")
    private CustomerDictService customerDictService;

    private static String ENGINE = "tv";
    private static String WORD_NATURE = "tv_name";

    @Override
    public int deleteById(Integer id) {
        return routerMappingMapper.deleteById(id);
    }

    @Override
    public int insert(RouterMapping record) {
        List<SmartWord> wordList = new ArrayList<>();
        wordList.add(new SmartWord(record.getKey(),WORD_NATURE));
        Map<String, Object> result = customerDictService.addWordToDict(ENGINE, wordList);
        if ((Boolean) result.get("success"))
        {
            return routerMappingMapper.insert(record);
        }
        return 0;
    }

    @Override
    public int update(RouterMapping record) {
        return routerMappingMapper.update(record);
    }

    @Override
    public RouterMapping selectById(Integer id) {
        return routerMappingMapper.selectById(id);
    }

    @Override
    public List<RouterMapping> selectByValue(String value) {
        return routerMappingMapper.selectByValue(value);
    }

    @Override
    public List<RouterMapping> selectAll() {
//        return routerMappingMapper.selectAll();
        String cacheKey = "channelMappingKey";

        List<RouterMapping> mappingList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj) && false) {
            mappingList = JSON.parseArray(cacheObj, RouterMapping.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            mappingList = routerMappingMapper.selectAll();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(mappingList),
                    CacheService.CACHE_TIMEOUT);
        }
        return mappingList;
    }

    @Override
    public List<RouterMapping> selectByKey(String key) {return routerMappingMapper.selectByKey(key);}

    @Override
    public List<RouterMapping> selectByPageNo(Integer pageNo) {
        return routerMappingMapper.selectByPageNo(pageNo);
    }
//    @Override
//    public  List<String> selectMenu(Integer number){
//        if(number==2) {
//            return channelClassMapper.selectAllClassName();
//        }
//        else if(number==3){
//            return channelMapper.selectCCTV();
//        }
//        else {
//            return channelMapper.selectSatellite();
//        }
//    }
//
//    @Override
//    public  List<Map> selectForm(String TvName,Integer form) {
//        if(form==1){
//            return channelMapper.selectUrlByClassName(TvName);
//        }
//        else{
//            return channelMapper.selectUrlByChannel(TvName);
//        }
//    }
//
//    @Override
//    public  List<Map> selectColumn(String search){
//        return channelMapper.selectUrlByChannelName(search);
//    }
    @Override
    public List<RouterMapping> selectExactByKey(String key) {
        return routerMappingMapper.selectExactByKey(key);
    }
}
