package com.readyidu.model;

public class NewDemand {

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
     * 父ID
     */
    private Integer p;

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public NewDemand(){

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