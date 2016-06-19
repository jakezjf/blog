package com.jf.controller.admin;

import com.jf.model.User;
import com.jf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    /**
     * 遍历用户信息
     * @param model
     * @return
     */
    @RequestMapping("index.do")
    public String index(ModelMap model){
        List<User> users = userService.getUsers(null);
        model.addAttribute("users",users);
        return "user/userList";
    }

    /**
     * 跳到添加页面
     * @return
     */
    @RequestMapping("toAdd.do")
    public String toAdd(){
        return "user/add";
    }

    /**
     * 跳到修改界面
     * @return
     */
    @RequestMapping("toUpdate.do")
    public String toUpdate(){
        return "user/update";
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("update.do")
    public String update(User user){
        userService.update(user);
        return "redirect:index.do";
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("add.do")
    public String add(User user){
        userService.insert(user);
        return "redirect:index.do";
    }

    @RequestMapping("delete.do")
    public String delete(User user){
        userService.delete(user);
        return "redirect:index.do";
    }




}
