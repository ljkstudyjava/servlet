package com.student.Servlet;

import com.student.Pojo.Teacher;
import com.student.Service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equals("getAllTea")){
//            获取教师表所有信息
            getAllTea(request,response);
        }

    }


//    查询所有的教师信息
    private void getAllTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teacherList = teacherService.getAllTea();
//        System.out.println(teacherList);
        request.setAttribute("teacherList",teacherList);
        request.getRequestDispatcher("Teacher.jsp").forward(request,response);
    }
}
