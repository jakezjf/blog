package com.jf.controller.admin;

import com.jf.dao.UserRedis;
import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JF on 2016/6/5.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRedis redis;

    @RequestMapping("user.do")
    public String user(HttpServletRequest request, ModelMap model, HttpServletResponse response){


//        User user = new User();
//        user.setUserId("1");
//        user.setUserName("z");
//        userService.insert(user);
//        user.setUserId("2");
//        user.setUserName("j");
//        userService.insert(user);
//        user.setUserId("3");
//        user.setUserName("f");
//        userService.insert(user);
//        user.setUserId("6");
//        user.setUserName("b");
//        userService.insert(user);
//        user.setUserId("5");
//        user.setUserName("j");
//        userService.insert(user);
        return "user";
    }
}
