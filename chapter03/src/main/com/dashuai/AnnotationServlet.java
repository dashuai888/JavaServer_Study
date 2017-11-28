package main.com.dashuai;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/11/26
 * 如果请求的URL 是 annotation.view，就会由 AnnotationServlet 来处理请求。
 * <p>
 * http://localhost:8080/annotation.view?name=%E5%A4%A7%E5%B8%85
 * （http://localhost:8080/annotation.view?name=大帅）
 */
//@WebServlet("/annotation.view") // 简单写法
@WebServlet(name = "annotation", urlPatterns = "/annotation.view", loadOnStartup = 1)
public class AnnotationServlet extends HttpServlet {
    /**
     * 当消求来到时，容器会调用 HttpServlet 的 service 方法.
     * 可以看到， Httpservlet 的  service 方法中定义的，基本上就是判断HTTP 请求的方式，
     * 所以若想针对GET、POST 等方法进行处理，只要继承HttpServlet 后，重新定义相对应的doGet() 、doPost() 方法即可
     * <p>
     * 这其实是使用了Template Method 设计模式。
     * <p>
     * 不建议也不应该在继承了 HttpServlet 后，重新定义 service 方法，这会覆盖 httpServlet 中定义的HTTP 预设处理流程
     */
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
