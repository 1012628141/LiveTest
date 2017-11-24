package com.readyidu.mapper;

import com.readyidu.model.Channel;
import com.readyidu.model.LunBoBillFrom;
import com.readyidu.model.Source;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LunBoFromMapper {
    List<LunBoBillFrom> getFromByChannelId(Integer channelId);

    List<LunBoBillFrom> selectFromByChannelId();

    List<Channel> selectIntoChannel();
    String selectDemandById(Integer id);
    List<LunBoBillFrom> selectFileByChannelId(Integer channelId);
}
