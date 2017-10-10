package com.readyidu.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 123 on 2017/9/30.
 */
public interface TvSourceService {
    String selectChannelByKey(String key);
    String getSource(String sourceUri);
}
