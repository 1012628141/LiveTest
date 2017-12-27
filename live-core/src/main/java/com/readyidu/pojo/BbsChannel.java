package com.readyidu.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by 123 on 2017/12/27.
 */
public class BbsChannel  {
    @JSONField(name="c")
    private String channel ;
    @JSONField(name="s")
    private String source;

    public BbsChannel(String channelName, String playUrl) {
        this.channel = channelName;
        this.source = playUrl;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
