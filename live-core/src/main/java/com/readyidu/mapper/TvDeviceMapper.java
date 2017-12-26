package com.readyidu.mapper;

import com.readyidu.model.TvDevice;
import org.springframework.stereotype.Component;

/**
 * Created by ypf on 2017/12/25.
 */
public interface TvDeviceMapper {

    TvDevice getByDeviceId(String deviceId);

    int insertTvDevice(TvDevice tvDevice);
}