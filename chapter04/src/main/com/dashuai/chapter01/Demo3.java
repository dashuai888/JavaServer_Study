package main.com.dashuai.chapter01;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by wangyishuai on 2017/11/29
 * <p>
 * 使用 BeanUtils框架
 */
public class Demo3 {
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            InvocationTargetException, NoSuchMethodException {
        Class clazz = Class.forName("main.com.dashuai.chapter01.Person");
        Person person = (Person) clazz.newInstance();
        //调用写属性：
        BeanUtils.setProperty(person, "name", "啦啦啦");
        //调用读属性：
        String name = BeanUtils.getProperty(person, "name");
        System.out.println(name);
    }
}
