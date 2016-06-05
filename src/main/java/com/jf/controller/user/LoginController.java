package com.jf.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

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
    private HttpSession session;

    @RequestMapping("/login.jhtml")
    public String login(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
        session = request.getSession();
        if (session.getAttribute("id")!=null && session.getAttribute("id").equals("")==false){
            return "redirect:";
        }
        return "login/login";
    }

    @RequestMapping("logout.jhtml")
    public String logout(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
        session.removeAttribute("id");
        session.removeAttribute("type");
        return "login/login";
    }

}
