package com.readyidu.mapper;

import com.readyidu.model.RouterMapping;

import java.util.List;

/**
 * 2017/7/5
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public interface RouterMappingMapper {
    int deleteById(Integer id);
    int insert(RouterMapping record);
    int update(RouterMapping record);

    RouterMapping selectById(Integer id);
    List<RouterMapping> selectByValue(String value);
    List<RouterMapping> selectAll();
    List<RouterMapping> selectByKey(String key);
    /**
     * 后台分页查询
     * @param pageNo
     * @return
     */
    List<RouterMapping> selectByPageNo(Integer pageNo);

    /**
     * 通过key精确搜索
     * @param key
     * @return
     */
    List<RouterMapping> selectExactByKey(String key);
}
