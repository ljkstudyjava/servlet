<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/8
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TeacherServlet" method="post">
    教师编号：<input type="text" name="tno" placeholder="请输入六位教师编号"><br>
    教师姓名：<input type="text" name="tname"><br>
    性别：<input type="text" name="gender" ><br>
    手机号：<input type="text" name="phone" ><br>
    密码:<input type="text" name="password">
    <input type="submit" value="新增">
    <input type="hidden" name="method" value="addTea">
</form>
</body>
</html>
