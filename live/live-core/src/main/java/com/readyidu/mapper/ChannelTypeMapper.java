package com.readyidu.mapper;

import com.readyidu.model.ChannelType;

import java.util.List;

public interface ChannelTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelType record);

    int insertSelective(ChannelType record);

    ChannelType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelType record);

    int updateByPrimaryKey(ChannelType record);

    List<ChannelType> selectAll();
}