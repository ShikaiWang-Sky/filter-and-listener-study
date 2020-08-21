<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2020/8/21
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--action:提交后,会跳转到对应的页面--%>
<form action="Servlet/login" method="post">
    <input type="text" name="username">
    <input type="submit">
</form>

</body>
</html>
