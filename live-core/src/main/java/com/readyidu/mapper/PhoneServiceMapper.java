package com.readyidu.mapper;

import com.readyidu.model.PhoneService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ypf on 2017/12/25.
 */
@Component
public interface PhoneServiceMapper {
    List<PhoneService> getConfUrlAndUserIdByDeviceId(String deviceId);

}
