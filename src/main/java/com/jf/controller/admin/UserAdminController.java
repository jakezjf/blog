package com.jf.controller.admin;

import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JF on 2016/6/5.
 */
@Controller
@RequestMapping("/index")
public class UserAdminController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserRedis redis;

    @RequestMapping("user.do")
    public String user(HttpServletRequest request, ModelMap model, HttpServletResponse response){

//
        return "user";
    }

    @RequestMapping("index.do")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        return "index/index";
    }

    @RequestMapping("shouye.do")
    public String shouye(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        return "index/shouye";
    }

}
