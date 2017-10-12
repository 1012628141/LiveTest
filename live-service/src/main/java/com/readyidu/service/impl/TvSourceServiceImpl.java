package com.readyidu.service.impl;

import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;
import com.readyidu.model.RouterMapping;
import com.readyidu.model.Source;
import com.readyidu.service.*;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/9/30.
 */
public class TvSourceServiceImpl extends BaseService implements TvSourceService {
    @Resource(name = "channelMapper")
    private ChannelMapper channelMapper;

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "routerService")
    private RouterService routerService;

    @Resource(name = "sourceService")
    SourceService sourceService;

    @Override
    public String selectChannelByKey(String key) {
        try {
            Channel channel = channelService.selectChannelByKey(key);
            channel.setSources(channel.getSource().split("\\|"));
            channel.setSource(null);
            if (NullUtil.isNullObject(channel)) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channel);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getSource(String sourceUri) {
        try {
            String source = sourceService.getSource(sourceUri);
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, new Source(source));
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getChannelList() {
        try {
            List<Channel> channelList = channelService.getChannelList();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,channelList);
        }catch (Exception e)
        {
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

    @Override
    public String channelPlaybill(String channelId) {
        try {
            Map<String, Object> playBill = channelService.channelPlaybill(channelId);
            if (NullUtil.isNullObject(playBill))
            {
                return JsonResult.toString(NetworkCode.ERROR_CODE_400,playBill);
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,playBill);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }

//    @Override
//    public String getMapperList() {
//        try {
//            List<RouterMapping> routerMappings = routerService.selectAll();
//            return JsonResult.toString(NetworkCode.CODE_SUCCESS,routerMappings);
//        }catch (Exception e){
//            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
//        }
//    }

    @Override
    public String channelType() {
        try {
            List<ChannelType> channelTypeList = channelService.getChannelType();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,channelTypeList);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
}
