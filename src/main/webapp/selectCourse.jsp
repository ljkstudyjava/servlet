<%--
  Created by IntelliJ IDEA.
  User: ljk
  Date: 2022/9/7
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选课页面</title>
</head>
<body>

<table border="1" cellspacing="0">
    <tr>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>教师编号</th>
        <th>选课</th>
    </tr>
    <c:forEach items="${courseList}" var="course">
        <tr>
            <td>${course.cid}</td>
            <td>${course.cname}</td>
            <td>${course.tno}</td>
            <td><a href="${pageContext.request.contextPath}/stu?method=selectCourse&tno=${course.tno}&cno=${course.cid}"
            >选课</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
