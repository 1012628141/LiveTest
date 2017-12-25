package com.readyidu.mapper;

import com.readyidu.model.ChannelType;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ChannelTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelType record);

    int insertSelective(ChannelType record);

    ChannelType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelType record);

    int updateByPrimaryKey(ChannelType record);

    List<ChannelType> selectAll();

    List<ChannelType> getTypeList();

    String getTypeById(Integer id);

    Integer getCategoryById(Integer id);
}