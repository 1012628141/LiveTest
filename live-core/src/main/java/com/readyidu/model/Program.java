package com.readyidu.model;

import com.readyidu.util.TimeUtil;

/**
 * Created by 123 on 2017/9/26.
 */
public class Program {
    private String channelName;
    private String showTime;
    private long stamp;
    private int channelId;
    private String date;

    public Program() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
        this.stamp = TimeUtil.getStamp(showTime)+(long)28800000;
    }

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    @Override
    public String toString() {
        return "Program{" +
                "channelName='" + channelName + '\'' +
                ", showTime='" + showTime + '\'' +
                '}';
    }
}
