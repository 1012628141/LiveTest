package com.readyidu.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readyidu.constants.NetworkCode;
import com.readyidu.service.ChannelService;
import com.readyidu.service.LunBoFromService;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;
import com.readyidu.service.TvSourceService;
import com.readyidu.tools.JPushTool;
import com.readyidu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/channel")
public class ChannelController {
    private static final String MASTER_SECRET="ae03c3cd69069d05f04a0290";
    private static final String APP_KEY="e27c9e82155e29b33d01a9e3";

    private static final String MESSAGE="直播缓存失效";

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Autowired
    private LunBoFromService lunBoFromService;



    @RequestMapping(value = "/channel.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannel(HttpServletRequest request,
                             HttpServletResponse response) {
        try {
            List<Channel> channelInfoList = channelService
                    .getChannelList();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoList);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
    @RequestMapping(value = "/channelType.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelType(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            List<ChannelType> channelInfoType = channelService
                    .getChannelType();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoType);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
    @RequestMapping(value = "/channel.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postChannel(HttpServletRequest request,
                              HttpServletResponse response) {
        try {
            List<Channel> channelInfoList = channelService
                    .getChannelList();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoList);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }

    @RequestMapping(value = "/channelType.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postChannelType(HttpServletRequest request,
                                  HttpServletResponse response) {
        try {
            List<ChannelType> channelInfoType = channelService
                    .getChannelType();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoType);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
    @RequestMapping(value = "/mapCacheExpire.do",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String mapCacheExpire(){
        try {
            JPushTool.sendPush(MASTER_SECRET,APP_KEY,MESSAGE,NetworkCode.CACHE_EXPIRE);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
        }
        catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
//    @RequestMapping(value = "channelInfoById")
//    @ResponseBody
//    public String channelInfoById(HttpServletRequest request){
//        try {
//            String channelId = request.getParameter("channelId");
//            Channel channel = channelService.selectChannelById(Integer.valueOf(channelId));
//            return JsonResult.toString(NetworkCode.CODE_SUCCESS,channel);
//        }catch (Exception e){
//            return null;
//        }
//    }
    @RequestMapping(value = "/channelPlaybill.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String channelPlaybill(HttpServletRequest request){
        try {
            String channelId = request.getParameter("channelId");
            Map<String, Object> playBill = channelService.channelPlaybill(channelId);

            return JsonResult.toString(NetworkCode.CODE_SUCCESS,playBill);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
    @RequestMapping(value = "/lunboPlaybill.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String lunboPlaybill(Integer channelId){
        try{
            if (lunBoFromService.refreshChannelBill(channelId)){
                return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
            }
            return JsonResult.toString(NetworkCode.ERROR_CODE_400,"");
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
    @RequestMapping(value = "/checkLunboBill.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkLunboBill(Integer channelId,String fileName){
        try{
            if (lunBoFromService.checkLunboBill(channelId,fileName)){
                return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
            }
            return JsonResult.toString(NetworkCode.ERROR_CODE_400,"");
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
    @RequestMapping(value = "/channelTypeBySort.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChannelTypeBySort(HttpServletRequest request,
                                 HttpServletResponse response) {
        try {
            List<ChannelType> channelInfoType = channelService
                    .getTypeList();
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, channelInfoType);
        } catch (Exception e) {
            return JsonResult.toString(NetworkCode.CODE_FAIL, "");
        }
    }
}