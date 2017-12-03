package main.com.dashuai.weibo.controller;

import main.com.dashuai.weibo.common.constants.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by wangyishuai on 2017/12/3
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkLogin(username, password)) {
            req.getRequestDispatcher(Constants.USER_VIEW.getVal()).forward(req, resp);
        } else {
            resp.sendRedirect(Constants.HOME_VIEW.getVal());
        }
    }

    private boolean checkLogin(String username, String password) throws IOException {
        if (username == null || password == null) {
            return false;
        }

        for (String fileName : new File(Constants.DATABASE_URL.getVal()).list()) {
            if (username.equals(fileName)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader
                        (Constants.DATABASE_URL.getVal() + "/" + fileName + "/profile.md"));
                String strings = bufferedReader.readLine();
                System.out.println(strings);
                String passwd = strings.split("\t")[1];

                if (password.equals(passwd)) {
                    return true;
                }
            }
        }

        return false;
    }
}
