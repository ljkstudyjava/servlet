<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/7
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教授的学生信息</title>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <th>学生学号</th>
        <th>学生姓名</th>
        <th>课程编号</th>
        <th>成绩</th>
        <th>打分</th>
    </tr>
    <c:forEach items="${GradeTeacherList}" var="grade">
        <tr>
            <td>${grade.sno}</td>
            <td>${grade.sname}</td>
            <td>${grade.cno}</td>
            <td>${grade.score}</td>
            <td><a href="javascript:updateScore('${grade.sno}','${grade.cno}')">评分</a></td>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">
    function updateScore(sno,cno){
        window.location.href="${pageContext.request.contextPath}/GradeTeacherServlet?method=updateScore&sno="+sno+"&cno="+cno;
    }
</script>
</body>
</html>
