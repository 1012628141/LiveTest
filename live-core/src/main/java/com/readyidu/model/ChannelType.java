package com.readyidu.model;

public class ChannelType {
    private Integer id;

    private String type;

    private Integer categoryId ;

//    private int sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
//    public int getSort() {
//        return sort;
//    }
//
//    public void setSort(int sort) {
//        this.sort = sort;
//    }


}