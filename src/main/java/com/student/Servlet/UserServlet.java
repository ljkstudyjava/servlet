package com.student.Servlet;

import com.alibaba.fastjson.JSON;
import com.student.Pojo.*;
import com.student.Service.MenuService;
import com.student.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.student.Pojo.Code.SUCCESS_CODE;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final MenuService menuService = new MenuService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        if (method.equals("login")) {
            login(request, response);
        } else if (method.equals("logout")) {
            logout(request, response);
        } else if (method.equals("register")) {
            doRegister(request, response);
        }

    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("开始注册");
        //处理注册请求
        String userName = request.getParameter("userName");
        int sno = Integer.parseInt(request.getParameter("userName"));
        String password = request.getParameter("password");
        String sname = request.getParameter("sname");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");

        DoRegisterInfo doRegisterInfo = new DoRegisterInfo();
        doRegisterInfo.setSno(sno);
        doRegisterInfo.setSname(sname);
        doRegisterInfo.setSex(sex);
        doRegisterInfo.setAddress(address);
        doRegisterInfo.setUserName(userName);
        doRegisterInfo.setPassword(password);

        //交给service处理
        Result result = userService.doRegister(doRegisterInfo);

        if (result.getCODE() == SUCCESS_CODE) {
            System.out.println("注册成功，存入学生信息");
            userService.doInsertStudent(doRegisterInfo);
            try {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }

        request.setAttribute("MSG", result.getMsg());

        try {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
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
        Result result = userService.login(userName, password);
        if (result.getCODE() == Code.Login_Error) {
            request.setAttribute("msg", result.getMsg());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (result.getCODE() == Code.Login_Success) {
//            获取验证码，并比较
            String varify = (String) request.getSession().getAttribute("varify");
            if (varify.equalsIgnoreCase(getVarify)) {
                User user = (User) result.getData();
//            System.out.println(user);
                request.getSession().setAttribute("user", user);
//             传递目录信息
//            获取左侧列表并转成JSON格式，通过Session传递到left.jsp
                List<Menu> leftList = menuService.getLeftList(user.getRoleId());
                String menuList = JSON.toJSONString(leftList);
//                System.out.println(menuList);
                request.getSession().setAttribute("menuList", menuList);
                response.sendRedirect("frame.jsp");
//            request.getRequestDispatcher("frame.jsp").forward(request,response);
            } else {
                request.setAttribute("msg", "验证码错误");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        }
    }
}
