package com.readyidu.service;

import com.readyidu.model.ChannelSource;
import com.readyidu.model.CheckableChannel;

import java.util.List;

/**
 * Created by 123 on 2017/7/26.
 */
public interface ChannelSourceService {
    void importData(ChannelSource channelSource);
    List<CheckableChannel> selectDeathSource();
    int delectSourceByid(Integer id);
    int updateIsDelete(String source);
    int reductionSourceByid(Integer id);
    ChannelSource getDeathBySource(String source);
}
