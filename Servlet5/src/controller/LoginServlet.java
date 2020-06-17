package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        System.out.println("你好");
        if("gem".equals(account) || "0816".equals(password)){
            session.setAttribute("session_account",account);
            session.setAttribute("session_password",password);

            req.getRequestDispatcher("/success").forward(req,resp);

            session.setMaxInactiveInterval(60);
            //登录成功转发index.jsp
            //resp.sendRedirect(req.getContextPath()+"index.jsp");

            System.out.println("登录成功");
        }else {
            System.out.println("账号/密码错误");
            resp.sendRedirect("/index.jsp");
        }
    }

}
