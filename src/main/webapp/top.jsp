<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/7
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{
            display: inline-block;
        }
    </style>
</head>
<body>
    欢迎<h1>${sessionScope.user.userName}</h1>登录&nbsp;
    <a href="${pageContext.request.contextPath}/UserServlet?method=logout" target="_parent">退出登录</a>
</body>
</html>
