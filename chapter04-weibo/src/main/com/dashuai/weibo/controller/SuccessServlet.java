package main.com.dashuai.weibo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/3.
 * <p>
 * 这个Servlet 主要负责成功信息输出，原本应用 JSP 来实现
 */
@WebServlet("/success.view")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><title>注册成功</title>");
        out.println("<body>");
        out.println("<h2>会员：" + req.getParameter("username") + " 注册 dashuaiWeiChart 成功!</h2>");
        out.println("<a href='login.html'>点我，返回 dashuaiWeiChart 首页登录</a>");
        out.println("</body></html>");
        out.close();
    }
}
