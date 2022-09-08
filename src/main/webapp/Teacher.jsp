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
    <c:forEach items="${page.list}" var="teacher">
        <tr>
            <td>${teacher.tno}</td>
            <td>${teacher.tname}</td>
            <td>${teacher.gender}</td>
            <td>${teacher.phone}</td>
            <td><a href="javascript:deleteTea(${teacher.tno})">删除</a>|
                <a href="javascript:updateTea(${teacher.tno})">修改</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${not page.first}">
        <a href="${pageContext.request.contextPath}/TeacherServlet?method=getPages&pageNum=1&pageSize=${page.pageSize}">首页</a>
    </c:if>
    <c:if test="${page.hasPrevious}">
        <a href="${pageContext.request.contextPath}/TeacherServlet?method=getPages&pageNum=${page.pageNum-1}&pageSize=${page.pageSize}">上一页</a>
    </c:if>
    <c:if test="${page.hasNext}">
        <a href="${pageContext.request.contextPath}/TeacherServlet?method=getPages&pageNum=${page.pageNum+1}&pageSize=${page.pageSize}">下一页</a>
    </c:if>
    <c:if test="${not page.last}">
        <a href="${pageContext.request.contextPath}/TeacherServlet?method=getPages&pageNum=${page.pages}&pageSize=${page.pageSize}">尾页</a>
    </c:if>
</table>















    <script type="text/javascript">
        function deleteTea(tno){
            window.location.href = "${pageContext.request.contextPath}/TeacherServlet?method=deleteTea&tno="+tno;
        }
        function updateTea(tno){
            window.location.href = "${pageContext.request.contextPath}/TeacherServlet?method=getTeaByTno&tno="+tno;
        }
    </script>
</body>
</html>
