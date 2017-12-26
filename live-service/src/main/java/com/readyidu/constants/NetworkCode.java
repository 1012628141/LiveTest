package com.readyidu.constants;

import com.readyidu.service.impl.TvSourceServiceImpl;

/**
 * Created by yuzhang on 17/6/10.
 */
public class NetworkCode {

    public static final int CODE_SUCCESS = 200; //成功

    public static final int CODE_SUCCESS_NULL = 204; //成功但返回为空

    public static final int CODE_FAIL = 10000; //请求异常

    public static final int CODE_TIME_OUT = 408 ;

    public static final int ERROR_CODE_400 = 400; //参数错误

    public static final int ERROR_CODE_412 = 412;
//    public static final int CACHE_EXPIRE = 12000; //缓存过期
    public static final int CACHE_EXPIRE = 12001; //线下缓存过期
    public static final int CODE_SOURCE_ZERO = 11000; //无可用地址
    public static final int TYPE_CHANGE = 12100; //播放器切换
    public static final int BUNDLING_REPETITION = 13000;//重复绑定
    public static final int BUNDLING_LIMIT = 13001;//机顶盒绑定数达到上限
    public static final int BUNDLING_CAN = 13002;//可以绑定
    public static final int ACCOUNT_NOT_EXIST = 13003;//账号不存在

}
