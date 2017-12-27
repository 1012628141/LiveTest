package com.readyidu.model;

/**
 * Created by 123 on 2017/12/18.
 */
public class ConfInfo {
    private int acount;
    private String hash;
    private String confName;
    private String confUrl;
    private String version;

    public ConfInfo(int acount, String hash, String confUrl) {
        this.acount = acount;
        this.hash = hash;
        this.confUrl = confUrl;
    }

    public ConfInfo() {

    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
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

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }
}
