package com.readyidu.service;

import com.readyidu.model.PlayBillInfo;

import java.util.List;

/**
 * Created by ypf on 2017/12/21.
 */
public interface PlayBillInfoService {
    List<PlayBillInfo> selectBillProgramByChannelId(Integer channelId);
}
