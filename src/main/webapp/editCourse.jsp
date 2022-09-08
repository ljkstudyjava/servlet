<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/9/8
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/course" method="post">
  课程编号：<input type="text" name="cid" value="${course.cid}" readonly="readonly"><br>
  课程名：<input type="text" name="cname" value="${course.cname}"><br>
  教师编号：<input type="text" name="tno" value="${course.tno}"><br>

  <input type="submit" value="修改">
  <input type="hidden" name="method" value="updateCourse">
</form>

</body>
</html>
