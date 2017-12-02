# 一、Servlet是什么？
运行在服务器端的一种动态资源

# 二、Servlet的开发步骤
1. 编写一个类直接或间接实现javax.servlet.Servlet接口，一般选择继承javax.servlet.GenericServlet，如果编写的是与HTTP协议有关的动态程序，
继承javax.servlet.http.HttpServlet，如果继承javax.servlet.http.HttpServlet，不要覆盖service方法，而应覆盖doXXX方法

2. 配置映射：web.xml
```xml
<servlet>
    <servlet-name>XXX</servlet-name>
    <servlet-class>Servlet类的全名</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>XXX</servlet-name>
    <url-pattern>/Demo1</url-pattern>
</servlet-mapping>
```

或者直接使用servlet3.0才有的注解。

3. 编译后部署到Tomcat中，访问地址http://localhost:8080/你的应用/Demo1

# 三、Servlet的运行过程和原理：
1. 用户第一次访问Servlet时，才会完成实例化和初始化，并驻留内存

2. 针对用户的每次请求，都会执行service方法为之服务

3. 当应用被关闭或者服务器被关闭，才会执行destory方法

# 四、Servlet的一些细节
1. 通配符映射：  `*.do`    `/action/*`

2. 可以通过<load-on-startup>自然数（代表启动顺序）</load-on-startup>让应用在启动时就完成Servlet的实例化和初始化

# 五、获取针对Servlet的一些配置参数
ServletConfig

# 六、Servlet的线程安全问题：尽量在Servlet中使用局部变量
与Servlet是单例有关，实例变量会被多个线程所共享，会出现线程安全问题

# 七、Servlet规范中的核心接口和类图

# 八、ServletContext
1. 特点：应用一启动就创建，只要应用存在，它就存在。每一个应用都有自己的唯一的ServletContext对象。

2. 域（范围--应用范围）对象：内部有一个Map<String, Object>

```java
private Map<String,Object> map = new HashMap<String,Object>();

public void setAttribute(String key, Object value){
    map.put(key,value);
}

public void removeAttribute(String key){
    map.remove(key);
}

public Object getAttribute(String key){
    return map.get(key);
}
```

# 九、ServletContext一些应用
1. 实现Servlet间数据的共享

2. 实现请求的转发

3. 实现文件的下载：获取资源文件的真实路径

4. 读取资源文件的三种方式

ServletContext  getRealpath

ResourceBundle  只能读取类路径中的 `*.properties` 文件

类加载器
