package com.readyidu.util;

import com.alibaba.fastjson.JSON;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class HeaderUtil {

    private static final String HEADER_TAG = "#";

    public static String addHeader(String url, Map<String, String> header) {
        if (!NullUtil.isNullObject(url)) {
            if (header == null || header.size() == 0) {
                return url;
            }
            return url + HEADER_TAG + JSON.toJSONString(header);
        }
        return null;
    }
}
