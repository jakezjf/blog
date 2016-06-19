package com.jf.controller.user;

import com.jf.model.Blog;
import com.jf.model.BlogType;
import com.jf.service.BlogService;
import com.jf.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JF on 2016/6/19.
 */
@Controller
@RequestMapping("/blog")
public class BlogUserController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;

    @RequestMapping("index.jhtml")
    public  String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        List<Blog> blogs = blogService.getBlogs(null);
        model.addAttribute("blogs",blogs);
        List<BlogType> blogTypes = blogTypeService.getBlogTypeAll(null);
        model.addAttribute("blogTypes",blogTypes);
        return "blog/index";
    }

}
