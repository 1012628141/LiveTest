package com.readyidu.service.impl;

import com.readyidu.mapper.ChannelSourceMapper;
import com.readyidu.model.Source;
import com.readyidu.service.CacheService;
import com.readyidu.source.base.LiveManager;
import com.readyidu.service.SourceService;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.NullUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuzhang on 17/6/9.
 */

@Service("sourceService")
public class SourceServiceImpl implements SourceService {

    @Resource(name = "liveManager")
    private LiveManager liveManager;
    @Resource(name = "cacheService")
    CacheService cacheService;

    private static final int CHACHE_TIMEOUT = 1800;

    @Override
    public String getSource(String sourceUri) {
        if (sourceUri == null) {
            return null;
        }
        String source = cacheService.get(sourceUri);
        if (!NullUtil.isNullObject(source)) {
            return source;
        }
        source = liveManager.getChannelSource(sourceUri);
        if (!NullUtil.isNullObject(source)) {
            cacheService.set(sourceUri, source, CHACHE_TIMEOUT);
        }
        return source;
    }
}
