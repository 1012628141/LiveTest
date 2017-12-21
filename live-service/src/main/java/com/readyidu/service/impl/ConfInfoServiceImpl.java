package com.readyidu.service.impl;

import com.readyidu.mapper.ConfInfoMapper;
import com.readyidu.model.ConfInfo;
import com.readyidu.service.ConfInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2017/12/18.
 */
@Service("confInfoService")
public class ConfInfoServiceImpl implements ConfInfoService {

    @Autowired
    private ConfInfoMapper confInfoMapper;
    @Override
    public ConfInfo selectChannelInfo(Integer version) {
        return confInfoMapper.selectChannelInfo(version);
    }
}
