package com.readyidu.mapper;

import com.readyidu.model.ChannelSource;
import com.readyidu.model.CheckableChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 123 on 2017/7/26.
 */
public interface ChannelSourceMapper {
    int importData(ChannelSource channelSource);
    int delectSourceByid(Integer id);
        int reportSourceByid(Integer id);
    List<ChannelSource> selectSourceByParentId(Integer id);
    List<CheckableChannel> selectDeathSource();
    int updateIsDelete(String source);
    int reductionSourceByid(Integer id);
    ChannelSource getDeathBySource(String source);
    int updateSort(ChannelSource channelSource);
    int countSourceByParentId(Integer id);
    int modifySource(ChannelSource source);
    int updateSourceDeleteFlag(@Param("parentId")Integer parentId, @Param("sourceId")Integer sourceId);
    String selectSourceById(Integer id);
}
