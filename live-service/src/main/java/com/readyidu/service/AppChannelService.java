package com.readyidu.service;

import java.util.List;

public interface AppChannelService {
    int checkBinding(int account,String deviceId,String tvAlias,String appAlias);
    boolean checkUserId(int userId);
    List<String> getSourceList(String url);
}
