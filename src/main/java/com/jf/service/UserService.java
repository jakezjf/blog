package com.jf.service;

import com.jf.common.page.PagedResult;
import com.jf.model.User;

import java.util.List;

/**
 * Created by JF on 2016/6/1.
 */
public interface UserService {

    User getUser(User user);

    void insert(User user);

    void update(User user);

    void delete(User user);

    PagedResult<User> getUsers(User user,Integer pageNo,Integer pageSize);

    void insertRedis(User user);

    void updateRedis(User user);

    User getUserRedis(User user);

    void deleteRedis(User user);

    List<User> getUsers(User user);

    List<User> getUserSearch(User user);

    List<User> getUserSearchString(String param);

}
