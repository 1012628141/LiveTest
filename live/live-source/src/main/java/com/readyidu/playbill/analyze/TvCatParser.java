package com.readyidu.playbill.analyze;

import com.readyidu.playbill.base.Parser;
import com.readyidu.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
public class TvCatParser extends Parser {
    public TvCatParser(){
        parserId = "tvcat";
    }
    @Override
    public Map<String, Object> getBill(String fromUrl) {
        Map<String,Object> map = new HashMap<>();
        try {
            String content =HttpUtil.httpGet(fromUrl);
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return map;
    }
}
