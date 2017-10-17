package com.readyidu.playbill.analyze;

import com.readyidu.playbill.base.Parser;
import com.readyidu.playbill.model.Program;
import com.readyidu.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TvSouParser extends Parser{
    public TvSouParser(){
        parserId = "tvsou";
    }

    @Override
    protected List<Program> getBillInfo(String content) {
        String programContent = content.substring(content.indexOf("<ol"),content.indexOf("</ol>"));
        String listContent = programContent.substring(programContent.indexOf("<li")).trim();
        String[] strs = listContent.split("</li>");
        String regex = ">\\d{2}:\\d{2}<" ;
        Pattern pattern = Pattern.compile(regex);
        List<Program> list = new ArrayList<Program>();
        String showTime = null ;
        String channelName = null ;
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            if(str.indexOf("data-name=") != -1){
                channelName = str.substring(str.indexOf("data-name=")+11,str.indexOf("\"",str.indexOf("data-name=")+11));
            } else {
                channelName = str.substring(0,str.lastIndexOf("</a>"));
                channelName = channelName.substring(channelName.lastIndexOf(">")+1);
            }
            Matcher m = pattern.matcher(str);
            if(m.find()){
                showTime = m.group().substring(1,6);
            }else if(str.indexOf("data-mainstars=") != -1){

                int timeIndex = str.indexOf("data-mainstars=")+16;
                showTime = str.substring(timeIndex,str.indexOf("\"",timeIndex)).substring(0,5);
            }else {
                if(i>0){
                    int timeIndex = strs[i-1].indexOf("data-mainstars=")+16;
                    showTime = strs[i-1].substring(timeIndex,str.indexOf("\"",timeIndex)).substring(6,11);
                }
            }
            if(showTime != null && channelName !=  null){
                Program p = new Program(channelName,showTime);
                System.out.print(p);
                list.add(p);
            }
            showTime = null ;
            channelName = null ;

        }
        return list;
    }

    @Override
    protected String getPageUrl(String content) {
        //从网页内容中截取节目表div
        System.out.print(content);
        int divIndex = content.indexOf("<div style=\"height: 24px;\">");
        String divContent = content.substring(divIndex,content.indexOf("</div>",divIndex)).trim();
        String[] strs = divContent.split("</a>");
        int index = 0 ;
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            if (str.contains("week")){
                index = i+1;
                break;
            }
        }
        String pageUrl = strs[index].substring(strs[index].indexOf("\"")+1,strs[index].indexOf("\"",strs[index].indexOf("\"")+1));
        return pageUrl;
    }

    @Override
    public Map<String, Object> getBill(String fromUrl) {
        return super.getBill(fromUrl);
    }
}
