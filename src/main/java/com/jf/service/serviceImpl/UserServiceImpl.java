package com.jf.service.serviceImpl;

import com.jf.dao.UserMapper;
import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(String id) {
        userMapper.delete(id);
    }
}
