package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/10/9.
 */
@RequestMapping("/play")
public class TvPlayController {
    public String pushPlayType(){

        return null;
    }
    @RequestMapping(value = "tvPlayType.do",produces = "application/json; charset=utf-8")
    public String tvPlayType(){
        Map<String,Integer> map = new HashMap<>();
        try {
            int playType = 0;
            map.put("playType",playType);
            return JsonResult.toString(NetworkCode.CODE_SUCCESS,map);
        }catch (Exception e){
            return JsonResult.toString(NetworkCode.CODE_FAIL,"");
        }
    }
}
