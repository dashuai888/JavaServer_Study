package main.com.dashuai.weibo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wangyishuai on 2017/12/3.
 * <p>
 * 这个Servlet 主要负责错误信息输出，原本应用 JSP 来实现
 */
@WebServlet("/error.view")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
        out.println("<title>新精会员失败</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>新增会员失败</h1>");

        List<String> errorList = (List<String>) req.getAttribute("errors");
        for (String error : errorList) {
            out.println("<li>" + error + "</li>");
        }

        out.println("<a href='register.html'>返回 dashuaiWeiChart 注册页面</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
