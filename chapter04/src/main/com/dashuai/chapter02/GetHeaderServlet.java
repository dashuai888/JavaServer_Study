package main.com.dashuai.chapter02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by wangyishuai on 2017/11/30.
 * <p>
 * 取得并显示浏览器送出的标头信息
 */
@WebServlet("/header.view")
public class GetHeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>HeaderServlet</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("获取程序的环境路径：" + req.getContextPath() + "<br>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            writer.println("浏览器请求头的名字 = " + name + " ，对应的值 = " + req.getHeader(name) + "<br>");
        }
        writer.println("</body>");
        writer.println("</html>");
        writer.close();

        /*
        如果标头值本身是个整数或日期的字符串，则可以使用getIntHeader() 或 getDateHeader() 方法分别取得转换为int 或 date 的值.
         */
    }
}
