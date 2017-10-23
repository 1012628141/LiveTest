package com.readyidu.playbill.analyze;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.playbill.base.Parser;
import com.readyidu.playbill.model.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MiguParser  extends Parser {
    public MiguParser(){parserId  = "migu";}

    @Override
    protected List<Program> getBillInfo(String content) {
        List<Program> list = new ArrayList<>();
        try{
            if(content != null && content != ""){
                JSONArray jsonArray = JSON.parseArray(content);
                if(jsonArray != null){
                    for(int i=0;i<jsonArray.size();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        list.add(new Program(jsonObject.getString("playName"),jsonObject.getString("playStartTime")));
                    }
                }
            }
        }catch (Exception e){
            return null;
        }

        return list;
    }

    @Override
    protected String getPageUrl(String content) {
        return null;
    }

    @Override
    protected String getTomorrowUrl(String fromUrl) {
        String url = fromUrl.replace("range=0","range=1");
        return url;
    }

    @Override
    public Map<String, Object> getBill(String fromUrl) {

        return super.getBill(fromUrl);
    }
}
