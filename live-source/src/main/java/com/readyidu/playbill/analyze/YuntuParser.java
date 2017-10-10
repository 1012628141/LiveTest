package com.readyidu.playbill.analyze;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.playbill.base.Parser;
import com.readyidu.playbill.model.Program;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.TimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
public class YuntuParser extends Parser {
    public YuntuParser(){
        parserId = "yuntu";
    }



    @Override
    protected String getPageUrl(String content) {
        return null;
    }
    @Override
    protected List<Program> getBillInfo(String content) {
        List<Program> list = new ArrayList<>();
        try {
            JSONArray data = JSONObject.parseArray(content);
            for (int index=0;index<data.size();index++){
                JSONObject thisObj = data.getJSONObject(index);
                list.add(new Program(thisObj.getString("t"),thisObj.getString("showTime")));
            }
        }catch (Exception e)
        {
            return null;
        }
        return list;
    }
}
