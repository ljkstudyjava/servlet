package com.student.Servlet;

import com.student.Pojo.TeacherInfoGrade;
import com.student.Pojo.User;
import com.student.Service.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GradeTeacherServlet")
public class GradeTeacherServlet extends HttpServlet {
    private GradeService gradeService =new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equals("TeaGetGrade")){
            get(request,response);
        }else if(method.equals("updateScore")){
            update(request,response);
        }else if(method.equals("updateGrade")){
            updateGrade(request,response);
        }


    }

    private void updateGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String snoStr = request.getParameter("sno");
        String cnoStr = request.getParameter("cno");
        String scoreStr = request.getParameter("score");
        int sno = Integer.parseInt(snoStr);
        int cno = Integer.parseInt(cnoStr);
        Double score = Double.valueOf(scoreStr);
//        System.out.println(score);
        int row = gradeService.updateGrade(sno,cno,score);
//        System.out.println(row);
        if (row > 0){
            get(request,response);
        }
    }

//    通过回显数据中的学生编号和课程标号来确定需要修改的行
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cnoStr = request.getParameter("cno");
        String snoStr = request.getParameter("sno");
//        System.out.println(cnoStr+"-------"+snoStr);
        int sno = Integer.parseInt(snoStr);
        int cno = Integer.parseInt(cnoStr);
        TeacherInfoGrade tig = gradeService.getBySnoAndCno(sno,cno);
//        System.out.println(tig);
        request.setAttribute("tig",tig);
        request.getRequestDispatcher("updateGrade.jsp").forward(request,response);

    }

//    获取教师班级学生的成绩

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.toString());
        List<TeacherInfoGrade> GradeTeacherList =  gradeService.getAllByTno(user.getUserName());
        request.setAttribute("GradeTeacherList",GradeTeacherList);
        request.getRequestDispatcher("gradeTea.jsp").forward(request,response);
    }
}
