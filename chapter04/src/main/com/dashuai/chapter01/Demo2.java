package main.com.dashuai.chapter01;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by wangyishuai on 2017/11/29
 * <p>
 * 反射，也是框架的基础
 */
public class Demo2 {
    public void test(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            IntrospectionException, InvocationTargetException {
        Class clazz = Class.forName(className);
        Person person = (Person) clazz.newInstance();
        person.setAge(18);
        System.out.println(person.getAge());

        // 或者使用内省的方式
        // 获得clazzd对象的name属性的描述器
        PropertyDescriptor descriptor = new PropertyDescriptor("name", clazz);
        Method writeMethod = descriptor.getWriteMethod();// 获取name的描述器的写属性
        writeMethod.invoke(person, "哈哈");

        Method readMethod = descriptor.getReadMethod(); // 获取name的描述器的读属性
        String name = (String) readMethod.invoke(person, null);
        System.out.println(name);

        // 获取所有属性的描述器
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] descriptor1 = beanInfo.getPropertyDescriptors();

        // 遍历所有属性名
        Arrays.stream(descriptor1).forEach(desc -> System.out.println(desc.getName()));
    }
}
