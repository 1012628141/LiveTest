package com.readyidu.model;

/**
 * Created by 123 on 2017/12/4.
 */
public class DemandChannel extends Channel {
    private Integer isFengmi;

    private Integer fengmiId;

    private Integer orderIndex;

    public DemandChannel() {
        super();
    }

    public Integer getIsFengmi() {
        return isFengmi;
    }

    public void setIsFengmi(Integer isFengmi) {
        this.isFengmi = isFengmi;
    }

    public Integer getFengmiId() {
        return fengmiId;
    }

    public void setFengmiId(Integer fengmiId) {
        this.fengmiId = fengmiId;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
