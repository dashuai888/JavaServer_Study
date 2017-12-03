package main.com.dashuai.weibo.controller;

import main.com.dashuai.weibo.common.constants.Constants;
import main.com.dashuai.weibo.common.utils.RegUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyishuai on 2017/12/3
 */
@WebServlet("/register.do")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");

        List<String> errorsList = new ArrayList<>();
        if (RegUtils.isInvalidEmail(email)) {
            errorsList.add("邮箱地址不正确！");
        }

        if (RegUtils.isInvalidName(username)) {
            errorsList.add("用户名格式不正确！");
        }

        if (canFindUserByName(username)) {
            errorsList.add("该用户已经存在！");
        }

        if (RegUtils.isInvalidPassword(password)) {
            errorsList.add("密码格式不正确！");
        }

        if (!StringUtils.equals(password, confirmedPassword)) {
            errorsList.add("两次密码输入不一致！");
        }

        String retPage = Constants.ERROR_VIEW.getVal();
        if (!errorsList.isEmpty()) {
            req.setAttribute("errors", errorsList);
        } else {
            retPage = Constants.SUCCESS_VIEW.getVal();
            createUser(email, username, password);
        }

        req.getRequestDispatcher(retPage).forward(req, resp);
    }

    private void createUser(String email, String username, String password) throws IOException {
        File userDir = new File(Constants.DATABASE_URL.getVal() + "/" + username);
        userDir.mkdir();
        FileWriter fileWriter = new FileWriter(userDir + "/profile.md");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(email + "\t" + password);
        bufferedWriter.flush();
    }

    private boolean canFindUserByName(String name) throws IOException {
        for (String fileName : new File(Constants.DATABASE_URL.getVal()).list()) {
            if (name.equals(fileName)) {
                return true;
            }
        }

        return false;
    }
}

