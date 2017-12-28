package com.readyidu.service;

import com.readyidu.model.ConfInfo;

public interface AppChannelService {

    ConfInfo selectByAcount(Integer acount);

    void insertConf(ConfInfo confInfo);

    void updateConfinfo(ConfInfo confInfo);
    int checkBinding(int account,String TvDeviceId);
    boolean checkUserId(int userId);
    String getSourceList(String url);

    /*判定用户是否绑定  如果绑定获取自定义源*/
    String checkByUserId(int userId);
    void updateDefinedName(int userId,String definedName);
}
