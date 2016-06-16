package com.jf.service.serviceImpl;

import com.jf.service.Jedis;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JF on 2016/6/8.
 */
@Service
@Transactional
public class JedisImpl implements Jedis {


    public void insert(String key, String value) {
    }

    public String getValue(String key) {
        return null;
    }
}
