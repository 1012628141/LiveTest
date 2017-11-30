package com.readyidu.service;


import com.readyidu.model.Channel;
import com.readyidu.model.NewChannel;
import com.readyidu.model.NewDemand;

import java.util.List;
import java.util.Map;

public interface LunBoFromService {

    boolean refreshChannelBill(Integer channelId);

    String getDemandListByChannelId( );
    List<Channel> getDemandList();

    Map<String, Object> getChannelBill(Integer channelId);
    String selectDemandById(Integer id);
    int reportDemand(Integer id);
    boolean checkLunboBill(Integer channelId,String fileName);
}
