package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SysFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        if (uri.endsWith("index.jsp") || uri.endsWith("/")
        || uri.endsWith("/login")) {
            System.out.println("你好");
            //request.getRequestDispatcher("/success.jsp").forward(request,response);
            //非法进入成功页面
        } else {
            HttpSession session = request.getSession();
            if (session != null) {
                Object obj = session.getAttribute("session_account");
                if (obj == null) {
                    //session没有信息 强制跳转到登录页面
                  // response.sendRedirect("/index.jsp");
                    //不要用重定向
                   request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
            }
            //直接放行
            filterChain.doFilter(request,response);
        }
    }
}
