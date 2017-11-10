package com.readyidu.service;

import com.readyidu.model.RouterMapping;

import java.util.List;
import java.util.Map;

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
    List<RouterMapping> selectByKey(String key);
    List<RouterMapping> selectByPageNo(Integer pageNo);

    /**
     * 通过key精确搜索
     * @param key
     * @return
     */
    List<RouterMapping> selectExactByKey(String key);
    List<String> selectMenu(Integer number);
    List<Map>  selectForm(String TvName,Integer form);
    List<Map>  selectColumn(String search);

}
