package com.student.Servlet;

import com.student.Pojo.Course;
import com.student.Pojo.User;
import com.student.Service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseTeacherServlet")
public class CourseTeacherServlet extends HttpServlet {
    private CourseService courseService = new CourseService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.toString());
        List<Course> courseTeacherList = courseService.getAllByTno(user.getUserName());
        request.setAttribute("courseTeacherList",courseTeacherList);
        request.getRequestDispatcher("courseTea.jsp").forward(request,response);

    }
}
