package com.jf.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JF on 2016/6/1.
 */
@Controller
@RequestMapping("index")
public class IndexUserController {

    @Autowired
    private HttpSession session;

    @RequestMapping("/index.jhtml")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        session = request.getSession();
        if (session.getAttribute("type")!=null && session.getAttribute("type").equals("")==false){
            model.addAttribute("type",session.getAttribute("type"));
        }
        return "index/index";
    }



}
