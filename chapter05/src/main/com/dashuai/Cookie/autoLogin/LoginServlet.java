package main.com.dashuai.Cookie.autoLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyishuai on 2017/12/5
 * <p>
 * cookie 实现
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("dashuai".equals(username) && "123456".equals(password)) {
            if ("yes".equals(req.getParameter("autoLogin"))) {
                Cookie cookie = new Cookie("user", username);
                cookie.setMaxAge(7 * 24 * 60 * 60);
                cookie.setHttpOnly(true);
                resp.addCookie(cookie);
            }

            req.setAttribute("user", username);
            req.getRequestDispatcher("user.view").forward(req, resp);
        } else {
            resp.sendRedirect("login.html");
        }
    }
}
