package com.readyidu.model;

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
    /**
     * 频道源
     */
    private String[] sources;

    public Channel(){

    }

    public String[] getSources() {
        return sources;
    }

    public void setSources(String[] sources) {
        this.sources = sources;
    }

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

}