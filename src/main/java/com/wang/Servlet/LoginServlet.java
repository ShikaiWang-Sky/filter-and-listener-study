package com.wang.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的请求
        String username = req.getParameter("username");

        //如果用户名是admin,则登录成功,将用户信息放到session中
        if (username.equals("admin")) {
            //将键值对为USER_SESSION:当前用户的session id的信息放入session中
            req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
            //重定向,用response,给客户端响应一个url
            //转发用的是request,给服务器响应一个url
            resp.sendRedirect("/sys/success.jsp");
        }else {
            resp.sendRedirect("/error.jsp");
            //登录失败
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
