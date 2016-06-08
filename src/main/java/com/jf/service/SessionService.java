package com.jf.service;

import java.util.Date;

/**
 * Created by JF on 2016/6/6.
 */
public interface SessionService {

    void add(String sessionId,Date time);

    void get(String sessionId);

    void del(String sessionId);

    void update(String sessionId,Date time);

}
