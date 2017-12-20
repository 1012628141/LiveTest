package com.readyidu.controller;

import com.alibaba.fastjson.JSONObject;
//import com.brain.filter.HeaderFilter;
//import com.brain.model.RequestParamModel;
//import com.brain.model.rule.TVLiveRule;
//import com.brain.resolver.VersionAnnotation;
//import com.brain.util.*;
import com.readyidu.constants.NetworkCode;
import com.readyidu.filter.HeaderFilter;
import com.readyidu.pojo.RequestParamModel;
import com.readyidu.service.TvSourceService;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import com.readyidu.util.Platform;
import com.readyidu.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 电视相关接口
 * Created by lhx on 2017/10/12.
 *
 */
@Controller
public class TvLiveController {

    private final TvSourceService tvSourceService;

    @Autowired
    public TvLiveController(TvSourceService tvSourceService) {
        this.tvSourceService = tvSourceService;
    }

    /**
     * 获取电视频道分类列表
     *
     */
    @RequestMapping(value = {"/getChannelTypeList", "/{liveRule}" + "/getChannelTypeList"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelTypeList() {
        String jsonString = tvSourceService.channelType();
        return getResult(jsonString);
    }

    /**
     * 获取电视频道列表
     *
     */
    @RequestMapping(value = {"/getChannelList", "/{liveRule}"  + "/getChannelList"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelList() {
        RequestParamModel requestParamModel = HeaderFilter.paramModel.get();
        String jsonString;
        if (requestParamModel.getVersion() >= Version.V113 && (Platform.TV.equalsIgnoreCase(requestParamModel.getPlatform())))
            jsonString = tvSourceService.selectTvChannelList(requestParamModel.getPlatform());
        else if (requestParamModel.getVersion() >= Version.V113 && (Platform.ANDROID.equalsIgnoreCase(requestParamModel.getPlatform())
                || Platform.IOS.equalsIgnoreCase(requestParamModel.getPlatform())))
            jsonString = tvSourceService.getTypeList(requestParamModel.getLocationId());
        else if (requestParamModel.getVersion() > Version.V111 && requestParamModel.getVersion() <= Version.V112)
            jsonString = tvSourceService.getChannelList(requestParamModel.getPlatform());
        else
            jsonString = tvSourceService.getChannelList();
        return getResult(jsonString);
    }


    /**
     * 获取真实源地址
     *
     * @param sourceUri 自定义的源地址("sourceUri://**")
     */
    @RequestMapping(value = {"/getSourceUrl", "/{liveRule}" + "/getSourceUrl"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getSourceUrl(String sourceUri) {
        String jsonString = tvSourceService.getSourceByIp(sourceUri, HeaderFilter.paramModel.get().getRemoteHost());
        return getResult(jsonString);
    }


    /**
     * 搜索对应频道源
     *
     * @param tvName 的频道名
     */
    @RequestMapping(value = {"/getSourceListByTvName", "/{liveRule}" + "/getSourceListByTvName"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getSourceListByTvName(String tvName) {
        String jsonString = tvSourceService.selectChannelInfoByKey(tvName);
        return getResult(jsonString);
    }

    /**
     * 获取频道节目单
     *
     * @param channelId 的频道id
     */
    @RequestMapping(value = {"/getChannelPlaybill", "/{liveRule}"  + "/getChannelPlaybill"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelPlaybill(String channelId) {
        String jsonString = tvSourceService.channelPlaybill(channelId);
        return getResult(jsonString);
    }

    /**
     * 当源播放失效时，通过调用该方法上报
     *
     * @param source 的频道id
     */
    @RequestMapping(value = {"/insertReport", "/{liveRule}" + "/insertReport"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertReport(String source) {
        String jsonString = tvSourceService.insertReport(source);
        return getResult(jsonString);
    }

    /**
     * 上报直播源
     *
     * @param sourceId 的频道id
     */
    @RequestMapping(value = {"/insertReportLive", "/{liveRule}" + "/insertReportLive"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertReportLive(Integer sourceId, Boolean isLive) {
        String jsonString = tvSourceService.insertReport(sourceId, isLive);
        return getResult(jsonString);
    }


    /**
     * 获取点播地址
     *
     * @param id 的频道id
     */
    @RequestMapping(value = {"/getDemandById", "/{liveRule}" + "/getDemandById"}, method = RequestMethod.GET
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getDemandById(Integer id) {
        if (id == null) {
            return JsonResult.toString(NetworkCode.CODE_TIME_OUT, null);
        }
        String jsonString = tvSourceService.getDemandById(id, HeaderFilter.paramModel.get().getRemoteHost());
        return getResult(jsonString);
    }

    /**
     * 获取直播播地址
     *
     * @param id 的频道id
     */
    @RequestMapping(value = {"/getSourceById", "/{liveRule}" + "/getSourceById"}, method = RequestMethod.GET
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getSourceById(Integer id) {
        if (id == null) {
            return JsonResult.toString(NetworkCode.CODE_TIME_OUT, null);
        }
        String jsonString = tvSourceService.getSourceById(id, HeaderFilter.paramModel.get().getRemoteHost());
        return getResult(jsonString);
    }

    /**
     * app端根据typeid获取频道列表以及节目表
     *
     * @param typeId 频道分类ID
     * @param id     定位的所在区域的id
     */
    @RequestMapping(value = {"/getNewChannelListByTypeId", "/{liveRule}" + "/getNewChannelListByTypeId"}, method = RequestMethod.GET
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getNewChannelListByTypeId(String typeId) {
        if ("".equals(typeId) || typeId == null) {
            return JsonResult.toString(NetworkCode.CODE_TIME_OUT, null);
        }
        String jsonString = tvSourceService.getNewChannelListByTypeId(typeId, HeaderFilter.paramModel.get().getLocationId());
        return getResult(jsonString);
    }


    /**
     * 新增按sort排序的频道分类接口
     *
     */
    @RequestMapping(value = {"/getTypeList", "/{liveRule}"  + "/getTypeList"}, method = RequestMethod.GET
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getTypeList() {
        String jsonString = tvSourceService.getTypeList(HeaderFilter.paramModel.get().getLocationId());
        return getResult(jsonString);
    }

    /**
     * app端通过key搜索频道源
     *
     * @param key 语音的频道识别结果
     */
    @RequestMapping(value = {"/selectNewChannelInfoByKey", "/{liveRule}"  + "/selectNewChannelInfoByKey"}, method = RequestMethod.GET
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectNewChannelInfoByKey(String key) {
        if (NullUtil.isNullObject(key)) {
            return JsonResult.toString(NetworkCode.CODE_TIME_OUT, "电视剧名称不能为空");
        }
        String jsonString = tvSourceService.selectNewChannelInfoByKey(key);
        return getResult(jsonString);
    }


    /**
     * app端根据电视剧id返回电视剧集
     *
     * @param channelId 电视剧频道id
     * @return json (code: 200 成功,400 参数错误,10000 服务出错;data:[{channel:{@link com.readyidu.model.NewChannel}}])
     */
    @RequestMapping(value = {"/selectTvShowByChannelId", "/{liveRule}"  + "/selectTvShowByChannelId"}, method = RequestMethod.GET
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectTvShowByChannelId(Integer channelId) {
        if (NullUtil.isNullObject(channelId)) {
            return JsonResult.toString(NetworkCode.CODE_TIME_OUT, "电视剧id不能为空");
        }
        String jsonString = tvSourceService.selectTvShowByChannelId(channelId);
        return getResult(jsonString);
    }


    private String getResult(String jsonString) {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        if (jsonObject == null || jsonObject.getOrDefault("code", 0).equals(10000)) {
            return JsonResult.toString( NetworkCode.CODE_SUCCESS_NULL, null);
        } else {
            jsonObject.put("errorCode", jsonObject.getOrDefault("code", NetworkCode.ERROR_CODE_400));
            jsonObject.put("errorMessage", jsonObject.getOrDefault("message", null));
        }
        return jsonObject.toJSONString();
    }


}
