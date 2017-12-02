package com.readyidu.mapper;

import com.readyidu.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LunBoFromMapper {
    List<LunBoBillFrom> getFromByChannelId(Integer channelId);

    List<LunBoBillFrom> selectFromByChannelId();

    List<Channel> selectIntoChannel();
    String selectDemandById(Integer id);
    int reportDemand(Integer id);
    List<LunBoBillFrom> selectFileByChannelId(Integer channelId);
    List<NewChannel>selectDemandByTypeId(Integer typeid);
    List<NewChannel>selectTvShowByChannelId(Integer channelId);
}
