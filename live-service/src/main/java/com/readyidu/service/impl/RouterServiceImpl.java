package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.RouterMappingMapper;
import com.readyidu.model.RouterMapping;
import com.readyidu.service.CacheService;
import com.readyidu.service.RouterService;
import com.readyidu.util.NullUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public int deleteById(Integer id) {
        return routerMappingMapper.deleteById(id);
    }

    @Override
    public int insert(RouterMapping record) {
        return routerMappingMapper.insert(record);
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
    public RouterMapping selectByKey(String key) {return routerMappingMapper.selectByKey(key);}

    @Override
    public List<RouterMapping> selectByPageNo(Integer pageNo) {
        return routerMappingMapper.selectByPageNo(pageNo);
    }
}
