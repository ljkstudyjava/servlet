<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/8
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师信息页</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/TeacherServlet" method="post">
        教师编号：<input type="text" name="tno" value="${teacher.tno}" readonly="readonly"><br>
        教师姓名：<input type="text" name="tname" value="${teacher.tname}"><br>
        性别：<input type="text" name="gender" value="${teacher.gender}"><br>
        手机号：<input type="text" name="phone" value="${teacher.phone}"><br>
        <input type="submit" value="修改">
        <input type="hidden" name="method" value="updateTea">
    </form>

</body>
</html>
