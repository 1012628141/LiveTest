package com.readyidu.mapper;

import com.readyidu.model.ChannelSource;

import java.util.List;

/**
 * Created by 123 on 2017/7/26.
 */
public interface ChannelSourceMapper {
    int importData(ChannelSource channelSource);
    int delectSourceByid(Integer id);
    List<ChannelSource> selectSourceByParentId(Integer id);
}
