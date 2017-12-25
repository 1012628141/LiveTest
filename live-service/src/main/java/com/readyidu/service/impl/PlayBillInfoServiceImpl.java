package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.PlayBillInfoMapper;
import com.readyidu.model.PlayBillInfo;
import com.readyidu.service.CacheService;
import com.readyidu.service.PlayBillInfoService;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.readyidu.service.BaseService.SERVICE_RBK;

/**
 * Created by ypf on 2017/12/21.
 */
@Service("playBillInfoService")
public class PlayBillInfoServiceImpl implements PlayBillInfoService {
    @Autowired
    private PlayBillInfoMapper playBillInfoMapper;
    @Resource(name = "cacheService")
    private CacheService cacheService;

    private static final String CACHE_NAME = "playBillInfo_";

    @Override
    public List<PlayBillInfo> selectBillProgramByChannelId(Integer channelId) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectBillProgramByChannelId_" + channelId;
        List<PlayBillInfo> playBillInfoList = null;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            playBillInfoList = JSON.parseArray(cacheObj, PlayBillInfo.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            playBillInfoList = playBillInfoMapper.selectBillProgramByChannelId(channelId);
            // 信息缓存5分钟
            if (!NullUtil.isNullObject(playBillInfoList))
                cacheService.set(cacheKey, JSON.toJSONString(playBillInfoList), CacheService.CACHE_TIMEOUT);
        }
        return playBillInfoList;
    }
}
