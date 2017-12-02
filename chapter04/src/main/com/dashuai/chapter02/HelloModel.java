package main.com.dashuai.chapter02;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyishuai on 2017/12/1.
 * <p>
 * 被DispatcherServlet3 使用
 * <p>
 * 利用一个HashMap. 针对不同的用户设置不同的信息
 * <p>
 * HelloMode1 对象处理完的结果返回给 控制器层. HelloModel 类中没有任何前端呈现或后端储存逻辑，Model层是纯粹的 Java 对象。
 */
public class HelloModel {
    private Map<String, String> map = new HashMap<>();

    public HelloModel() {
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
    }

    public String doHello(String user) {
        return map.get(user) + " : " + user;
    }
}
