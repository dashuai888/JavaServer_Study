package main.com.dashuai;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/11/26
 * 如果请求的URL 是 annotation.view，就会由He ll oServlet 来处理请求。关于
 Servlet 的设置，还有更多的细节。事实上，由于到目前为止，借助了IDE 的辅助，有
 许多细节都被省略了，所以接下来得先讨论这些细节
 */
@WebServlet("/annotation.view")
public class AnnotationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>注解的servlet</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>hello " + name + " !</h1>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
