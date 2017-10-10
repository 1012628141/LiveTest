package com.readyidu.source.model;

import java.util.HashMap;

public class CNTV {
    private String ack;
    private HashMap<String, String> lc;
    private String client_sid;
    private HashMap<String, String> flv_cdn_info;
    private HashMap<String, String> flv_url;
    private HashMap<String, String> hds_url;
    private HashMap<String, String> hls_url;

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public HashMap<String, String> getLc() {
        return lc;
    }

    public void setLc(HashMap<String, String> lc) {
        this.lc = lc;
    }

    public String getClient_sid() {
        return client_sid;
    }

    public void setClient_sid(String client_sid) {
        this.client_sid = client_sid;
    }

    public HashMap<String, String> getFlv_cdn_info() {
        return flv_cdn_info;
    }

    public void setFlv_cdn_info(HashMap<String, String> flv_cdn_info) {
        this.flv_cdn_info = flv_cdn_info;
    }

    public HashMap<String, String> getFlv_url() {
        return flv_url;
    }

    public void setFlv_url(HashMap<String, String> flv_url) {
        this.flv_url = flv_url;
    }

    public HashMap<String, String> getHds_url() {
        return hds_url;
    }

    public void setHds_url(HashMap<String, String> hds_url) {
        this.hds_url = hds_url;
    }

    public HashMap<String, String> getHls_url() {
        return hls_url;
    }

    public void setHls_url(HashMap<String, String> hls_url) {
        this.hls_url = hls_url;
    }
}
