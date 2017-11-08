package com.readyidu.service;

import com.readyidu.model.IpData;

/**
 * Created by 123 on 2017/10/28.
 */
public interface IpDataService {
    String SelectIpOperator(IpData ipData);
    int insertIpData(IpData ipData);
}
