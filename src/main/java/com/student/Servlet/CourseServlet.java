package com.student.Servlet;

import com.student.Pojo.Code;
import com.student.Pojo.Course;
import com.student.Pojo.Result;
import com.student.Service.Course2Service;
import com.student.utils.MyUTF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "CourseServlet", value = "/course")
public class CourseServlet extends HttpServlet {
    public static final long serialVersionUID=1L;
    private Course2Service course2Service=new Course2Service();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if (method!=null&&!"".equals(method.trim())){
            if (method.equals("getCourseList")){
                try {
                    getCourseList(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("deleteCourse")){
                try {
                    deleteCourse(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("getCourseInfoById")){
                try {
                    getCourseInfoById(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("updateCourse")){
                try {
                    updateCourse(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (method.equals("addCourse")){
                try {
                    addCourse(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cidStr=request.getParameter("cid");
        String cnameStr=request.getParameter("cname");
        String tnoStr=request.getParameter("tno");

        String cname = MyUTF.getNewString(cnameStr);

        int cid=Integer.parseInt(cidStr);

        int tno=Integer.parseInt(tnoStr);
        int row = course2Service.addCourse(cid,cname,tno);
        if(row > 0){
            getCourseList(request,response);
        }
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cidStr=request.getParameter("cid");
        String cnameStr=request.getParameter("cname");
        String tnoStr=request.getParameter("tno");

        String cname = MyUTF.getNewString(cnameStr);
        int cid=Integer.parseInt(cidStr);
        int tno=Integer.parseInt(tnoStr);
        int row = course2Service.updateCourse(cid,cname,tno);
        if(row > 0){
            getCourseList(request,response);
        }
    }


    private void getCourseInfoById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cidStr=request.getParameter("cid");
        int cid=Integer.parseInt(cidStr);
        Course course=course2Service.getUserInfoById(cid);
        request.setAttribute("course",course);
        request.getRequestDispatcher("editCourse.jsp").forward(request,response);
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cidStr=request.getParameter("cid");
        int cid=Integer.parseInt(cidStr);
        Result result=course2Service.deleteById(cid);
        if (result.getCODE()== Code.SUCCESS_CODE){
            List<Course> courseList=course2Service.getCourseList();
            request.setAttribute("courseList",courseList);
            request.getRequestDispatcher("courseInfo.jsp").forward(request,response);
        }
    }

    private void getCourseList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Course> courseList= course2Service.getCourseList();
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("courseInfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
