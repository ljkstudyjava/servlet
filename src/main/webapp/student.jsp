<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/9/11
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <script type="text/javascript">
        function deleteUser(sno){
            window.location.href="${pageContext.request.contextPath}/adminStu?method=deleteStu&sno="+sno;
            //console.log(id);
        }
       function showInfo(sno){
          window.location.href="${pageContext.request.contextPath}/adminStu?method=getStuInfo&sno="+sno;
        }
    </script>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <th>学号</th>
        <th>学生姓名</th>
        <th>性别</th>
        <th>地址</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${studentList}" var="temp">
        <tr>
            <td>${temp.sno}</td>
            <td>${temp.sname}</td>
            <td>${temp.gender}</td>
            <td>${temp.address}</td>
            <td><a href="javascript:deleteUser(${temp.sno})">删除</a>|<a href="javascript:showInfo(${temp.sno})">修改</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
