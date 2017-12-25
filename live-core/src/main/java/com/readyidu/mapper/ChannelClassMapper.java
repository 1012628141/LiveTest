package com.readyidu.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ChannelClassMapper {
    List<String> selectAllClassName();
}
