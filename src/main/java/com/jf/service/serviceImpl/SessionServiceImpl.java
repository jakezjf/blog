package com.jf.service.serviceImpl;

import com.jf.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by JF on 2016/6/7.
 */
@Service
@Transactional
public class SessionServiceImpl implements SessionService {

//    @Autowired   不支持注入
//    private ZSetOperations<String,Date> zSetOperations;


    public void add(String sessionId, Date time) {
    }

    public void get(String sessionId) {

    }

    public void del(String sessionId) {

    }

    public void update(String sessionId, Date time) {

    }
}
