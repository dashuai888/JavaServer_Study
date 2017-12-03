package main.com.dashuai.weibo.common.utils;

import main.com.dashuai.weibo.common.constants.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyishuai on 2017/12/3
 */
public class RegUtils {
    public static boolean isInvalidEmail(String email) {
        Pattern pattern = Pattern.compile(Constants.EMAIL_REG.getVal());
        Matcher matcher = pattern.matcher(email);

        return !matcher.matches();
    }

    /**
     * name 由字母、数字、下划线组成，且开头必须是字母，长度不能超过16位；
     */
    public static boolean isInvalidName(String name) {
        Pattern pattern = Pattern.compile(Constants.NAME_REG.getVal());
        Matcher matcher = pattern.matcher(name);

        return !matcher.matches();
    }

    /**
     * password 字母和数字构成，不能超过16位
     */
    public static boolean isInvalidPassword(String password) {
        Pattern pattern = Pattern.compile(Constants.PASSWORD_REG.getVal());
        Matcher matcher = pattern.matcher(password);

        return !matcher.matches();
    }
}
