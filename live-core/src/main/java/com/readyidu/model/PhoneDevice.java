package com.readyidu.model;

/**
 * Created by ypf on 2017/12/25.
 */
public class PhoneDevice {
    private Integer id;
    private String phoneName;
    private String phoneId;
    private Integer userId;
    private String deviceId;
    private String phoneAlias;

    public String getPhoneAlias() {
        return phoneAlias;
    }

    public void setPhoneAlias(String phoneAlias) {
        this.phoneAlias = phoneAlias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
