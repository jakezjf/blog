package com.jf.controller.user;

import com.jf.model.Blog;
import com.jf.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by JF on 2016/6/1.
 */
@Controller
@RequestMapping("index")
public class IndexUserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private BlogService blogService;

    /**
     * 项目首页，遍历项目，书籍，博客
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("/index.jhtml")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        session = request.getSession();
        if (session.getAttribute("type")!=null && session.getAttribute("type").equals("")==false){
            model.addAttribute("type",session.getAttribute("type"));
        }
        List<Blog> blogs = blogService.getBlogs(null);
        model.addAttribute("blogs",blogs);
        return "index/index";
    }



}
