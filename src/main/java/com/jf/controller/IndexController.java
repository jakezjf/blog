package com.jf.controller;

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
public class IndexController {

    @Autowired
    private HttpSession session;

    @RequestMapping("/index.jhtml")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
//        session = request.getSession();
//        if (session.getAttribute("type")!=null && session.getAttribute("type").equals("")==false){
//            if (session.getAttribute("id")!=null && session.getAttribute("id").equals("")==false){
//
//                model.addAttribute("id");
//            }
//            model.addAttribute("type",session.getAttribute("type"));
//        }
        return "index/index";
    }



}
