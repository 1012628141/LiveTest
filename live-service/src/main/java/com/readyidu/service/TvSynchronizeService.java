package com.readyidu.service;

import com.readyidu.model.PhoneService;

import java.util.List;

public interface TvSynchronizeService {

    List<PhoneService> getCustomizeSourceList(String deviceId);
}
