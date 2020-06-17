package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session!=null){
            Object obj = session.getAttribute("session_account");
            if (obj!=null){
                resp.sendRedirect("/success.jsp");
                return;
            }
        }
        //非法登录 强制跳转到登录页面
        resp.sendRedirect("/index.jsp");
    }
}
