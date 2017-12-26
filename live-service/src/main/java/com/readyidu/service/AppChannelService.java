package com.readyidu.service;

import com.readyidu.model.ConfInfo;

public interface AppChannelService {

    ConfInfo selectByAcount(Integer acount);

    void insertConf(ConfInfo confInfo);

    void updateConfinfo(ConfInfo confInfo);
    int checkBinding(int account,String deviceId,String tvAlias,String appAlias);
    boolean checkUserId(int userId);
}
