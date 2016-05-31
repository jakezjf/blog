package com.jf.common.session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JF on 2016/5/30.
 */
public class UserSessionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.do");
        //设置如果没有登陆将要转发到的页面
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        if (session.getAttribute("id") == null && session.getAttribute("type") == null) {
            dispatcher.forward(request, response);
            //跳转到登录界面
            res.setHeader("Cache-Control", "no-store");
            res.setDateHeader("Expires", 0);
            res.setHeader("Pragma", "no-cache");
        } else {
            int type = (Integer) session.getAttribute("type");
            if (type == 1) {
                chain.doFilter(request, response);
                // 已经登陆,继续此次请求
            } else {
                dispatcher.forward(request, response);
                //跳转到登录界面
                res.setHeader("Cache-Control", "no-store");
                res.setDateHeader("Expires", 0);
                res.setHeader("Pragma", "no-cache");
            }
        }
    }

    public void destroy() {

    }
}
