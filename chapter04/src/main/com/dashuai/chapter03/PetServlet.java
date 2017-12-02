package main.com.dashuai.chapter03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by wangyishuai on 2017/12/2
 * <p>
 * 对应 index3.jsp
 */
@WebServlet("/pet.view")
public class PetServlet extends HttpServlet {
    /**
     * 要注意的是，在没有设置任何内容类型或编码之前. HttpServletResponse 使用的字
     * 符编码默认是ISO-8859-1. 也就是说，如果直接输出中文，在浏览器上就会看到乱码.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 这个动作必须在取得任何请求参数之前进行
        req.setCharacterEncoding("UTF-8"); // 为接受中文请求参数，使用了 setCharacterEncoding() 方法来指定请求对象，处理字符串编码
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter(); // 有时需要直接对浏览器进行字节输出，这时可以使用 HttpServletResponse 的 getOutputStream();
        writer.println("联系人姓名：user = " + req.getParameter("user"));
        writer.println("联系人邮箱：email = " + req.getParameter("email"));
//        writer.println("喜欢的宠物：" + req.getParameterValues("type")); // [Ljava.lang.String;@41b8cb91
        writer.println("喜欢的宠物：" + Arrays.toString(req.getParameterValues("type"))); // 联系人姓名：user = dashuai 联系人邮箱：email = yishuaiyanfu@163.com 喜欢的宠物：[猫]
    }

}
