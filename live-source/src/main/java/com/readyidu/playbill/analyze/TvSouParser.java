package com.readyidu.playbill.analyze;

import com.readyidu.playbill.base.Parser;
import com.readyidu.playbill.model.Program;

import java.util.List;
import java.util.Map;

public class TvSouParser extends Parser{
    public TvSouParser(){
        parserId = "tvsou";
    }

    @Override
    protected List<Program> getBillInfo(String content) {
        String programContent = content.substring(content.indexOf("<ol"),content.indexOf("</ol>"));
        String listContent = programContent.substring(programContent.indexOf("<li"));
        String[] strs = listContent.split("</li>");
        List<Program> list = null ;
        for(String str:strs){
            String channelName = str.substring(str.indexOf("data-name="),str.indexOf("data-mainstars")).substring(11);
            String showTime = str.substring(str.indexOf("<span >"),str.indexOf("</span")).substring(7);
            Program p = new Program(channelName.substring(0,channelName.length()-2),showTime);
            System.out.print(p);
            list.add(p);
        }
        return list;
    }

    @Override
    protected String getPageUrl(String content) {
        return null;
    }

    @Override
    public Map<String, Object> getBill(String fromUrl) {
        return super.getBill(fromUrl);
    }
}
