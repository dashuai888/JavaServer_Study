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
 * Created by wangyishuai on 2017/12/6
 */
@WebServlet("/logout.view")
public class LogoutServlet extends HttpServlet {

    /*
    执行HttpSession 的invalidate 之后，容器就会回收 HttpSession 对象，
    之后，再次通过 HttpServletRequest 的 getSession 取得HttpSession 就是另一个新对象了，
    这个新对象当然不会有先前的 login 属性，所以再直接请求用户页面，就会因找不到login属性，而重定向至登录窗体.

    HttpSession 并非线程安全，所以必须注意属性设定时共享存取的问题！
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("login");
        session.invalidate();

        PrintWriter writer = resp.getWriter();
        writer.println("用户 = " + username + "已经注销！");
        writer.close();
    }
}
