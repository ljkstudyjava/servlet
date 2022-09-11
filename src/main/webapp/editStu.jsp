<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/9/11
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/adminStu" method="post">
    学号：<input type="text" name="sno" value="${student.sno}" ><br>
    学生姓名：<input type="text" name="sname" value="${student.sname}"><br>
    性别：<input type="text" name="gender" value="${student.gender}"><br>
    地址：<input type="text" name="address" value="${student.address}"><br>

    <input type="submit" value="修改">
    <input type="hidden" name="method" value="updateStu">
</form>

</body>
</html>
