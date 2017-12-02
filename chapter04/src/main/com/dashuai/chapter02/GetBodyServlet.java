package main.com.dashuai.chapter02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangyishuai on 2017/12/1.
 * <p>
 * HttpServletRequest 上定义有 getReader 方法，可以让你取得一个 BufferedReader 对象， 通过该对象，可以读取请求的Body 数据
 */
@WebServlet("/body.view")
public class GetBodyServlet extends HttpServlet {
    /**
     * 如果提交中文，如下显示原始编码：
     * <p>
     * user=%E7%8E%8B%E5%A4%A7%E5%B8%85&password=123456&login=post%E8%AF%B7%E6%B1%82
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String body = getBody(req);
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println(body);
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    private String getBody(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = request.getReader();
        String input = "";
        StringBuilder reqBody = new StringBuilder();
        while ((input = bufferedReader.readLine()) != null) {
            reqBody.append(input).append("<br>");
        }

        return reqBody.toString();
    }
}
