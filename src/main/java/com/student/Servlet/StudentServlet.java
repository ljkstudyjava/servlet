package com.student.Servlet;

import com.student.Pojo.Course;
import com.student.Pojo.Result;
import com.student.Pojo.Student;
import com.student.Pojo.User;
import com.student.Service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
        } else if (method.equals("selectCourse")) {
            selectCourse(request, response);
        } else if (method.equals("getAllCourse")) {
            getAllCourse(request, response);
        }

    }

    private void getAllCourse(HttpServletRequest request, HttpServletResponse response) {


        //获取登录的账号：学号
        User user = (User) request.getSession().getAttribute("user");

        //获取当前用户编号转为int
        int id = Integer.parseInt(user.getUserName());



        //获取所有选课表
        List<Course> courseList = studentService.getAllCourse(id);

        request.setAttribute("courseList", courseList);

        try {
            request.getRequestDispatcher("selectCourse.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void selectCourse(HttpServletRequest request, HttpServletResponse response) {
        //选课，先展示所有的课表，学生选中课程后将课程号返回，并将其存入
        //前端传回选中的课程号（cid） 拿到cid后，将学号sno 课程号对应的tno插入grade
        //insert into grade  values (?,?,?,?)
        //第一个参数为sno 是登录信息中的
        //第二个参数为tno 是对应课程表中的
        //第三个参数为cno 为cid
        //第四个参数为成绩 默认为null，需要老师填入；


        //获取传过来的值

        //获取课程教师编号tno
        int tnoStr = Integer.parseInt(request.getParameter("tno"));
        //获取课程编号
        int cnoStr = Integer.parseInt(request.getParameter("cno"));

        //获取登录的账号：学号
        User user = (User) request.getSession().getAttribute("user");

        //获取当前用户编号转为int
        int id = Integer.parseInt(user.getUserName());

        //将数据传回service处理选课不重复
        Result result = studentService.selectCourse(id, tnoStr, cnoStr);

        request.setAttribute("selectCourseMsg", result.getMsg());

        getAllCourse(request, response);
        try {
            request.getRequestDispatcher("selectCourse.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
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

        request.setAttribute("scoreList", result.getData());

        try {
            request.getRequestDispatcher("score.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
