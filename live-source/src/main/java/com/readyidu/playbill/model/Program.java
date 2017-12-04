package com.readyidu.playbill.model;

import com.readyidu.util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by 123 on 2017/9/26.
 */
public class Program {
    private String channelName;
    private String showTime;
    private long stamp;

    public Program(String channelName, String showTime) {
        this.channelName = channelName;
        this.showTime = showTime;
        this.stamp = TimeUtil.getStamp(showTime)+(long)28800000;
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
        this.stamp = TimeUtil.getStamp(showTime);
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
