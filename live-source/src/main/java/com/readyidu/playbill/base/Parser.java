package com.readyidu.playbill.base;

import com.readyidu.playbill.model.Program;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import com.readyidu.util.TimeUtil;

import java.util.ArrayList;
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

    protected abstract String getTomorrowUrl(String url);

    public String getParserId() {
        return parserId;
    }

    public Map<String, Object> getBill(String fromUrl) {
        Map<String, Object> map = new HashMap<>();
        try {
            String content = HttpUtil.httpGet(fromUrl);
            this.nextUrl = getPageUrl(content);
            if(NullUtil.isNullObject(nextUrl)){
                this.nextUrl = getTomorrowUrl(fromUrl);
            }
            map.put("todayProgram", getBillInfo(content));
            if (!NullUtil.isNullObject(this.nextUrl)) {
                String nextContent = HttpUtil.httpGet(this.nextUrl);
                List<Program> nextList = getBillInfo(nextContent);
                map.put("tommorrowProgram", nextList);
            } else {
                map.put("tommorrowProgram", new Program("暂无节目信息", ""));

            }
//            int index;
//            for (index = 0 ; index < programList.size(); index++){
//                thisProgram = programList.get(index);
//                if (TimeUtil.isAfterNowTime(thisProgram.getShowTime()))
//                {
//                    map.put("nextChannel",thisProgram);
//                    break;
//                }
//            }
//            if (map.size() == 0)
//            {
//                map.put("nowChannel", programList.get(programList.size()-1));
//                if (!NullUtil.isNullObject(this.nextUrl))
//                {
//                    List<Program> nextList = getBillInfo(this.nextUrl);
//                    map.put("nextChannel",nextList.get(0));
//                }else{
//                    map.put("nextChannel",new Program("暂无节目信息",""));
//                }
//            }else {
//                map.put("nowChannel",programList.get(index-1));
//            }
        } catch (Exception e) {
            List<Program> today = new ArrayList<>();
            List<Program> tommorrow = new ArrayList<>();
            today.add(new Program("暂无节目信息", "00:00"));
            tommorrow.add(new Program("暂无节目信息", "00:00"));
            map.put("todayProgram",today);
            map.put("tommorrowProgram", tommorrow);
        }
        return map;
    }
}
