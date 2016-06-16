package com.jf.controller.admin;

import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by JF on 2016/6/16.
 */
@Controller
@RequestMapping("/user")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("index.do")
    public String index(){

        return "user/userList";
    }
}
