package com.student.Servlet;

import com.student.Pojo.Result;
import com.student.Pojo.Student;
import com.student.Pojo.User;
import com.student.Service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 学生模块
 * 主要功能有查看选课信息和选课
 */

@WebServlet(name = "StudentServlet", value = "/stu")
public class StudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        //前端传回方法
        String method = request.getParameter("method");

        if (method == null || "".equals(method)) {
            response.sendRedirect("main.jsp");
        } else if (method.equals("getMyCourse")) {
            getMyCourse(request, response);
        }

    }

    /**
     * 查看个人选课信息
     */
    private void getMyCourse(HttpServletRequest request, HttpServletResponse response) {

        //获取登录的账号：学号
        User user = (User) request.getSession().getAttribute("user");

        Student student = new Student();

        //拿到学生的学号
        student.setSno(Integer.parseInt(user.getUserName()));

        //查看自己的课表

        Result result = studentService.getMyCourse(student.getSno());

        System.out.println(result.getData().toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
