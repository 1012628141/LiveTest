package com.readyidu.mapper;

import com.readyidu.model.lunBoBillFrom;

import java.util.List;

public interface lunBoFromMapper {
    List<lunBoBillFrom> getFromByChannelId(Integer ChannelId);
}
