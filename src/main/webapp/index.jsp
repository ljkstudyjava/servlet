<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/6
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>欢迎登陆登录</h1>
<form action="${pageContext.request.contextPath}/UserServlet" method="post">
    ${msg}<br>
    用户名:<input type="text" name="userName" placeholder="请输入用户名"><br>
    密码:<input type="password" name="password" placeholder="请输入密码"><br>
    验证码:<input type="text" name="varify" placeholder="请输入验证码">
    <a href=""><img src="${pageContext.request.contextPath}/varifyCodeServlet" alt="验证码"></a><br>
    <input type="submit" value="登录">
    <a href="register.jsp"><input type="button" value="注册"></a>
    <input type="hidden" name="method" value="login">
</form>
</body>
</html>
