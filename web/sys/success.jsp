<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2020/8/21
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Object user_session = request.getSession().getAttribute("USER_SESSION");
    if (user_session == null) {
        response.sendRedirect("/login.jsp");
    }
%>

<h1>主页</h1>

<a href="/Servlet/logout"> 注销</a>

</body>
</html>
