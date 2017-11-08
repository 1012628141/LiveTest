package com.readyidu.service.impl;

import com.readyidu.mapper.IpDataMapper;
import com.readyidu.model.IpData;
import com.readyidu.service.IpDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2017/10/28.
 */
@Service("ipDataService")
public class IpDataServiceImpl implements IpDataService {

    @Autowired
    private IpDataMapper ipDataMapper;

    @Override
    public String SelectIpOperator(IpData ipData) {return ipDataMapper.SelectIpOperator(ipData);}

    @Override
    public int insertIpData(IpData ipData) {return ipDataMapper.insertIpData(ipData);}
}
