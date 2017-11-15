package com.readyidu.source.local.tianyi.source;

import com.readyidu.source.base.Source;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/9/18.
 */
public class TianyiSource extends Source {
    public TianyiSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String content = HttpUtil.httpGet("http://h5.tv189.com/api/portal/program/freeplay?contid=" + sourceId);
        //http:[a-zA-z0-9\\/.?&_=-]*
        if (!NullUtil.isNullObject(content)){
            Pattern pattern = Pattern.compile("http:[a-zA-z0-9\\\\/.?&_=-]*");
            Matcher mather = pattern.matcher(content);
            if (mather.find()) {
                return mather.group().replace("\\","");
            }
        }
        return null;
    }
}
