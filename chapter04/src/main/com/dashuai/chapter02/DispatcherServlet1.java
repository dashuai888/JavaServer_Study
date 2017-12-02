package main.com.dashuai.chapter02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/1.
 */
@WebServlet("/some.view")
public class DispatcherServlet1 extends HttpServlet {
    /*
    浏览器输出：
    some view do
    other.view doing
    other view done
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("some view do");
        // 取得RequestDispatcher接口的实现类的对象，调用时指定转发或包含的相对URL，通过 other.view 取得对应的 Servlet .
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("other.view");
        // 调用include () 时，必须分别传入实现 ServletRequest、ServletResponse 接口的对象
        // 可以是service ()方法传入的对象，或者是自定义的对象或封装器
        requestDispatcher.include(req, resp);
        writer.println("other view done");
        writer.close();
    }
}
