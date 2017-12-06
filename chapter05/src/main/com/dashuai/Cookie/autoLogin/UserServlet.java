package main.com.dashuai.Cookie.autoLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/5
 */
@WebServlet("/user.view")
public class UserServlet extends HttpServlet {
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

    /**
     * 当用户访问首页时，会先取得所有的 Cookie 。然后一个一个检查是否有 Cookie : 存储名称user 而值为dashuai 的.
     * <p>
     * 如果有，则表示先前用户登录时，曾经选取 自动登录 选项，此时，直接转发至用户网页.
     * <p>
     * 如果没有对应的Cookie. 则表示用户是初访，或者先前没有选取"自动登录"选项，此时重定向到登录
     */
    private void processReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        if (req.getAttribute("user") == null) {
            resp.sendRedirect("login.html");
        }

        PrintWriter writer = resp.getWriter();
        writer.println("user 页面");
        writer.println("user = " + req.getAttribute("user") + "已登录！");
        writer.close();
    }
}
