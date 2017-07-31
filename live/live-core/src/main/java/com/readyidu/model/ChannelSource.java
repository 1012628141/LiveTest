package com.readyidu.model;

/**
 * Created by 123 on 2017/7/26.
 */
public class ChannelSource {
    private Integer id;
    private Integer parentid;
    private String Source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }
}
