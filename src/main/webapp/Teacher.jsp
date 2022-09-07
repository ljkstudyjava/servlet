<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/7
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理</title>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <th>教师编号</th>
        <th>教师姓名</th>
        <th>性别</th>
        <th>手机号</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${teacherList}" var="teacher">
        <tr>
            <td>${teacher.tno}</td>
            <td>${teacher.tname}</td>
            <td>${teacher.gender}</td>
            <td>${teacher.phone}</td>
            <td><a href="">删除</a>|
                <a href="">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
