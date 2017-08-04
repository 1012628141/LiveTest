package com.readyidu.service;

import redis.clients.jedis.Tuple;

import java.util.List;

/**
 * 缓存接口
 * 
 * @author liujj
 *
 */
public interface CacheService {

    int CACHE_TIMEOUT = 300;
    int CACHE_LONG_TIMEOUT = 3600;

    long zadd(String key, long score, String value);

    Tuple zpop(String key);

    public String get(String key);

    public List<String> mget(String... keys);

    public String set(String key, String value, int timeout);

    public String set(String key, byte[] value, int timeout);

    // 同时设置一个或多个key-value对
    public String mset(int timeout, String... keysvalues);

    public String set(String key, String value, String nxxx, String expx, long time);

    // 对整型数据 减
    public Long decr(String key);

    // 对整型数据 增
    public Long incr(String key);

    public Long del(String key);

    <T> List<T> cacheList(CacheRun<List<T>> cacheRun, Class<T> cla);

    <T> T cache(CacheRun<T> cacheRun, Class<T> cla);

    interface CacheRun<T> {
        String generateKey();

        T read();
    }

    /**
     * 删除前缀相似的 缓存信息
     * 
     * @param likeKey
     */
    public void delKeysLike(String likeKey);
}
