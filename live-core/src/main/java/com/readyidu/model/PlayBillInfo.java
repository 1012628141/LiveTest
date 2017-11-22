package com.readyidu.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.omg.Dynamic.Parameter;

import java.util.Date;

/**
 * Created by 123 on 2017/11/22.
 */
public class PlayBillInfo {
    @JSONField(serialize=false)
    private int id;
    @JSONField(serialize=false)
    private int channelId;
    private String playontime;
    @JSONField(name = "channelName")
    private String showname;
    @JSONField(name = "showTime")
    private String date;

    public PlayBillInfo() {
    }

    public PlayBillInfo(String showname, String playontime, String date, Integer channelId) {
        this.playontime = playontime;
        this.showname = showname;
        this.date = date;
        this.channelId = channelId;
    }

    public PlayBillInfo(String date, Integer channelId) {
        this.date = date;
        this.channelId = channelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getPlayontime() {
        return playontime;
    }

    public void setPlayontime(String playontime) {
        this.playontime = playontime;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
