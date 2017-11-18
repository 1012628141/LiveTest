package com.readyidu.mapper;

import com.readyidu.model.LunBoBillFrom;

import java.util.List;

public interface LunBoFromMapper {
    List<LunBoBillFrom> getFromByChannelId(Integer ChannelId);
}
