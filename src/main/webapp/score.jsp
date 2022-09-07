<%--
  Created by IntelliJ IDEA.
  User: ljk
  Date: 2022/9/7
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生成绩信息</title>
</head>
<body>

<table border="1" cellspacing="0">
    <tr>
        <th>课程名称</th>
        <th>课程编号</th>
        <th>教师姓名</th>
        <th>成绩</th>
    </tr>
    <c:forEach items="${scoreList}" var="score">
        <tr>
            <td>${score.cname}</td>
            <td>${score.cid}</td>
            <td>${score.tname}</td>
            <td>${score.score}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
