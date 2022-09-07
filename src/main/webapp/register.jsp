<%--
  Created by IntelliJ IDEA.
  User: ljk
  Date: 2022/9/7
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UserServlet" method="post">
    ${MSG}<br>
    用户名:<input type="text" name="userName" placeholder="请输入用户名"><br>
    密码:<input type="password" name="password" placeholder="请输入密码"><br>
    姓名:<input type="text" name="sname" placeholder="请输入姓名"><br>
    性别:男:<input type="radio" name="sex" value="男">
        女:<input type="radio" name="sex" value="女"><br>
    地址:<input type="text" name="address" placeholder="请输入地址"><br>
    <input type="submit" value="注册">
    <input type="hidden" name="method" value="register">
</form>
</body>
</html>
