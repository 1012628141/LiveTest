package com.readyidu.model;

import java.util.List;

public class NewChannel {

    /**
     * 频道编号
     */
    private Integer i;
    /**
     * 频道名称
     */
    private String c;
    /**
     * 频道类型ID
     */
    private String t;
    /**
     * 节目名称
     */
    private String n;

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    /**
     * 频道源
     */
    private List<NewChannelSource> o;

    public List<NewChannelSource> getO() {
        return o;
    }

    public void setO(List<NewChannelSource> o) {
        this.o = o;
    }

    public NewChannel(){

    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}