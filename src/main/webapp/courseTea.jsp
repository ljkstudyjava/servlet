<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/7
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教授的课程</title>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>教师编号</th>
    </tr>
    <c:forEach items="${courseTeacherList}" var="course">
        <tr>
            <td>${course.cid}</td>
            <td>${course.cname}</td>
            <td>${course.tno}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
