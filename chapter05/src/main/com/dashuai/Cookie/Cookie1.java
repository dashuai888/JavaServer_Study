package main.com.dashuai.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyishuai on 2017/12/3.
 * <p>
 * HTTP 中 Cookie 的设定是通过 set-cookie 标头，所以必须在实际响应浏览器之前使用 addCookie()来新增 Cookie 实例
 * 在浏览器输出HTML 响应之后再运行 addCookie s是没有作用的.
 */
public class Cookie1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cookie cookie = new Cookie("user", "value");
        cookie.setMaxAge(7 * 24 * 60 * 60); // 单位 s,默认关闭浏览器之后Cookie 就失效.
        resp.addCookie(cookie);
        cookie.setMaxAge(0); // 删除 cookie

        /*
        如果要取得浏览器上存储的Cookie，则可以从HttpServletRequest 的getCookies ()
        来取得，这可取得属于该网页所属域(Domain)的所有 Cookie ，所以返回值是Cookie []

        取得Cookie 对象后，可以使用Cookie 的，getName() 与getValue ()方法，分别取得 Cookie 的名称与数值
         */
    }
}
