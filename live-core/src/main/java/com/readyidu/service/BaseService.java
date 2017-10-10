package com.readyidu.service;

import javax.annotation.Resource;

public class BaseService {
    public static String RBK = "LIVE_CORE_";
    public static String ADMIN_RBK = "LIVE_ADMIN_";
    public static String SERVICE_RBK = "LIVE_SERVICE_";

    @Resource(name = "cacheService")
    private CacheService cacheService;

    /**
     * 删除缓存 根据关键字
     *
     * @param key
     */
    public void delCacheByKey(String key) {
        cacheService.del(ADMIN_RBK + key);
        cacheService.del(SERVICE_RBK + key);
    }

    /**
     * 删除指定类目缓存
     *
     * @param keyType
     */
    public void delCache(String keyType) {
        cacheService.delKeysLike(ADMIN_RBK + keyType);
        cacheService.delKeysLike(SERVICE_RBK + keyType);
    }
}
