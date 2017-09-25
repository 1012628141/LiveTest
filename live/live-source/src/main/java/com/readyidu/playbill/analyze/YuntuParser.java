package com.readyidu.playbill.analyze;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.playbill.base.Parser;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.TimeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
public class YuntuParser extends Parser {
    public YuntuParser(){
        parserId = "yuntu";
    }
    @Override
    public Map<String, Object> getBill(String fromUrl) {
        Map<String,Object> map = new HashMap<>();
        try {
            String content = HttpUtil.httpGet(fromUrl,"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36","");
            String showTime = null;
            JSONArray data = JSONObject.parseArray(content);
            for (int index=0;index<data.size();index++){
                JSONObject channel = data.getJSONObject(index);
                showTime = channel.getString("showTime");
                if(TimeUtil.isAfterNowTime(showTime)){
                    map.put("nowChannel",data.getJSONObject(index-1));
                    map.put("nextChannel",channel);
                    break;
                }

            }
        }catch (Exception e)
        {
            return null;
        }
        return map;
    }
}
