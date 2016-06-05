package com.jf.service.serviceImpl;

import com.jf.dao.UserMapper;
import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
 * Created by JF on 2016/6/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    public void insert(User user) {
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
