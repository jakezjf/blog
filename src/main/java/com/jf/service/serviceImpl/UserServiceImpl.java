package com.jf.service.serviceImpl;

import com.jf.dao.UserMapper;
import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


/**
 * Created by JF on 2016/6/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    protected RedisTemplate<Serializable, Serializable> redisTemplate;
    @Autowired
    private UserMapper userMapper;

    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    public void insert(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserId()),
                        redisTemplate.getStringSerializer().serialize(user.getUserName()));
                return null;
            }
        });

//        ShardedJedis jedis =  shardedJedisPool.getResource();
//        jedis.set(user.getUserId(),user.getUserName());
      //  userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(String id) {
        userMapper.delete(id);
    }
}
