package com.readyidu.mapper;

import com.readyidu.model.Channel;
import com.readyidu.model.ChannelDeath;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ChannelDeathMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelDeath record);

    int insertSelective(ChannelDeath record);

    ChannelDeath selectByPrimaryKey(Integer id);
    ChannelDeath selectBySource(String source);

    int updateByPrimaryKeySelective(ChannelDeath record);

    int updateByPrimaryKeyWithBLOBs(ChannelDeath record);

    int updateByPrimaryKey(ChannelDeath record);

    List<ChannelDeath> selectAll();
}