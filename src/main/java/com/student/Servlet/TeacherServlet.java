package com.student.Servlet;

import com.student.Pojo.Teacher;
import com.student.Service.TeacherService;
import com.student.utils.MyUTF;

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
        }else if(method.equals("deleteTea")){
            deleteTea(request,response);
        }else if(method.equals("getTeaByTno")){
            getTeaByTno(request,response);
        }else if(method.equals("updateTea")){
            updateTea(request,response);
        }



    }

//    修改信息
    private void updateTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("charset=utf-8");
        String tnoStr = request.getParameter("tno");
        String tnameStr = request.getParameter("tname");
        String genderStr = request.getParameter("gender");
        String phoneStr = request.getParameter("phone");
//        使用工具类解决中文乱码
//        String tname = new String(tnameStr.getBytes("ISO-8859-1"),"utf-8");
//        String gender = new String(genderStr.getBytes("ISO-8859-1"),"utf-8");
        String tname = MyUTF.getNewString(tnameStr);
        String gender = MyUTF.getNewString(genderStr);
//        System.out.println(tname+"------"+gender);
        int tno = Integer.parseInt(tnoStr);
        int phone = Integer.parseInt(phoneStr);
//        调用修改的service
        int row = teacherService.updateTea(tno,tname,gender,phone);
        if(row > 0){
            getAllTea(request,response);
        }
    }

    //  获取对应的教师信息
    private void getTeaByTno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取教师编号
        String tnoStr = request.getParameter("tno");
        int tno = Integer.parseInt(tnoStr);
//        获取教师教师信息回显到修改页
        Teacher teacher = teacherService.getTeaByTno(tno);
        request.setAttribute("teacher",teacher);
        request.getRequestDispatcher("updateTea.jsp").forward(request,response);
    }
//  删除对应的教师信息
    private void deleteTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tnoStr = request.getParameter("tno");
        int tno = Integer.parseInt(tnoStr);
        int row = teacherService.deleteTea(tno);
        if(row>0){
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