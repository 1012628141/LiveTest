package com.readyidu.service;

import com.readyidu.model.ChannelDeath;
import com.readyidu.model.CheckableChannel;

import java.util.List;

/**
 * 2017/6/23
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public interface DeathChannelService {
    public List<ChannelDeath> getAll();
    public ChannelDeath getChannel(Integer id);
    public ChannelDeath getChannel(String source);
    public int insert(ChannelDeath record);
    public int update(ChannelDeath record);
    public int remove(Integer id);
    public List<CheckableChannel> checkDeathChannel();
}
