package com.readyidu.mapper;

import com.readyidu.model.BillFromInfo;

/**
 * Created by 123 on 2017/9/22.
 */
public interface BillFromMapper {
    BillFromInfo selectBillFromInfoByChannelId(Integer channelId);
}
