package com.student.Filter;


import com.student.Pojo.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User) req.getSession().getAttribute("user");
        String uri = req.getRequestURI();
        if (uri.indexOf("register.jsp") != -1 || uri.indexOf("index.jsp") != -1 || uri.indexOf("varifyCodeServlet")!=-1 ){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(uri.indexOf("UserServlet")!=-1){
            String method = req.getParameter("method");
            if(method.equals("register") || method.equals("login")){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        if(user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else {
            req.setAttribute("msg","你还未登录");
            req.getRequestDispatcher("index.jsp").forward(req,servletResponse);
        }

    }

    public void destroy() {

    }
}
