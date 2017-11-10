package com.readyidu.mapper;

import com.readyidu.model.Channel;

import java.util.List;
import java.util.Map;

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
    Channel selectChannelByChannel(String channel);
    Channel selectChannelById(Integer id);

    public List<Channel> selectAllNew();
    public List<Channel> selectHotChannel();
    List<Channel> selectChannelByKey(String key);

}