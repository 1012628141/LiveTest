package com.readyidu.mapper;

import com.readyidu.model.PhoneDevice;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ypf on 2017/12/25.
 */
public interface PhoneDeviceMapper {


    List<PhoneDevice> listByDeviceId(String deviceId);
}
