package com.jf.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by JF on 2016/6/5.
 */
public class RedisTest {

    public static void main(String[] args){

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
    }
}
