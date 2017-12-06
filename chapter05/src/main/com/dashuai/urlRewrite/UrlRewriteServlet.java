package main.com.dashuai.urlRewrite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/6
 * <p>
 * 简单分页
 */
@WebServlet("/search.view")
public class UrlRewriteServlet extends HttpServlet {

    /**
     * 因为URL 重写是在URL之后附加参数并用超链接发送的方式，所以必须以 GET 方式发送请求，再加上 GET 本身可以携带的请求参数长度有限，
     * 因此大量的客户端信息，并不适合使用 URL 重写.
     * <p>
     * 通常 URL 重写是用在一些简单的客户端信息保留，或者是辅助会话管理——HttpSession 会话管理机制的原理之一，就与 URL 重写有关
     * <p> http://localhost:8080/search.view 执行
     * http://localhost:8080/search.view?start=9
     * 第 81 到 90 条内容。
     * 搜索的结果： 0
     * 搜索的结果： 1
     * 搜索的结果： 2
     * 搜索的结果： 3
     * 搜索的结果： 4
     * 搜索的结果： 5
     * 搜索的结果： 6
     * 搜索的结果： 7
     * 搜索的结果： 8
     * 搜索的结果： 9
     * 1 2 3 4 5 6 7 8 9
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>搜索结果</title></head>");
        writer.println("<body>");

        String start = req.getParameter("start");
        if (start == null) {
            start = "1";
        }
        int count = Integer.parseInt(start);
        int begin = 10 * count - 9; // 每页显示10个记录
        int end = 10 * count;

        writer.println("第 " + begin + " 到 " + end + " 条内容。<br>");
        writer.println("<ul>");

        for (int i = 0; i < 10; i++) {
            writer.println("<li> 搜索的结果： " + i + "</li>");
        }

        writer.println("</ul>");

        // 分页
        for (int i = 1; i < 10; i++) {
            if (i == count) {
                writer.println(i); // 当前显示的页数 i
                continue;
            }

            writer.println("<a href='search.view?start=" + i + "'>" + i + "</a>");
        }

        writer.println("</body></html>");
        writer.close();
    }
}
