package com.readyidu.playbill.base;

import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
abstract public class Parser {
    protected String parserId;
    protected abstract Map<String, Object> getBill(String fromUrl);
    public String getParserId(){
        return parserId;
    }
}
