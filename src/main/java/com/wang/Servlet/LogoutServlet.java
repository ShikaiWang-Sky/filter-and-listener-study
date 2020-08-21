package com.wang.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得session中USER_SESSION的值
        Object user_session = req.getSession().getAttribute("USER_SESSION");

        if (user_session != null) {
            //注销,移除session中存放的USER_SESSION属性
            req.getSession().removeAttribute("USER_SESSION");
            //注销后重定向到登录页面
            resp.sendRedirect("/login.jsp");
        }else {
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
