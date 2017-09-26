package com.readyidu.playbill.analyze;

import com.readyidu.playbill.base.Parser;
import com.readyidu.playbill.model.Program;
import com.readyidu.util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
public class TvCatParser extends Parser {
    public TvCatParser(){
        parserId = "tvcat";
    }

    @Override
    protected List<Program> getBillInfo(String content) {
        return null;
    }

    @Override
    protected String getPageUrl(String content) {
        return null;
    }

    @Override
    public Map<String, Object> getBill(String fromUrl) {
        Map<String,Object> map = new HashMap<>();
        try {
            String content = HttpUtil.httpGet(fromUrl);
            content = content.substring(content.indexOf("<tr"),content.indexOf("</table>")).replace("<tr>","");
            String[] trs = content.split("</tr>");
            for (String tr : trs){
                System.out.println(tr);
            }
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return map;
    }
}
