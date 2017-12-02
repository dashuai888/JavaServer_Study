package main.com.dashuai.chapter01;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wangyishuai on 2017/11/29
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
            IntrospectionException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Demo1 demo1 = new Demo1();
        demo1.test1();

        Demo2 demo2 = new Demo2();
        demo2.test("main.com.dashuai.chapter01.Person");

        Demo3 demo3 = new Demo3();
        demo3.test();
    }
}
