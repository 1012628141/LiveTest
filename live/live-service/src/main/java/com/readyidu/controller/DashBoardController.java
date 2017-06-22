package com.readyidu.controller;

import com.readyidu.model.Channel;
import com.readyidu.service.ChannelService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping
    public ModelAndView dashBoardIndex(HttpServletRequest request) {
        String item = request.getParameter("item");
        String editId = request.getParameter("eid");
        String removeId = request.getParameter("did");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        modelAndView.addObject("navItem", getNavItemList());

        // Items selected
        if (!TextUtils.isEmpty(item)) {
            modelAndView.addObject("active", item);
            modelAndView.addObject("content", "pages/" + item + ".jsp");
            appendChannelList(modelAndView);
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
        appendChannelList(modelAndView);
        return modelAndView;
    }

    private void appendChannelList(ModelAndView modelAndView) {
        // Get living, channel data
        List<Channel> list = channelService.getChannelList();
        modelAndView.addObject("channelList", list);
        modelAndView.addObject("channelCount", list.size());

        int sourceCount = 0;
        for (Channel channel: list) {
            if (!TextUtils.isEmpty(channel.getSource())) {
                String[] s = channel.getSource().split("\\|");
                sourceCount += s.length;
            }
        }
        modelAndView.addObject("sourceCount", sourceCount);
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
        pMap.put("name", "频道分类");
        pMap.put("icon", "grid_on");
        pMap.put("items", new ArrayList<>());
        pMap.put("href", "?item=typeChannel");
        pMap.put("id", "typeChannel");
        list.add(pMap);

        return list;
    }
}
