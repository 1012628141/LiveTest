package com.readyidu.pojo;

import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/12/13.
 */
public class RequestParamModel {
    private String lat;
    private String appId;
    private String password;
    private String lon;
    private int version;
    private String platform;
    private int locationId;
    private String remoteHost;

    public RequestParamModel(String remoteHost, String version, String lat, String appId, String password, String lon, String platform, String locationId) {
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
}
