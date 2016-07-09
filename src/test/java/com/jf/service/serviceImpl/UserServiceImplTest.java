package com.jf.service.serviceImpl;

import com.jf.model.User;
import com.jf.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by JF on 2016/6/8.
 */
public class UserServiceImplTest {

    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        ApplicationContext app =new ClassPathXmlApplicationContext("classpath:database-context.xml");
        userService = (UserService) app.getBean("userService");
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetUsers() throws Exception {

    }
}