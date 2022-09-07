<%--
  Created by IntelliJ IDEA.
  User: 。soar。
  Date: 2022/9/7
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/GradeTeacherServlet" method="post">
        学生编号:<input type="text" name="sno"  value="${tig.sno}"><br>
        学生姓名:<input type="text" name="sname" value="${tig.sname}"><br>
        课程编号:<input type="text" name="cno" value="${tig.cno}"><br>
        成绩:<input type="text" name="score" value="${tig.score}"><br>
        <input type="submit" value="评分">
        <input type="hidden" name="method" value="updateGrade">
    </form>
</body>
</html>
