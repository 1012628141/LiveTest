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

    List<String> selectCCTV();
    List<String> selectSatellite();
    List<Map> selectUrlByChannel(String TvName);
    List<Map> selectUrlByClassName(String ClassName);
    List<Map> selectUrlByChannelName(String search);

}