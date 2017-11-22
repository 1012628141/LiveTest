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

    List<String> selectCCTV();
    List<String> selectSatellite();
    List<Channel> selectWithoutSource();

    //由于以下方法均是页面加载完成后使用的返回POJO页面无法识别所以使用Map对象返回
    List<Map> selectUrlByClassName(String TvName);
    List<Map> selectUrlByChannel(String TvName);
    List<Map> selectUrlByChannelName(String search);
    List<Map> selectAllChannel();

}