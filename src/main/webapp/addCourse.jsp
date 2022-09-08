<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/9/8
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/course" method="post">
  课程编号：<input type="text" name="cid" ><br>
  课程名：<input type="text" name="cname" ><br>
  教师编号：<input type="text" name="tno" ><br>

  <input type="submit" value="新增"><br>
  <input type="hidden" name="method" value="addCourse">
</form>

</body>
</html>
