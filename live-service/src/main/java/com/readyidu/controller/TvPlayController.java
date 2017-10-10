package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.service.PlayTypeService;
import com.readyidu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/10/9.
 */
@Controller
@RequestMapping("/play")
public class TvPlayController {
    @Autowired
    private PlayTypeService playTypeService;

    public String pushPlayType(){

        return null;
    }
    @ResponseBody
    @RequestMapping(value = "tvPlayType.do",produces = "application/json; charset=utf-8")
    public String tvPlayType(){
        Map<String,Integer> map = new HashMap<>();
        try {
            int playType = playTypeService.getPlayType();
            map.put("playType",playType);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,map);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
}
