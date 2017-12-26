package com.readyidu.model;

import java.util.Date;

/**
 * Created by ypf on 2017/12/25.
 */
public class TvDevice {
    private Integer id;
    private String deviceId;
    private Date creareTime;
    private Date modifyTime;
    private Integer isDelete;


    public Date getCreareTime() {
        return creareTime;
    }

    public void setCreareTime(Date creareTime) {
        this.creareTime = creareTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
