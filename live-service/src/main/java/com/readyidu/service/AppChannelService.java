package com.readyidu.service;

public interface AppChannelService {
    int checkBinding(int account,String deviceId,String tvAlias,String appAlias);
    boolean checkUserId(int userId);
}
