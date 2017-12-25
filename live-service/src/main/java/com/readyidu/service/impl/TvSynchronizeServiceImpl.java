package com.readyidu.service.impl;

import com.readyidu.mapper.PhoneDeviceMapper;
import com.readyidu.model.PhoneDevice;
import com.readyidu.service.TvSynchronizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TvSynchronizeServiceImpl implements TvSynchronizeService{
    @Autowired
    private PhoneDeviceMapper phoneDeviceMapper;
    @Transactional
    @Override
    public void insertPhoneDevice(PhoneDevice phoneDevice) {
        phoneDeviceMapper.insertDevice(phoneDevice);
    }
}
