package com.readyidu.service.impl;

import com.readyidu.mapper.ChannelSourceMapper;
import com.readyidu.model.ChannelSource;
import com.readyidu.service.BaseService;
import com.readyidu.service.ChannelSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2017/7/26.
 */
@Service("channelSourceService")
public class ChannelSourceServiceImpl extends BaseService implements ChannelSourceService {
    @Autowired
    private ChannelSourceMapper channelSourceMapper;
    @Override
    public void importData(ChannelSource channelSource) {
        channelSourceMapper.importData(channelSource);
    }
}
