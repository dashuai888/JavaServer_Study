package main.com.dashuai.chapter02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyishuai on 2017/12/1
 */
@WebServlet("/hello.view")
public class DispatcherServlet4 extends HttpServlet {
    private static final StringBuffer HTML_TEMPLATE = new StringBuffer();

    static {
        HTML_TEMPLATE
                .append("<html>")
                .append("<head>")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>")
                .append("<title>%s</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>%s</h1>")
                .append("</body>")
                .append("</html>");
    }

    /*
    下面是不使用jsp的写法，比较麻烦，而且耦合性很大，视图层不应该出现java代码，应该只负责响应消息的展示
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("user");
        String msg = (String) req.getAttribute("msg");
        String html = String.format(HTML_TEMPLATE.toString(), user, msg);
        resp.getWriter().println(html);
    }
}
