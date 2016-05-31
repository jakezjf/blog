package com.jf.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JF on 2016/5/30.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public HttpSession session;

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
        return "login/login";
    }

    @RequestMapping("logout.do")
    public String logout(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
        return "";
    }

}
