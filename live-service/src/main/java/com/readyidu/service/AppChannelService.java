package com.readyidu.service;

import com.readyidu.model.ConfInfo;

public interface AppChannelService {
    String checkBinding(int account,String deviceId);

    ConfInfo selectByAcount(Integer acount);

    void insertConf(ConfInfo confInfo);

    void updateConfinfo(ConfInfo confInfo);
}
