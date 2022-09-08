<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/9/8
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript">
        function deleteUser(cid){
            window.location.href="${pageContext.request.contextPath}/course?method=deleteCourse&cid="+cid;
            //console.log(id);
        }
        function showInfo(cid){
            window.location.href="${pageContext.request.contextPath}/course?method=getCourseInfoById&cid="+cid;
        }
    </script>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <th>课程编号</th>
        <th>课程名</th>
        <th>教师编号</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${courseList}" var="temp">
        <tr>
            <td>${temp.cid}</td>
            <td>${temp.cname}</td>
            <td>${temp.tno}</td>
            <td><a href="javascript:deleteUser(${temp.cid})">删除</a>|<a href="javascript:showInfo(${temp.cid})">修改</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
