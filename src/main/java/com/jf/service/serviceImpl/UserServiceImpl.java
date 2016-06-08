package com.jf.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.jf.common.page.BeanUtil;
import com.jf.common.page.PagedResult;
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

//    @Autowired
//    private ListOperations<String, String> listOps;

    

    @Autowired
    private UserMapper userMapper;

    public User getUser(final User user) {
        return redisTemplate.execute(new RedisCallback<User>() {
            public User doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(user.getUserId());
                if (redisConnection.exists(key)){
                    byte[] value = redisConnection.get(key);
                    String userName = redisTemplate.getStringSerializer().deserialize(value);

                }
                return null;
            }
        });
//        return userMapper.getUser(user);
    }

    public void insert(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserId()),
                        redisTemplate.getStringSerializer().serialize(user.getUserName()));
                return null;
            }
        });
        userMapper.insert(user);
    }

    public void update(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserId()),
                        redisTemplate.getStringSerializer().serialize(user.getUserName()));
                return null;
            }
        });
        userMapper.update(user);
    }

    public void delete(User user) {
        userMapper.delete(user);
    }

    public PagedResult<User> getUsers(User user, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return null;
    }
}
