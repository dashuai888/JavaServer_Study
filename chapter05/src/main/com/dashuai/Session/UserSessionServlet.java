package main.com.dashuai.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/5
 */
@WebServlet("/userSession.view")
public class UserSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processReq(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processReq(req, resp);
    }

    private void processReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("login") == null) {
            resp.sendRedirect("login.html");
        } else {
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("user 页面<br>");
            writer.println("user = " + session.getAttribute("login") + " 已登录！");
            writer.println("user = " + session.getAttribute("login") + " <a href='logout.view'>注销</a>");
            writer.close();
        }
    }
}
