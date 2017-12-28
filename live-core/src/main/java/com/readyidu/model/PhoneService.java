package com.readyidu.model;

/**
 * Created by ypf on 2017/12/25.
 */
public class PhoneService {
    private Integer id;
    private String phoneId;
    private String confUrl;
    private String version;
    private String hash;
    private Integer userId;
    private String definedName;

    public String getDefineName() {
        return definedName;
    }

    public void setDefineName(String defineName) {
        this.definedName = defineName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getConfUrl() {
        return confUrl;
    }

    public void setConfUrl(String confUrl) {
        this.confUrl = confUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
