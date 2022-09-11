package com.student.Servlet;

import com.student.Dao.AdminStuDao;
import com.student.Pojo.Code;
import com.student.Pojo.Result;
import com.student.Pojo.Student;
import com.student.Service.AdminStuService;
import com.student.utils.MyUTF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "AdminStuServlet", value = "/adminStu")
public class AdminStuServlet extends HttpServlet {
    public static final long serialVersionUID=1L;
    private AdminStuService adminStuService=new AdminStuService();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if (method!=null&&!"".equals(method.trim())){
            if (method.equals("getStuList")) {
                try {
                    getStuList(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("addStu")){
                try {
                    addStu(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("deleteStu")){
                try {
                    deleteStu(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("getStuInfo")){
                try {
                    getStuInfo(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("updateStu")){
                try {
                    updateStu(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }





    }

    private void updateStu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String snoStr=request.getParameter("sno");
        String snameStr=request.getParameter("sname");
        String genderStr=request.getParameter("gender");
        String addrStr=request.getParameter("address");

        String sname= MyUTF.getNewString(snameStr);
        String gender=MyUTF.getNewString(genderStr);
        String address=MyUTF.getNewString(addrStr);
        int sno=Integer.parseInt(snoStr);
        int row=adminStuService.updateStu(sno,sname,gender,address);
        if (row>0){
            getStuList(request,response);
        }

    }

    private void getStuInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String snoStr=request.getParameter("sno");
        int sno=Integer.parseInt(snoStr);
        Student student=adminStuService.getStuInfo(sno);
        request.setAttribute("student",student);
        request.getRequestDispatcher("editStu.jsp").forward(request,response);
    }

    private void deleteStu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String snoStr=request.getParameter("sno");
        int sno=Integer.parseInt(snoStr);
        Result result =adminStuService.deleteStu(sno);
        if (result.getCODE()== Code.SUCCESS_CODE){
            List<Student> studentList=adminStuService.getStuList();
            request.setAttribute("studentList",studentList);
            request.getRequestDispatcher("student.jsp").forward(request,response);
        }
    }

    private void addStu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String snoStr=request.getParameter("sno");
        String snameStr=request.getParameter("sname");
        String genderStr=request.getParameter("gender");
        String addrStr=request.getParameter("address");

        String sname= MyUTF.getNewString(snameStr);
        String gender=MyUTF.getNewString(genderStr);
        String address=MyUTF.getNewString(addrStr);
        int sno=Integer.parseInt(snoStr);
        int row=adminStuService.addStu(sno,sname,gender,address);
        if (row>0){
            getStuList(request,response);
        }

    }

    private void getStuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> studentList= adminStuService.getStuList();
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("student.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
