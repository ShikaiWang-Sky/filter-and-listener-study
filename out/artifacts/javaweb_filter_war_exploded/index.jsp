<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2020/8/20
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--
    JSP中,this关键字代表JSP中的page对象
    通过getServletConfig获取Servlet的初始化参数
    通过getServletContext获取Servlet的上下文
    通过getAttribute获取上下文中对应名称的属性值
  --%>
  <h1>当前有 <span style="color: aqua"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span> 人在线</h1>
  </body>
</html>
