package com.readyidu.service.impl;

import com.readyidu.mapper.ChannelDeathMapper;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.ChannelDeath;
import com.readyidu.service.DeathChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2017/6/23
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Service("deathChannelService")
public class DeathChannelServiceImpl implements DeathChannelService {

    @Resource(name = "channelMapper")
    ChannelMapper channelMapper;

    @Resource(name = "channelDeathMapper")
    ChannelDeathMapper channelDeathMapper;

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
}
