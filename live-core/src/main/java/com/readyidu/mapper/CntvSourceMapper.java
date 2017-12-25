package com.readyidu.mapper;

import org.springframework.stereotype.Component;

@Component
public interface CntvSourceMapper {
    String findByChannelName(String channel_name);
}
