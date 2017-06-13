package com.readyidu.service;

import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;

import java.util.List;

public interface ChannelService {
    public List<Channel> getChannelList();

    public List<ChannelType> getChannelType();
}
