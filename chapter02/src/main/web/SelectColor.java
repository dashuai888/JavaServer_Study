package main.web;

import main.model.BeerExport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangyishuai on 2017/11/26
 */
public class SelectColor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        req.setCharacterEncoding("UTF-8");

        // 获取请求的参数，参数名和from表单中的name属性一致
        // <select name="city" size="1">
        String s = req.getParameter("color");
        BeerExport beerExport = new BeerExport();
        List<String> ret = beerExport.getInfo(s);
        req.setAttribute("styles", ret);

        // 为jsp页面实例化一个请求分派器
        RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
        dispatcher.forward(req, resp);
    }
}
