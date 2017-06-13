package com.readyidu.source.base;

import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
abstract public class Local {

    protected String managerId;
    protected HashMap<String, Channel> channels;

    abstract public String getSource(SourceUri uri);

    public String getId(){
        return managerId;
    }
}
