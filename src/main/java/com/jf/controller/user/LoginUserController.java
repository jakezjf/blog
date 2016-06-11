package com.jf.controller.user;

import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JF on 2016/5/30.
 */
@Controller
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    /**
     * 登录验证
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("/login.jhtml")
    public String login(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
        session = request.getSession();
        if (session.getAttribute("id")!=null && session.getAttribute("id").equals("")==false){
            return "redirect:";
        }
        return "login/login";
    }

    /**
     * 退出，销毁session
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("logout.jhtml")
    public String logout(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
        session.removeAttribute("id");
        session.removeAttribute("type");
        return "login/login";
    }

    /**
     * 注册功能
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("register.jhtml")
    public String register(HttpServletRequest request, ModelMap model, HttpServletResponse response, User user){
        userService.insert(user);
        return "login/login";
    }

    /**
     * 验证账号，密码，验证码
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("captcha.jhtml")
    public String captcha(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        return "";
    }

    @RequestMapping("userId.jhtml")
    public void userId(HttpServletRequest request, ModelMap model, HttpServletResponse response,User user){
        user = userService.getUser(user);
        if (user!=null){
            try {
                response.getWriter().print("true");
                System.out.println("true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                response.getWriter().print("false");
                System.out.println("false");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
