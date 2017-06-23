package com.readyidu.service;

import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;

import java.util.List;

public interface ChannelService {
    public List<Channel> getChannelList();
    public List<Channel> getChannelListWithDeathSource(String source);
    public List<ChannelType> getChannelType();

    public int addChannel(String name);
    public Channel getChannel(Integer id);
    public int updateSource(Integer channelId, String source);
    public int removeSource(Integer channelId, Integer sourceId);
    public int changeType(Integer channelId, String typeId);
    public int removeChannel(Integer channelId);
}
