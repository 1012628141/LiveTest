package com.readyidu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Channel {

    /**
     * 频道编号
     */
    private Integer id;
    /**
     * 频道名称
     */
    private String channel;

    private String source;

    private String typeid;

    private Integer parentid;
    /**
     * 频道源
     */
    private List<ChannelSource> sources;

    public Channel(){

    }

    public List<ChannelSource> getSources() {
        return sources;
    }

    public void setSources(List<ChannelSource> sources) {
        this.sources = sources;
    }

    //    public List<String> getSources() {
//        return sources;
//    }
//
//    public void setSources(List<String> sources) {
//        this.sources = sources;
//    }
//
//    public void setSources(String[] sources) {
//        this.sources = Arrays.asList(sources);
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim().replace(",","|");
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}