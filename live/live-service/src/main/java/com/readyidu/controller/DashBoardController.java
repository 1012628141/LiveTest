package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.readyidu.constants.NetworkCode;
import com.readyidu.model.*;
import com.readyidu.service.*;
import com.readyidu.util.JsonResult;
import com.readyidu.util.PageUtil;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 2017/6/16
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/")
public class DashBoardController {

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "deathChannelService")
    DeathChannelService deathChannelService;

    @Resource(name = "routerService")
    RouterService routerService;

    @Resource(name = "cacheService")
    CacheService cacheService;
    @Resource(name = "channelSourceService")
    ChannelSourceService channelSourceService;

    private String channelCacheName="channel_list_";

    @RequestMapping("check")
    public  ModelAndView chick(){
        return new ModelAndView("streamMedia");
    }

    @RequestMapping
    public ModelAndView dashBoardIndex(HttpServletRequest request) {
        String item = request.getParameter("item");
        String editId = request.getParameter("eid");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        modelAndView.addObject("navItem", getNavItemList());

        // 打开了客户端的Mapping处理
        if (!TextUtils.isEmpty(item) && item.equals("typeChannel")) {
            List<RouterMapping> list = routerService.selectAll();
            PageUtil pageUtil = new PageUtil(1,list.size());
            modelAndView.addObject("active", item);
            modelAndView.addObject("pageNo",pageUtil.getPageNo());
            modelAndView.addObject("pageCount",pageUtil.getPageCount());
            modelAndView.addObject("content", "pages/" + item + ".jsp");
            modelAndView.addObject("routerMaps", list.subList(0, 20));
            return modelAndView;
        }
//        //Show alarm
//        if(!TextUtils.isEmpty(item) && item.equals("alarmChannel")){
//            modelAndView.addObject("active", item);
//            modelAndView.addObject("content", "pages/" + item + ".jsp");
//            modelAndView.addObject("","");
//            return modelAndView;,
//        }
        // Items selected
        if (!TextUtils.isEmpty(item)) {
            modelAndView.addObject("active", item);
            modelAndView.addObject("content", "pages/" + item + ".jsp");
            appendChannelList(modelAndView,request);
            return modelAndView;
        }

        // Edit item
        if (!TextUtils.isEmpty(editId)) {
            modelAndView.setViewName("pages/editChannel");

            // Get channel data
            modelAndView.addObject("channel", channelService.getChannel(Integer.valueOf(editId)));
            return modelAndView;
        }

        // Default back main page
        modelAndView.addObject("active", "statistic");
        modelAndView.addObject("content", "pages/statistic.jsp");
        appendChannelList(modelAndView,request);
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "pageLoad.do", produces = "application/json; charset=utf-8")
    public String pageLoad(HttpServletRequest request){
        String pageNo=request.getParameter("pageno");
        if(pageNo==null||"".equals(pageNo)){
            return JsonResult.toString(NetworkCode.CODE_FAIL,null);
        }
        List<Channel> list=new ArrayList<>();
        list = channelService.getChannelList();
        PageUtil pageUtil = new PageUtil(Integer.parseInt(pageNo),list.size());
        List<Channel> resultList = list.subList(pageUtil.getPageMin(), pageUtil.getPageMax());
        pageUtil.setChannelList(resultList);
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,resultList);
    }
    @ResponseBody
    @RequestMapping(value = "pageDeathLoad.do", produces = "application/json; charset=utf-8")
    public String pageDeathLoad(HttpServletRequest request){
        String pageNo=request.getParameter("pageno");
        if(pageNo==null||"".equals(pageNo)){
            return JsonResult.toString(NetworkCode.CODE_FAIL,null);
        }
        List<CheckableChannel> list=new ArrayList<>();
        list = (List<CheckableChannel>) request.getSession().getAttribute("checkableChannels");
        if (list==null||list.size()==0){
            return JsonResult.toString(NetworkCode.CODE_TIME_OUT,null);
        }
        PageUtil pageUtil = new PageUtil(Integer.parseInt(pageNo),list.size());
        List<CheckableChannel> resultList = list.subList(pageUtil.getPageMin(), pageUtil.getPageMax());
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,resultList);
    }
    @ResponseBody
    @RequestMapping(value = "pageMapLoad.do", produces = "application/json; charset=utf-8")
    public String pageMapLoad(HttpServletRequest request){
        String pageNo=request.getParameter("pageno");
        if(pageNo==null||"".equals(pageNo)){
            return JsonResult.toString(NetworkCode.CODE_FAIL,null);
        }
        List<RouterMapping> list=new ArrayList<>();
        list = routerService.selectAll();
        PageUtil pageUtil = new PageUtil(Integer.parseInt(pageNo),list.size());
        List<RouterMapping> resultList = list.subList(pageUtil.getPageMin(), pageUtil.getPageMax());
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,resultList);
    }
    @ResponseBody
    @RequestMapping("importData")
    public boolean importData(){
        List<Channel> list=channelService.getChannelList();
        if (list.size()==0) {
            return false;
        }
        int c=0;
        System.out.println(list.size());
        for (Channel channel:list) {
            System.out.println(channel.getSource());
            String[] sourceList = channel.getSource().split("\\|");
            c+=sourceList.length;
            for (String source:
                    sourceList) {
                System.out.println(source);
                ChannelSource channelSource = new ChannelSource();
                channelSource.setParentid(channel.getId());
                channelSource.setSource(source);
                channelSourceService.importData(channelSource);
            }
        }
        System.out.println(c);
        return true;
    }
    private void appendChannelList(ModelAndView modelAndView,HttpServletRequest request) {
        // Get living, channel data
        List<Channel> list = channelService.getChannelList();
        PageUtil pageUtil = new PageUtil(1,list.size());
//        pageUtil.setPageNo((pageNo    ==null)?1:Integer.parseInt(pageNo));
        List<Channel> resultList = list.subList(0, 20);
        modelAndView.addObject("channelList", resultList);
        modelAndView.addObject("channelCount", list.size());
        modelAndView.addObject("pageNo",pageUtil.getPageNo());
        modelAndView.addObject("pageCount",pageUtil.getPageCount());
        int sourceCount = 0;
        for (Channel channel: list) {
            if (!TextUtils.isEmpty(channel.getSource())) {
                String[] s = channel.getSource().split("\\|");
                sourceCount += s.length;
            }
        }
        modelAndView.addObject("sourceCount", sourceCount);
        List<CheckableChannel> checkableChannels = deathChannelService.checkDeathChannel();
        request.getSession().setAttribute("checkableChannels",checkableChannels);
        modelAndView.addObject("deathList", checkableChannels.subList(0, 20));
    }

    private List<Map<String, Object>> getNavItemList() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> tMap = new HashMap<>();
        tMap.put("name", "统计数据");
        tMap.put("icon", "dashboard");
        tMap.put("items", new ArrayList<>());
        tMap.put("href", "/");
        tMap.put("id", "statistic");
        list.add(tMap);

        Map<String, Object> zMap = new HashMap<>();
        zMap.put("name", "直播频道");
        zMap.put("icon", "apps");
        zMap.put("items", new ArrayList<>());
        zMap.put("href", "?item=livingChannel");
        zMap.put("id", "livingChannel");
        list.add(zMap);

        Map<String, Object> aMap = new HashMap<>();
        aMap.put("name", "频道检测");
        aMap.put("icon", "done all");
        aMap.put("href", "?item=checkChannel");
        aMap.put("items", new ArrayList<>());
        aMap.put("id", "checkChannel");
        list.add(aMap);

        Map<String, Object> pMap = new HashMap<>();
        pMap.put("name", "对照表");
        pMap.put("icon", "grid_on");
        pMap.put("items", new ArrayList<>());
        pMap.put("href", "?item=typeChannel");
        pMap.put("id", "typeChannel");
        list.add(pMap);

        return list;
    }
}
