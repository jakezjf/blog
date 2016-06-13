package com.jf.controller.user;

import com.jf.model.User;
import com.jf.service.UserService;
import com.octo.captcha.service.image.ImageCaptchaService;
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

    @Autowired
    private ImageCaptchaService imageCaptchaService;

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
        user.setUserType(1);
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
    public String captcha(HttpServletRequest request, ModelMap model, HttpServletResponse response,String captcha,User user){
        session = request.getSession();
        System.out.println(captcha);
        System.out.println(request.getSession().getId());
        Boolean isResponseCorrect = imageCaptchaService.validateResponseForID(request.getSession().getId(), captcha);
        if (isResponseCorrect) {
            user = userService.getUser(user);
            if (user!=null){
                return "index/index";
            }else{
                model.addAttribute("error","用户名或密码错误！");
                return "login/login";
            }
        }else{
            model.addAttribute("error","验证码错误！");
            return "login/login";
        }

    }

    /**
     * Ajax调用，检测用户名是否被注册
     * @param request
     * @param model
     * @param response
     * @param user
     */
    @RequestMapping("userId.jhtml")
    public void userId(HttpServletRequest request, ModelMap model, HttpServletResponse response,User user){
        user = userService.getUser(user);
        if (user!=null){
            try {
                response.getWriter().print("true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                response.getWriter().print("false");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 跳到忘记密码
     * @return
     */
    @RequestMapping("forget.jhtml")
    public String forget(){
        return "login/forget";
    }

    /**
     * 验证用户名，姓名
     * @param request
     * @param model
     * @param response
     * @param userId
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping("forgetUpdate.jhtml")
    public String forgetUpdate(HttpServletRequest request, ModelMap model, HttpServletResponse response,String userId,String userName,String userPassword){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user = userService.getUser(user);
        if (user!=null){
            user.setUserPassword(userPassword);
            userService.update(user);
            model.addAttribute("success","修改成功！");
            return "login/login";
        }else {
            model.addAttribute("error","用户名和姓名不匹配！");
            return "login/forget";
        }
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("update.jhtml")
    public String update(){
        return "login/login";
    }

}
