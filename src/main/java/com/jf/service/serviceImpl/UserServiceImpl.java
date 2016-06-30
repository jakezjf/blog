package com.jf.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.jf.common.page.BeanUtil;
import com.jf.common.page.PagedResult;
import com.jf.dao.UserMapper;
import com.jf.dao.UserRedis;
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
import java.util.List;


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

//    public User getUser(final User user) {
//        return redisTemplate.execute(new RedisCallback<User>() {
//            public User doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                byte[] key = redisTemplate.getStringSerializer().serialize(user.getUserId());
//                if (redisConnection.exists(key)){
//                    byte[] value = redisConnection.get(key);
//                    String userName = redisTemplate.getStringSerializer().deserialize(value);
//                    if (userName!=null){
//                        user.setUserName(userName);
//                        return user;
//                    }else{
//                        return null;
//                    }
//                }
//                return userMapper.getUser(user);
//            }
//        });
//    }

    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    public void insert(User user) {
        user.setUserType(1);
        userMapper.insert(user);
    }

//    public void update(final User user) {
//        redisTemplate.execute(new RedisCallback<Object>() {
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserId()),
//                        redisTemplate.getStringSerializer().serialize(user.getUserName()));
//                return null;
//            }
//        });
//        userMapper.update(user);
//    }

    public void update(final User user) {
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

    /**
     * 插入
     * @param user
     */
    public void insertRedis(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserId()),
                        redisTemplate.getStringSerializer().serialize(user.getUserName()));
                return null;
            }
        });
    }

    public void updateRedis(final User user) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize(user.getUserId()),
                        redisTemplate.getStringSerializer().serialize(user.getUserName()));
                return null;
            }
        });
    }

    public User getUserRedis(User user) {
        return null;
    }

    public void deleteRedis(User user) {

    }

    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

    /**
     * 模糊搜索
     * @param user
     * @return
     */
    public List<User> getUserSearch(User user) {
        return userMapper.getUserSearch(user);
    }

    /**
     * 模糊搜索
     * @param param
     * @return
     */
    public List<User> getUserSearchString(String param) {
        return userMapper.getUserSearchString(param);
    }
}
