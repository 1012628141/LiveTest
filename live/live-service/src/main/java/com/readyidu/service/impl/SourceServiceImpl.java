package com.readyidu.service.impl;

import com.readyidu.source.base.LiveManager;
import com.readyidu.service.SourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuzhang on 17/6/9.
 */

@Service("sourceService")
public class SourceServiceImpl implements SourceService {

    @Resource(name = "liveManager")
    private LiveManager liveManager;

    @Override
    public String getSource(String sourceUri) {
        if (sourceUri == null) {
            return null;
        }
        return liveManager.getChannelSource(sourceUri);
    }
}
