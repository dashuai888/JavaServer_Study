package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyishuai on 2017/11/26
 */
public class BeerExport {
    private static final String RED = "红色";

    public List<String> getInfo(String color) {
        List<String> infos = new ArrayList<>();
        if (RED.equals(color)) {
            infos.add("red 1");
            infos.add("red 2");
        } else {
            infos.add("other 1");
            infos.add("other 2");
        }

        return infos;
    }
}
