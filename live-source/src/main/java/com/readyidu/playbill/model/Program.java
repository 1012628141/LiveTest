package com.readyidu.playbill.model;

/**
 * Created by 123 on 2017/9/26.
 */
public class Program {
    private String channelName;
    private String showTime;

    public Program(String channelName, String showTime) {
        this.channelName = channelName;
        this.showTime = showTime;
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
    }

    @Override
    public String toString() {
        return "Program{" +
                "channelName='" + channelName + '\'' +
                ", showTime='" + showTime + '\'' +
                '}';
    }
}
