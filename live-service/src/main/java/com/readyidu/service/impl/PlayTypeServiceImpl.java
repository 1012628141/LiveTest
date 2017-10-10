package com.readyidu.service.impl;

import com.readyidu.mapper.PlayTypeMapper;
import com.readyidu.service.PlayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2017/10/10.
 */
@Service("playTypeService")
public class PlayTypeServiceImpl implements PlayTypeService {

    @Autowired
    private PlayTypeMapper playTypeMapper;
    @Override
    public int getPlayType() {
        return playTypeMapper.getPlayType();
    }
}
