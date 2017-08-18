package com.readyidu.mapper;

import com.readyidu.model.ChannelSource;
import com.readyidu.model.CheckableChannel;
import com.readyidu.model.Source;

import java.util.List;

/**
 * Created by 123 on 2017/7/26.
 */
public interface ChannelSourceMapper {
    int importData(ChannelSource channelSource);
    int delectSourceByid(Integer id);
    List<ChannelSource> selectSourceByParentId(Integer id);
    List<CheckableChannel> selectDeathSource();
    int updateIsDelete(String source);
    int reductionSourceByid(Integer id);
    ChannelSource getDeathBySource(String source);
    int updateSort(ChannelSource channelSource);
    }
