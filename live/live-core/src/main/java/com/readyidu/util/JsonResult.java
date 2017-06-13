package com.readyidu.util;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * app统一返回接口定义
 *
 * @author yuzhang
 */
public class JsonResult {

    protected static String kg = " ";
    protected static String kgzy = "&nbsp;";
    protected static String xyh = "<";
    protected static String xyhzy = "&lt;";
    protected static String dyh = ">";
    protected static String dyhzy = "&gt;";
    protected static String gn = "\\n";
    protected static String gnzy = "";
    protected static String gr = "\\r";
    protected static String grzy = "";
    protected static String ph = "'";
    protected static String phzy = "&apos;";
    protected static String syh = "--quot--";
    protected static String syhzy = "&quot;";
    protected static String hh = "\\t";
    protected static String hhzy = "&nbsp;";
    private Integer code;
    private String message;
    private Object data;  // 返回对象

    public JsonResult() {
    }

    public JsonResult(Integer code, Object data) {
        this.code = code;
        this.message = "";
        this.data = data;
    }


    /**
     * 返回json字符串
     *
     * @param code
     * @param data
     * @return
     */
    public static String toString(Integer code, Object data) {
        return JSON.toJSONString(new JsonResult(code, data));
    }

    /**
     * 默认内容
     *
     * @param code
     * @param data
     * @param defMsg
     * @return
     */
    public static String toString(Integer code, String data, boolean defMsg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMessage(data);
        return JSON.toJSONString(jsonResult);
    }

    public static String formatJsonString(String jsonrt, String str, String replaceStr) {
        jsonrt = jsonrt.replace(xyh, xyhzy);// 小于号
        jsonrt = jsonrt.replace(dyh, dyhzy);//大于号
        jsonrt = jsonrt.replace(gn, gnzy);// \n
        jsonrt = jsonrt.replace(gr, grzy);// \r
        jsonrt = jsonrt.replace(ph, phzy);// 撇号
        jsonrt = jsonrt.replace(kg, kgzy);// 空格
        jsonrt = jsonrt.replace(syh, syhzy);// 引号
        jsonrt = jsonrt.replace("	", "");// tab
        jsonrt = jsonrt.replace(" ", "");// 空格
        jsonrt = jsonrt.replace(hh, hhzy);//tab
        jsonrt = StringEscapeUtils.unescapeJava(jsonrt);
        return jsonrt;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
