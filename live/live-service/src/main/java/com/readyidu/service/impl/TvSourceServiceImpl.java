package com.readyidu.service.impl;

import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.Channel;
import com.readyidu.model.RouterMapping;
import com.readyidu.model.Source;
import com.readyidu.service.ChannelService;
import com.readyidu.service.RouterService;
import com.readyidu.service.SourceService;
import com.readyidu.service.TvSourceService;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/9/30.
 */
public class TvSourceServiceImpl implements TvSourceService {
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
            Map<String,Object> channelObj = new HashMap<>();
            channelObj.put("channel",channel.getChannel());
            channelObj.put("id",channel.getId());
            channelObj.put("source", channel.getSource().split("\\|"));
            if (NullUtil.isNullObject(channel)) {
                return JsonResult.toString(NetworkCode.CODE_FAIL, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelObj);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @Override
    public String getSource(String sourceUri) {
        try {
            String source = sourceService.getSource(sourceUri);
            if (NullUtil.isNullObject(source)) {
                return JsonResult.toString(NetworkCode.CODE_FAIL, "");
            }
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, new Source(source));
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
}
