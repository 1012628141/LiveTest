package com.readyidu.mapper;

import com.readyidu.model.LunBoBillFrom;
import org.springframework.stereotype.Component;

import java.util.List;

public interface LunBoFromMapper {
    List<LunBoBillFrom> getFromByChannelId(Integer ChannelId);

    List<LunBoBillFrom> selectFromByChannelId(Integer ChannelId);
}
