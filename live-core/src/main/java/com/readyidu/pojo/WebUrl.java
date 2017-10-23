package com.readyidu.pojo;

import com.google.common.escape.Escaper;

import java.util.Arrays;

/**
 * Created by 123 on 2017/10/19.
 */
public class WebUrl {
    String head = "http://";
    String[] url;
    String changeUrl;
    public WebUrl(String urlStr,String changeUrlStr)
    {
        this.url = urlStr.replace("http://","").split("/");
        this.changeUrl = changeUrlStr;
    }

    @Override
    public String toString() {
        if (changeUrl.startsWith("/"))
        {
            return head+url[0]+changeUrl;
        }else
        {
            String resultUrl = head;
            for (int index =0;index<url.length-1;index++)
            {
                resultUrl = resultUrl + url[index]+"/";
            }
            return resultUrl+changeUrl;
        }
    }
}
