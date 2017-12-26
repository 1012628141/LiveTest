package com.readyidu.pojo;

import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/12/13.
 */
public class RequestParamModel {
    private String lat;
    //服务端平台唯一标识
    private String appId;
    //大脑后端分配的唯一id 的使用口令
    private String password;
    private String lon;
    //服务端版本
    private int version;
    //客户端平台
    private String platform;
    //客户端城市id
    private int locationId;
    private String remoteHost;
    //小益账号
    private int account;
    //机顶盒设备id
    private String deviceId;

    public RequestParamModel(String remoteHost, String version, String lat, String appId, String password, String lon, String platform, String locationId,String account,String deviceId) {
        this.remoteHost = remoteHost;
        if (!NullUtil.isNullObject(version)) {
            this.version = Integer.valueOf(version);
        }
        this.lat = lat;
        this.appId = appId;
        this.password = password;
        this.lon = lon;
        this.platform = platform;
        if (!NullUtil.isNullObject(locationId))
        {
            this.locationId = Integer.valueOf(locationId);
        }
        if (!NullUtil.isNullObject(account))
        {
            this.account = Integer.valueOf(account);
        }
        this.deviceId = deviceId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
