package com.jf.controller.admin;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */

@Controller
@RequestMapping("/blog")
public class blogAdminController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;


    /**
     * 遍历博客
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("index.do")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        List<Blog> blogs = blogService.getBlogs(null);
        if (blogs.size()>0){
            for (int i=0;i<blogs.size();i++){
                blogs.get(i).setTypeName(blogTypeService.getBlogTypeName(blogs.get(i).getBlogType()));
            }
        }
        model.addAttribute("blogs",blogs);
        return "blog/blogList";
    }


    /**
     * 跳到登录界面
     * @param blog
     * @param model
     * @return
     */
    @RequestMapping("toUpdate.do")
    public String toUpdate(Blog blog,ModelMap model){
        List<BlogType> blogTypes = blogTypeService.getBlogTypeAll(null);
        model.addAttribute("blogTypes",blogTypes);
        blog = blogService.getBlog(blog);
        model.addAttribute("blog",blog);
        return "blog/update";
    }


    /**
     * 修改功能
     * @param blog
     * @param addTimeString
     * @return
     */
    @RequestMapping("update.do")
    public String update(Blog blog,String addTimeString){
        if (addTimeString!=null && addTimeString.equals("")==false){
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(addTimeString);
                blog.setAddTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        blogService.update(blog);
        return "redirect:index.do";
    }

    /**
     *跳到添加界面
     * @param model
     * @return
     */
    @RequestMapping("toAdd.do")
    public String toAdd(ModelMap model){
        List<BlogType> blogTypes = blogTypeService.getBlogTypeAll(null);
        model.addAttribute("blogTypes",blogTypes);
        return "blog/add";
    }

    /**
     * 添加功能
     * @param blog
     * @param addTimeString
     * @return
     */
    @RequestMapping("add.do")
    public String add(Blog blog,String addTimeString){
        if (addTimeString.equals("")==false && addTimeString!=null){
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(addTimeString);
                blog.setAddTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        blogService.insert(blog);
        return "redirect:index.do";
    }




}
