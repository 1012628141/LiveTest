package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.service.CacheService;
import com.readyidu.service.ConfInfoService;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.readyidu.service.BaseService.SERVICE_RBK;

/**
 * Created by 123 on 2017/12/18.
 */
@Service("confInfoService")
public class ConfInfoServiceImpl implements ConfInfoService {

    @Autowired
    private ConfInfoMapper confInfoMapper;
    @Resource(name = "cacheService")
    private CacheService cacheService;

    private static final String CACHE_NAME = "confInfoService_";

    @Override
    public ConfInfo selectChannelInfo(String version) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectChannelInfo_"+version;
        ConfInfo confInfo;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            confInfo = JSON.parseObject(cacheObj,ConfInfo.class);
        }else {
            confInfo = confInfoMapper.selectChannelInfo(version);
            cacheService.set(cacheKey, JSON.toJSONString(confInfo), CacheService.CACHE_TIMEOUT);
        }
        return confInfo;
    }
}
