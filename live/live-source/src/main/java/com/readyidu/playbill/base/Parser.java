package com.readyidu.playbill.base;

import com.readyidu.playbill.model.Program;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import com.readyidu.util.TimeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
abstract public class Parser {
    protected String parserId;
    protected String nextUrl;

    //获取当日信息
    protected abstract List<Program> getBillInfo(String content);
    //获取明日节目地址
    protected abstract String getPageUrl(String content);

    public String getParserId(){
        return parserId;
    }
    public Map<String, Object> getBill(String fromUrl){
        Map<String,Object> map = new HashMap<>();
        try {
            String content = HttpUtil.httpGet(fromUrl);
            List<Program> programList = getBillInfo(content);
            this.nextUrl = getPageUrl(content);
            Program thisProgram = null;
            int index;
            for (index = 0 ; index < programList.size(); index++){
                thisProgram = programList.get(index);
                if (TimeUtil.isAfterNowTime(thisProgram.getShowTime()))
                {
                    map.put("nextChannel",thisProgram);
                    break;
                }
            }
            if (map.size() == 0)
            {
                map.put("nowChannel", programList.get(programList.size()));
                if (!NullUtil.isNullObject(this.nextUrl))
                {
                    List<Program> nextList = getBillInfo(this.nextUrl);
                    map.put("nextChannel",nextList.get(nextList.size()));
                }else{
                    map.put("nextChannel",new Program("暂无节目信息",""));
                }
            }else {
                map.put("nowChannel",programList.get(index-1));
            }
        }catch (Exception e){
            return null;
        }
        return map;
    }
}
