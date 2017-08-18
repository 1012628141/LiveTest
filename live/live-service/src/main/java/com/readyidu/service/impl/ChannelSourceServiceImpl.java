package com.readyidu.service.impl;

import com.readyidu.mapper.ChannelSourceMapper;
import com.readyidu.model.ChannelSource;
import com.readyidu.model.CheckableChannel;
import com.readyidu.model.Source;
import com.readyidu.service.BaseService;
import com.readyidu.service.CacheService;
import com.readyidu.service.ChannelSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 123 on 2017/7/26.
 */
@Service("channelSourceService")
public class ChannelSourceServiceImpl extends BaseService implements ChannelSourceService {
    @Autowired
    private ChannelSourceMapper channelSourceMapper;

    @Autowired
    private CacheService cacheService;
    @Override
    public void importData(ChannelSource channelSource) {
        channelSourceMapper.importData(channelSource);
    }

    @Override
    public List<CheckableChannel> selectDeathSource() {
        return channelSourceMapper.selectDeathSource();
    }

    @Override
    public int delectSourceByid(Integer id) {
        return channelSourceMapper.delectSourceByid(id);
    }

    @Override
    public int updateIsDelete(String source) {
        return channelSourceMapper.updateIsDelete(source);
    }

    @Override
    public int reductionSourceByid(Integer id) {
        return channelSourceMapper.reductionSourceByid(id);
    }

    @Override
    public ChannelSource getDeathBySource(String source) {
        return channelSourceMapper.getDeathBySource(source);
    }

    @Override
    public int updateSort(ChannelSource source) { return channelSourceMapper.updateSort(source);}

    @Override
    public List<ChannelSource> selectSourceByParentId(Integer id) {
        cacheService.del(SERVICE_RBK + "channel_" + "channelList");
        return channelSourceMapper.selectSourceByParentId(id);}
}
