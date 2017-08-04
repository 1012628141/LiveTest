package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelDeathMapper;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelDeath;
import com.readyidu.model.CheckableChannel;
import com.readyidu.service.BaseService;
import com.readyidu.service.CacheService;
import com.readyidu.service.DeathChannelService;
import com.readyidu.util.NullUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 2017/6/23
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Service("deathChannelService")
public class DeathChannelServiceImpl extends BaseService implements DeathChannelService {

    @Resource(name = "channelMapper")
    ChannelMapper channelMapper;

    @Resource(name = "channelDeathMapper")
    ChannelDeathMapper channelDeathMapper;

    @Resource(name = "cacheService")
    private CacheService cacheService;

    private static final String CACHE_NAME = "channel_";
    @Override
    public List<ChannelDeath> getAll() {
        return channelDeathMapper.selectAll();
    }

    @Override
    public ChannelDeath getChannel(Integer id) {
        return channelDeathMapper.selectByPrimaryKey(id);
    }

    @Override
    public ChannelDeath getChannel(String source) {
        return channelDeathMapper.selectBySource(source);
    }

    @Override
    public int insert(ChannelDeath record) {
        return channelDeathMapper.insert(record);
    }

    @Override
    public int update(ChannelDeath record) {
        return channelDeathMapper.updateByPrimaryKey(record);
    }

    @Override
    public int remove(Integer id) {
        return channelDeathMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CheckableChannel> checkDeathChannel() {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "deathChannelList";
        String cacheObj = cacheService.get(cacheKey);
        List<CheckableChannel> checkableChannels = new ArrayList<>();
        System.out.println("***************"+!NullUtil.isNullObject(cacheObj)+"*************");
        if (!NullUtil.isNullObject(cacheObj)) {
            return JSON.parseArray(cacheObj, CheckableChannel.class);
        }
        List<ChannelDeath> dList = getAll();
        for (ChannelDeath death: dList) {
            String source = death.getSource();
            List<Channel> deathChannel = channelMapper.selectBySource(source);
            if (deathChannel != null && deathChannel.size() != 0) {
                for (Channel c: deathChannel) {
                    CheckableChannel checkableChannel = new CheckableChannel();
                    checkableChannel.setChannelId(c.getId());
                    checkableChannel.setChannelName(c.getChannel());
                    checkableChannel.setChannelSource(c.getSource());
                    checkableChannel.setDeathSourceId(death.getId());
                    checkableChannel.setDeathSource(death.getSource());
                    checkableChannel.setCreatedAt(death.getCreatedat());
                    checkableChannels.add(checkableChannel);
                }
            }
        }
        cacheService.set(cacheKey,JSON.toJSONString(checkableChannels),CacheService.CACHE_TIMEOUT);
        return checkableChannels;
    }
}
