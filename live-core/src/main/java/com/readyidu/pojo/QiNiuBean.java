package com.readyidu.pojo;

/**
 * Created by 123 on 2017/12/25.
 */
public class QiNiuBean {
    private String token;
    private String callBackUrl;

    public QiNiuBean(String token, String callBackUrl) {
        this.token = token;
        this.callBackUrl = callBackUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }
}
