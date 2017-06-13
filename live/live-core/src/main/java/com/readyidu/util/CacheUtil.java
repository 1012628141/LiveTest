package com.readyidu.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Created by yuzhang on 17/6/11.
 */
public class CacheUtil {
    private static final Logger log = LoggerFactory.getLogger(CacheUtil.class);
    private static JedisPool jedisPool;
    private static Jedis jedis;

    /**
     * 初始化连接池
     *
     * @see [类、类#方法、类#成员]
     */
    private synchronized static void init() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(60000);
        config.setMaxIdle(300);
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config, ConfigSettings.getProperty("redis_host", "localhost"), NumberUtils.toInt(
                ConfigSettings.getProperty("redis_port"), 6379), NumberUtils.toInt(ConfigSettings.getProperty("redis_timeout"), 3000), ConfigSettings.getProperty("redis_pwd", ""));
    }

    /**
     * 获取Jedis实例
     *
     * @return
     */
    private static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            } else {
                init();
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            log.error("获取Redis实例出错，" + e);
        }
        return jedis;
    }

    /**
     * 设置单个值
     *
     * @param key
     * @param value
     * @return
     */
    public static String set(String key, String value) {
        return set(key, value, null);
    }

    /**
     * 设置单个值，并设置超时时间
     *
     * @param key     键
     * @param value   值
     * @param timeout 超时时间（秒）
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String set(String key, String value, Integer timeout) {
        String result = null;

        Jedis jedis = CacheUtil.getJedis();
        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.set(key, value);
            if (null != timeout) {
                jedis.expire(key, timeout);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * 获取单个值
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String result = null;
        Jedis jedis = CacheUtil.getJedis();
        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * 删除redis中数据
     *
     * @param key
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean del(String key) {
        Boolean result = Boolean.FALSE;
        Jedis jedis = CacheUtil.getJedis();
        if (null == jedis) {
            return Boolean.FALSE;
        }
        try {
            jedis.del(key);
        } catch (Exception e) {
            log.error("删除redis数据出错，" + e);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * 追加
     *
     * @param key
     * @param value
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Long append(String key, String value) {
        Long result = Long.valueOf(0);
        Jedis jedis = CacheUtil.getJedis();
        if (null == jedis) {
            return result;
        }
        try {
            result = jedis.append(key, value);
        } catch (Exception e) {
            log.error("追加redis数据出错，" + e);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * 检测是否存在
     *
     * @param key
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Boolean exists(String key) {
        Boolean result = Boolean.FALSE;
        Jedis jedis = CacheUtil.getJedis();
        if (null == jedis) {
            return result;
        }
        try {
            result = jedis.exists(key);
        } catch (Exception e) {
            log.error("检查是否存在出错：，" + e);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return result;
    }
}
