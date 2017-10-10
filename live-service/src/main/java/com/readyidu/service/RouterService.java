package com.readyidu.service;

import com.readyidu.model.RouterMapping;

import java.util.List;

/**
 * 2017/7/5
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public interface RouterService {
    int deleteById(Integer id);
    int insert(RouterMapping record);
    int update(RouterMapping record);

    RouterMapping selectById(Integer id);
    List<RouterMapping> selectByValue(String value);
    List<RouterMapping> selectAll();
    RouterMapping selectByKey(String key);
    List<RouterMapping> selectByPageNo(Integer pageNo);
}
