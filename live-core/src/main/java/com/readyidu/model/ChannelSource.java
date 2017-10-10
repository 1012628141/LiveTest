package com.readyidu.model;

/**
 * Created by 123 on 2017/7/26.
 */
public class ChannelSource {
    private Integer id;
    private Integer parentid;
    private String source;
    private int sort;
    private int isDelete;
    public ChannelSource(){
        super();
    }
    public ChannelSource(int sort, String source) {
        this.sort = sort;
        this.source = source;
    }
    public ChannelSource(int id,int parentid, String source) {
        this.id = id;
        this.parentid = parentid;
        this.source = source;
    }

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
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
