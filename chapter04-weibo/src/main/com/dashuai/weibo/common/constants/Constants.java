package main.com.dashuai.weibo.common.constants;

/**
 * Created by wangyishuai on 2017/12/3
 */
public enum Constants {
    // 正则校验
    EMAIL_REG("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+"),
    NAME_REG("[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}"),
    PASSWORD_REG("[a-zA-Z0-9]{1,16}"),

    // 存储信息
    DATABASE_URL("/Users/wangyishuai/idea/JavaWEB/chapter04-weibo/src/main/resources/database"),

    // 页面信息
    ERROR_VIEW("error.view"), SUCCESS_VIEW("success.view"), HOME_VIEW("index.html"), USER_VIEW("user.view"),;

    private String val;

    Constants(String s) {
        this.val = s;
    }

    public String getVal() {
        return val;
    }
}
