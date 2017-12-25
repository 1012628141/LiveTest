package com.readyidu.mapper;

import com.readyidu.model.IpData;
import org.springframework.stereotype.Component;

/**
 * Created by 123 on 2017/10/28.
 */
@Component
public interface IpDataMapper {
    String SelectIpOperator(IpData ipData);
    int insertIpData(IpData ipData);
}
