package com.jf.service;

/**
 * Created by JF on 2016/6/8.
 */
public interface Jedis {


    void insert(String key,String value);

    String getValue(String key);

}
