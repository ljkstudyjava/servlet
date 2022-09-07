package com.student.Servlet;

import com.alibaba.fastjson.JSON;
import com.student.Pojo.Code;
import com.student.Pojo.Menu;
import com.student.Pojo.Result;
import com.student.Pojo.User;
import com.student.Service.MenuService;
import com.student.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private MenuService menuService = new MenuService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equals("login")){
            login(request,response);
        }else if (method.equals("logout")){
            logout(request,response);
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String getVarify = request.getParameter("varify");
//        用户名和密码在数据库中比较
        Result result = userService.login(userName,password);
        if (result.getCODE() == Code.Login_Error){
            request.setAttribute("msg",result.getMsg());
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if (result.getCODE() == Code.Login_Success){
//            获取验证码，并比较
            String varify = (String) request.getSession().getAttribute("varify");
            if(varify.equalsIgnoreCase(getVarify)){
                User user = (User) result.getData();
//            System.out.println(user);
                request.getSession().setAttribute("user",user);
//             传递目录信息
//            获取左侧列表并转成JSON格式，通过Session传递到left.jsp
                List<Menu> leftList = menuService.getLeftList(user.getRoleId());
                String menuList = JSON.toJSONString(leftList);
//                System.out.println(menuList);
                request.getSession().setAttribute("menuList",menuList);
                response.sendRedirect("frame.jsp");
//            request.getRequestDispatcher("frame.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","验证码错误");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }

        }
    }
}
