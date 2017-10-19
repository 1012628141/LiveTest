package com.readyidu.util;

import com.readyidu.pojo.Pixel;
import com.readyidu.pojo.SourceCheckResult;
import com.readyidu.pojo.WebUrl;
import org.springframework.web.servlet.tags.EscapeBodyTag;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/10/18.
 */
public class SourceCheck {
    public static SourceCheckResult playCheck(String source){
        try {
            String cmdStr = "timeout 1 ffmpeg -i " + source;
            List<String> result = Command.exeCmd(cmdStr);
            for (String line : result)
            {
                if (line.contains("Stream #"))
                {
                    Pattern pattern = Pattern.compile("[0-9]{3,4}x[0-9]{3,4}");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find())
                    {
                        return new SourceCheckResult(true,matcher.group());
                    }
                }
            }
            return new SourceCheckResult(false,null);
        }catch (Exception e)
        {
            return new SourceCheckResult(false,null);
        }
    }
    public static SourceCheckResult playLowCheck(String source){
        try {
            String content = HttpUtil.httpGet(source.replace("$1",""));
            if (!NullUtil.isNullObject(content))
            {
             return sourceResolve(source,content,1);
            }
            return new SourceCheckResult(false,null);
        }catch (Exception e)
        {
            return new SourceCheckResult(false,null);
        }
    }
    public static SourceCheckResult sourceResolve(String url,String content,int index)
    {
        if (index < 5)
        {
            String thisUrl = contentResolve(url, content);
            if (thisUrl.contains(".ts"))
                return new SourceCheckResult(true,null);
            content = HttpUtil.httpGet(thisUrl);
            return sourceResolve(thisUrl,content,index++);
        }
        return new SourceCheckResult(false,null);
    }
    public static String contentResolve(String url,String content){
        String[] strs = content.split("\n");
        for (String str : strs)
        {
            if (!str.startsWith("#"))
            {
                return new WebUrl(url, str).toString();
            }
        }
        return null;
    }
}
