package main.com.dashuai.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyishuai on 2017/12/5
 * <p>
 * session 实现
 */
@WebServlet("/loginSession.do")
public class LoginSessionServlet extends HttpServlet {

    /*
    其他的servlet / jsp， 如果可以从 HttpSession 取得 login 属性，基本上就可以确定是个己登录的用户，
    这类用来识别用户是否登录的属性，通常称之为登录令牌牌(Login Token)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("dashuai".equals(username) && "123456".equals(password)) {
            req.getSession().setAttribute("login", username);
            req.getRequestDispatcher("/userSession.view").forward(req, resp);
        } else {
            resp.sendRedirect("login.html");
        }
    }
}
