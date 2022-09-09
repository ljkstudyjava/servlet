package com.student.Servlet;

import com.student.Pojo.BaseQuery;
import com.student.Pojo.Page;
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
        if (method.equals("getPages")){
//            获取教师表所有信息
            getPages(request,response);
        }else if(method.equals("deleteTea")){
            deleteTea(request,response);
        }else if(method.equals("getTeaByTno")){
            getTeaByTno(request,response);
        }else if(method.equals("updateTea")){
            updateTea(request,response);
        }else if(method.equals("addTea")){
            addTea(request,response);
        }
//        原本的查询所有方法
//        else if(method.equals("getPages")){
//            getPages(request,response);
//        }



    }

    private void getPages(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
//        System.out.println(pageNumStr);
//        System.out.println(pageSizeStr);
//        System.out.println("-------");
        BaseQuery baseQuery = new BaseQuery();

        if(pageNumStr!=null && !"".equals(pageNumStr)){
            baseQuery.setPageNum(Integer.parseInt(pageNumStr));
        }
        if(pageSizeStr!=null && !"".equals(pageSizeStr)){
            baseQuery.setPageSize(Integer.parseInt(pageSizeStr));
        }

        List<Teacher> teacherList = teacherService.getPages(baseQuery);
//        System.out.println(teacherList);
        Page<Teacher> page = new Page<>();
        page.setList(teacherList);
        page.setPageNum(baseQuery.getPageNum());
        page.setPageSize(baseQuery.getPageSize());
        int total = teacherService.getTotal();
//        System.out.println(total+"--------");
//        System.out.println(page.getPageNum());
//        System.out.println(page.getPageSize());
        page.setTotal(total);
//        ps代表每个分页的条数
        int ps = baseQuery.getPageSize();
        int pages = 0;
        if(total % ps == 0){
            pages = total / ps;
        }else {
            pages = total / ps + 1;
        }
        page.setPages(pages);


        request.setAttribute("page",page);
        request.getRequestDispatcher("Teacher.jsp").forward(request,response);


    }

    private void addTea(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tnoStr = request.getParameter("tno");
        String tnameStr = request.getParameter("tname");
        String genderStr = request.getParameter("gender");
        String phoneStr = request.getParameter("phone");
        String password = request.getParameter("password");

        String tname = MyUTF.getNewString(tnameStr);
        String gender = MyUTF.getNewString(genderStr);

        int tno = Integer.parseInt(tnoStr);
        int phone = Integer.parseInt(phoneStr);
        int row = teacherService.addTea(tno,tname,gender,phone,password);
        if(row > 0){
            getPages(request,response);
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
            getPages(request,response);
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
            getPages(request,response);
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
