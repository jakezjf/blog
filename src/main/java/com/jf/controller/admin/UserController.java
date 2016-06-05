package com.jf.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JF on 2016/6/5.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("user.do")
    public String user(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        jedis.lpush("zhong","1");
        jedis.lpush("zhong","2");
        jedis.lpush("zhong","3");
        jedis.lpush("zhong","41");
        jedis.lpush("zhong","5");
        jedis.lpush("zhong","6");
        jedis.lpush("zhong","7");
        List<String> list = jedis.lrange("zhong", 0 ,5);
        model.addAttribute("list",list);
        return "user";
    }
}
