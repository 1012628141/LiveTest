package com.readyidu.mapper;

import com.readyidu.model.Channel;

import java.util.List;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);
    Channel selectByPrimaryKey(String source);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    List<Channel> selectAll();
    List<Channel> selectBySource(String source);
}