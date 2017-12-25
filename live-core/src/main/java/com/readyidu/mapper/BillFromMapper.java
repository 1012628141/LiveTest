package com.readyidu.mapper;

import com.readyidu.model.BillFromInfo;
import org.springframework.stereotype.Component;

/**
 * Created by 123 on 2017/9/22.
 */
@Component
public interface BillFromMapper {
    BillFromInfo selectBillFromInfoByChannelId(Integer channelId);
}
