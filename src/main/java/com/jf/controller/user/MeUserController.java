package com.jf.controller.user;

import com.jf.model.Blog;
import com.jf.model.User;
import com.jf.service.BlogService;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by JF on 2016/6/19.
 */
@Controller
@RequestMapping("/me")
public class MeUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private BlogService blogService;

    /**
     * 判断session权限，如果用session则遍历博客内容
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("index.jhtml")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        session = request.getSession();
        if (session.getAttribute("type")!=null && session.getAttribute("type").equals("")==false){
            model.addAttribute("type",session.getAttribute("type"));
        }
        if (session.getAttribute("id")!=null && session.getAttribute("id").equals("")==false){
            User user = new User();
            user.setUserId((String)session.getAttribute("id"));
            user = userService.getUser(user);
            if (user!=null){
                model.addAttribute("user",user);
            }
        }
        List<Blog> blogs = blogService.getBlogs(null);
        model.addAttribute("blogs",blogs);
        return "me/index";
    }


    /**
     * 更新个人的信息
     * @param request
     * @param model
     * @param response
     * @param user
     * @return
     */
    @RequestMapping("update.jhtml")
    public String update(HttpServletRequest request, ModelMap model, HttpServletResponse response,User user){
            userService.update(user);
        return "redirect:index.jhtml";
    }

}
