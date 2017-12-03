package main.com.dashuai.weibo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/3
 */
@WebServlet("/user.view")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><title>注册成功</title>");
        out.println("<body>");
        out.println("<h2>会员：" + req.getParameter("username") + " 你好! 欢迎访问 dashuaiWeiChart </h2>");
        out.println("</body></html>");
        out.close();
    }
}
