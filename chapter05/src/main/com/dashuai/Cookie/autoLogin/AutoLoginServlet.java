package main.com.dashuai.Cookie.autoLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyishuai on 2017/12/3.
 * <p>
 * Cookie 一个常见的应用，就是实现用户自动登录(Login)功能.
 */
@WebServlet("/index.do")
public class AutoLoginServlet extends HttpServlet {

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
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String val = cookie.getValue();

                if ("user".equals(name) && "dashuai".equals(val)) {
                    req.setAttribute(name, val);
                    req.getRequestDispatcher("/user.view").forward(req, resp);

                    return; // 别忘了结束程序
                }
            }
        }

        resp.sendRedirect("login.html");
    }
}
