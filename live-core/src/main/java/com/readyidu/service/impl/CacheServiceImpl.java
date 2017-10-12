package com.readyidu.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

import com.alibaba.fastjson.JSON;
import com.readyidu.service.CacheService;
import com.readyidu.util.ConfigSettings;
import com.readyidu.util.NullUtil;

@Service("cacheService")
public class  CacheServiceImpl implements CacheService {
    private static final Logger log = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Autowired(required = false)
    private JedisPool cachePool;

    @Override
    public long zadd(String key, long score, String value) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.zadd(key, Double.valueOf(score), value);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return -1;
    }

    @Override
    public Tuple zpop(String key) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            Transaction multi = cache.multi();
            multi.zrangeWithScores(key, 0, 0);
            multi.zremrangeByRank(key, 0, 0);
            List objectList = multi.exec();
            Set<Tuple> set = (Set<Tuple>) objectList.get(0);
            if (set != null && !set.isEmpty()) {
                return set.toArray(new Tuple[set.size()])[0];
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public String get(String key) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public List<String> mget(String... keys) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.mget(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public String set(String key, String value, int timeout) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            if (timeout > 0) {
                return cache.setex(key, timeout, value);
            } else {
                return cache.set(key, value);
            }
        } catch (Exception e) {
            log.error(key + ":" + value == null ? "null" : value, e);
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public String set(String key, byte[] value, int timeout) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.setex(key.getBytes(), timeout, value);
        } catch (Exception e) {
            log.error(key + ":" + value == null ? "null" : value.toString(), e);
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    public String mset(int timeout, String... keysvalues) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            String statusCode = cache.mset(keysvalues);
            for (int i = 0, len = keysvalues.length; i < len; i += 2) {
                cache.expire(keysvalues[i], timeout);
            }
            return statusCode;
        } catch (Exception e) {
            log.error("mset '" + ArrayUtils.toString(keysvalues) + "' error", e);
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;

    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            log.error(key + ":" + value == null ? "null" : value + " " + nxxx + " " + expx, e);
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public Long decr(String key) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.decr(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public Long incr(String key) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.incr(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public Long del(String key) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            return cache.del(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
        return null;
    }

    @Override
    public <T> List<T> cacheList(CacheRun<List<T>> cacheRun, Class<T> cla) {
        List<T> objList = null;

        String keyOfCachedTagId = cacheRun.generateKey();
        String content = get(keyOfCachedTagId);
        if (StringUtils.isNotBlank(content)) {
            objList = JSON.parseArray(content, cla);
            if (objList == null) {
                objList = Collections.emptyList();
            }
        } else {
            objList = cacheRun.read();
            set(keyOfCachedTagId, JSON.toJSONString(objList), CacheService.CACHE_TIMEOUT);
        }
        return objList;
    }

    @Override
    public <T> T cache(CacheRun<T> cacheRun, Class<T> cla) {
        T object = null;

        String keyOfCachedTagId = cacheRun.generateKey();
        String content = get(keyOfCachedTagId);
        if (StringUtils.isNotBlank(content)) {
            object = JSON.parseObject(content, cla);
        } else {
            object = cacheRun.read();
            set(keyOfCachedTagId, JSON.toJSONString(object), CacheService.CACHE_TIMEOUT);
        }
        return object;
    }

    @Override
    public void delKeysLike(String likeKey) {
        Jedis cache = null;
        try {
            cache = cachePool.getResource();
            Set<String> keys = cache.keys(likeKey + "*");
            if (!NullUtil.isNullObject(keys)) {
                cache.del(keys.toArray(new String[keys.size()]));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        } finally {
            if (cache != null) {
                cache.close();
            }
        }
    }
}
