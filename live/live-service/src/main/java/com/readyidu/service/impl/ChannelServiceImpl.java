package com.readyidu.service.impl;

import java.util.List;

import com.readyidu.service.ChannelService;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.mapper.ChannelTypeMapper;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.readyidu.service.BaseService;
import com.readyidu.service.CacheService;

import javax.annotation.Resource;


@Service("channelService")
public class ChannelServiceImpl extends BaseService implements
        ChannelService {

    @Resource(name = "channelMapper")
    private ChannelMapper channelMapper;

    @Resource(name = "channelTypeMapper")
    private ChannelTypeMapper channelTypeMapper;

    @Resource(name = "cacheService")
    private CacheService cacheService;

    private static final String CACHE_NAME = "channel_";

    @Override
    public List<Channel> getChannelList() {
        // TODO Auto-generated method stub
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelList";

        List<Channel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj) && false) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectAll();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public List<ChannelType> getChannelType() {
        // TODO Auto-generated method stub
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelType";

        List<ChannelType> channelType = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelType = JSON.parseArray(cacheObj, ChannelType.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelType = channelTypeMapper.selectAll();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelType),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelType;
    }
}