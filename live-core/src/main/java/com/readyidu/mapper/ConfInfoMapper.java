package com.readyidu.mapper;

import com.readyidu.model.ConfInfo;
import org.springframework.stereotype.Component;

/**
 * Created by 123 on 2017/12/18.
 */
@Component
public interface ConfInfoMapper {
    ConfInfo selectChannelInfo(String version);
    int updateConfinfo(ConfInfo confInfo);
    ConfInfo selectByAcount(String acount);
    void insertConf(ConfInfo confInfo);
    void updateConfinfoByAcount(ConfInfo confInfo);
}
