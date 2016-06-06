package com.jf.dao;

import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.ShardedJedis;
/**
 * Created by JF on 2016/6/5.
 */
public class UserRedis {

    private RedisTemplate<String,String> redisTemplate;

    public void set(String key, String value)  {
        redisTemplate.opsForValue().set(key,value);
    }
    public String get(String key)  {
        return redisTemplate.opsForValue().get(key);
    }

}
