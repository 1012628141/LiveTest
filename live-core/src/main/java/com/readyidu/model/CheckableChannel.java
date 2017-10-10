package com.readyidu.model;

import java.util.Date;

/**
 * 2017/6/23
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
public class CheckableChannel {
    private Integer channelId;
    private String channelName;
    private String channelSource;
    private Integer deathSourceId;
    private String deathSource;
    private Date createdAt;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public Integer getDeathSourceId() {
        return deathSourceId;
    }

    public void setDeathSourceId(Integer deathSourceId) {
        this.deathSourceId = deathSourceId;
    }

    public String getDeathSource() {
        return deathSource;
    }

    public void setDeathSource(String deathSource) {
        this.deathSource = deathSource;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
