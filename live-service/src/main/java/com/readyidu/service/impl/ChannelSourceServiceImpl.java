package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.readyidu.mapper.ChannelSourceMapper;
import com.readyidu.model.*;
import com.readyidu.service.BaseService;
import com.readyidu.service.CacheService;
import com.readyidu.service.ChannelSourceService;
import com.readyidu.service.MovieService;
import com.readyidu.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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

    private static final String CACHE_NAME = "channelSource_";

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
    public int reportSourceByid(Integer id) {
        return channelSourceMapper.reportSourceByid(id);
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
    public int modifySource(ChannelSource source) {return channelSourceMapper.modifySource(source);}

    @Override
    public List<ChannelSource> selectSourceByParentId(Integer id) {
        cacheService.del(SERVICE_RBK + "channel_" + "channelList");
        return channelSourceMapper.selectSourceByParentId(id);}

    @Override
    public String selectSourceById(Integer id) {
        return channelSourceMapper.selectSourceById(id);
    }
}
