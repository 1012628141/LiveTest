package com.readyidu.controller;

import com.alibaba.fastjson.JSON;
import com.readyidu.constants.NetworkCode;
import com.readyidu.model.RouterMapping;
import com.readyidu.service.ChannelSourceService;
import com.readyidu.service.RouterService;
import com.readyidu.tools.JPushTool;
import com.readyidu.util.JsonResult;
import org.apache.commons.collections.MultiMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017/7/5
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/router/channel/")
public class RouterMapController {
    private static final String MASTER_SECRET="a207b7daaf776cfe3764d01b";
    private static final String APP_KEY="a9a36f92c045166a8219eece";
    private static final String MESSAGE="命令映射缓存失效";

    @Resource(name = "routerService")
    RouterService routerService;

    @Resource(name = "channelSourceService")
    ChannelSourceService channelSourceService;

    // 客户端获取全部Mapping的地方
    @RequestMapping(value = "getMapper.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllChannelMap() {
        List<RouterMapping> routerMappings = routerService.selectAll();

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<RouterMapping> mappers = new ArrayList<>();
        for (RouterMapping mapping: routerMappings) {
            if (mapping.getKey().endsWith("电视台")) {
                strings.add(mapping.getKey().substring(0, mapping.getKey().length() - "电视台".length()));
            }
        }

        for (RouterMapping mapping: routerMappings) {
            for (String prefix: strings) {
                if (mapping.getKey().startsWith(prefix)) {
                    RouterMapping routerMapping = new RouterMapping();
                    routerMapping.setKey(prefix + "电视台");
                    routerMapping.setValue(mapping.getValue());
                    mappers.add(routerMapping);
                }
            }
        }

        routerMappings.addAll(mappers);

        return JsonResult.toString(NetworkCode.CODE_SUCCESS, routerMappings);
    }

    @RequestMapping(value = "removeMapper.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String removeMapper(HttpServletRequest request) {
        if (routerService.deleteById(Integer.valueOf(request.getParameter("id"))) != 0) {
            return JsonResult.toString(NetworkCode.CODE_SUCCESS, "");
        }
        return JsonResult.toString(NetworkCode.CODE_FAIL, "");
    }

    @RequestMapping(value = "add.do")
    public String addMapper() {
        return "pages/addMapper";
    }

    @RequestMapping(value = "delete.do")
    public String deleteMapper() {
        return "pages/deleteMapper";
    }

    @RequestMapping(value = "select1Class.do",method=RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String select1class(HttpServletRequest request){
        String number = request.getParameter("number");
        List<String> list = new ArrayList<>();
        list =routerService.selectChannelOrClassName(Integer.valueOf(number));
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,list);
    }

    @RequestMapping(value = "select2Class.do",method=RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String select2class(HttpServletRequest request){
        String form = request.getParameter("form");
        String TvName = request.getParameter("TvName");
        List<Map> list = new ArrayList<>();
        list = routerService.selectUrlByClassNameOrChannel(TvName,Integer.valueOf(form));
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,list);
    }

    @RequestMapping(value = "selectColumn.do",method=RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectcolumn (HttpServletRequest request){
        String search = request.getParameter("search");
        List<Map> list = new ArrayList<>();
        list = routerService.selectUrlByChannel(search);
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,list);
    }

    @RequestMapping(value = "deleteMoreUrl.do",method=RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteUrl (HttpServletRequest request){
        String form = request.getParameter("form");
        form = form.substring(1,form.length()-1);
        String[] forms = form.split(",");
        for(String i : forms){
            i=i.substring(1,i.length()-1);
            System.out.printf(i);
            channelSourceService.delectSourceByid(Integer.valueOf(i));
        }
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
    }
    @RequestMapping(value = "addMapper.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addMapper(HttpServletRequest request) {
        // 批量添加
        String newers = request.getParameter("content");

        if (newers != null && newers.length() > 0) {
            String[] nList = newers.split("\\|");

            ArrayList<Integer> resultList = new ArrayList<>();
            for (String s: nList) {
                String[] content = s.split(",");
                if (content.length == 2) {
                    RouterMapping routerMapping = new RouterMapping();
                    routerMapping.setKey(content[0]);
                    routerMapping.setValue(content[1]);
                    resultList.add(routerService.insert(routerMapping));
                }
            }

            return JsonResult.toString(NetworkCode.CODE_SUCCESS, resultList);
        }

        return JsonResult.toString(NetworkCode.CODE_FAIL, "");
    }
    @RequestMapping(value = "mapCacheExpire.do",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String mapCacheExpire(){
        JPushTool.sendPush(MASTER_SECRET,APP_KEY,MESSAGE,NetworkCode.CACHE_EXPIRE);
        return JsonResult.toString(NetworkCode.CODE_SUCCESS,"");
    }
}
