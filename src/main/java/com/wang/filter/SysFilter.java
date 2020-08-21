package com.wang.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //过滤器中的为上一层的类型,为了能够取到session,我们要强转为HttpServletResponse和HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //如果session的USER_SESSION字段为空,重定向到error.jsp
        if (request.getSession().getAttribute("USER_SESSION") == null) {
            response.sendRedirect("/error.jsp");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
