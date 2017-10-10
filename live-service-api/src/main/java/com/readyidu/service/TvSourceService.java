package com.readyidu.service;

/**
 * Created by 123 on 2017/9/30.
 */
public interface TvSourceService {
    //搜索对应频道源
    String selectChannelByKey(String key);
    //获取真实源地址
    String getSource(String sourceUri);
}
