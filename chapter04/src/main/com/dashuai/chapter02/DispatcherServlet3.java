package main.com.dashuai.chapter02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangyishuai on 2017/12/1
 * <p>
 * DispatcherServlet3 就是控制器，MVC中的Controller层，HelloModel是Model层，DispatcherServlet4 是视图层
 * <p>
 * DispatcherServlet3 会收集请求参数，DispatcherServlet3 中不会有任何前端输出或者后端存储.
 * 控制层仅仅是委托一个 HelloModel 对象处理业务逻辑，HelloModel 对象处理的结果，会设置为请求对象中的属性
 * 接着控制层将请求的响应工作转发给hello.view 来负责.之后负责展示处理结果的 Servlet 可以从请求对象中取得HelloModel对象属性.
 */
@WebServlet("/hello.do") // http://localhost:8080/hello.do?user=1
public class DispatcherServlet3 extends HttpServlet {
    /**
     * 开源框架里会使用反射进行对象的注入
     */
    private HelloModel model = new HelloModel();

    /*
    下面是不使用jsp的写法，比较麻烦，而且耦合性很大，视图层不应该出现java代码，应该只负责响应消息的展示
     */
//    @Override
    protected void doGet1(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("user");
        String msg = model.doHello(user);
        req.setAttribute("msg", msg); // 将 Model 层处理的结果，设置为请求对象中的属性，同时转发请求让视图层去响应请求
        // DispatcherServlet4 作为视图层
        req.getRequestDispatcher("hello.view").forward(req, resp);
    }

    /**
     * 使用jsp 的 el 表达式
     * <p>
     * 1.sendRedirect方式
     * sendRedirect("/a.jsp"); 可以将页面跳转到任何路径，不局限于web应用中，跳转的过程中url地址变化，无法使用request.setAttribute来传递请求范围内的属性。
     * <p>
     * 2.forward方式
     * request.getRequestDispatcher("/a.jsp").forward(request, response); url地址不变，只能跳转到本web应用中的页面上。
     * 可以用request.setAttribute方法
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("user");
        String msg = model.doHello(user);
        req.setAttribute("msg", msg); // 将 Model 层处理的结果，设置为请求对象中的属性，同时转发请求让视图层去响应请求
        req.getRequestDispatcher("/index2.jsp").forward(req, resp);
    }
}
