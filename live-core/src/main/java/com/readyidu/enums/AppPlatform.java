package com.readyidu.enums;

import java.util.HashMap;
import java.util.Map;

public enum AppPlatform {
    iOS("ios"), Android("android"), TV("tv");

    private String value;

    static Map<String, AppPlatform> enumMap = new HashMap<String, AppPlatform>();

    static {
        for (AppPlatform type : AppPlatform.values()) {
            enumMap.put(type.getValue(), type);
        }
    }

    private AppPlatform(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static AppPlatform getEnum(String value) {
        return enumMap.get(value);
    }
}
