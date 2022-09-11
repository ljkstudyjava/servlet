<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/9/11
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/adminStu" method="post">
  学号：<input type="text" name="sno" ><br>
  学生姓名：<input type="text" name="sname" ><br>
  性别：<input type="text" name="gender" ><br>
  地址：<input type="text" name="address" ><br>


  <input type="submit" value="新增"><br>
  <input type="hidden" name="method" value="addStu">
</form>

</body>
</html>
