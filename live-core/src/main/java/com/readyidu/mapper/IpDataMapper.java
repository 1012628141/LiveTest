package com.readyidu.mapper;

import com.readyidu.model.IpData;

/**
 * Created by 123 on 2017/10/28.
 */
public interface IpDataMapper {
    String SelectIpOperator(IpData ipData);
    int insertIpData(IpData ipData);
}
