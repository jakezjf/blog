package com.jf.service;

import com.jf.common.page.PagedResult;
import com.jf.model.User;

/**
 * Created by JF on 2016/6/1.
 */
public interface UserService {

    User getUser(User user);

    void insert(User user);

    void update(User user);

    void delete(User user);

    PagedResult<User> getUsers(User user,Integer pageNo,Integer pageSize);
}
