package com.readyidu.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public class NullUtil {
    public static String defaultValue(String obj) {
        return obj == null || "".equals(obj) ? "" : obj;
    }

    public static Integer defaultValue(Integer obj) {
        return obj == null ? 0 : obj;
    }

    public static Long defaultValue(Long obj) {
        return obj == null ? 0 : obj;
    }

    public static BigDecimal defaultValue(BigDecimal obj) {
        return obj == null ? BigDecimal.ZERO : obj;
    }

    public static BigInteger defaultValue(BigInteger obj) {
        return obj == null ? BigInteger.ZERO : obj;
    }

    public static boolean isNullObject(String obj) {
        return obj == null || "".equals(obj) ? true : false;
    }

    public static boolean isNullObject(Integer obj) {
        return obj == null ? true : false;
    }

    public static boolean isNullObject(Object obj) {
        return obj == null ? true : false;
    }

    public static boolean isNullObject(List<?> obj) {
        return obj == null || obj.size() == 0 ? true : false;
    }

    public static boolean isNullObject(String[] obj) {
        return obj == null || obj.length == 0 ? true : false;
    }

    public static boolean isNullObject(Set<?> obj) {
        return obj == null || obj.size() == 0 ? true : false;
    }
}
