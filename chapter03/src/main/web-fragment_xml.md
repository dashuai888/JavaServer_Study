# 在Servlet 3.0 中， JAR 文件也可用来作为Web 应用程序的部分模块
事实上，Servlet，监听器、过滤器等也可以在编写、定义注解完毕后，封装在JAR 文件中。

一个JAR 文件中，除了可使用注解定义的Servlet、监昕器、过滤器外，也可以拥有自己的部署描述文件。

这个文件的名称是web-fragment.xml，必须放置在JAR 文件的 `/META-INF` 目录中。

基本上. web.xml 中可定义的元素，在web-fragment.xml 中也可以定义。

举个例子来说，可以在web-fragment.xml 中定义如下内容:
```xml
<?xml version="1.O" encoding="UTF-8"?>
<web-fragment>
<name>WebFragment</name>
    <servlet>
        <servlet-name>hi</servlet-name>
        <servlet-class>cc.openhome.HiServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-nane>hi</servlet-name>
        <url-pattern>/hi.view</url-pattern>
    </servlet-mapping>
</web-fragment>
```
web-fragment.xml 的根标签是<web-fragment> 而不是<web-app> .实际上，
web-fragment.xml 中所指定的类，不一定要在JAR 文件中，也可以是在web
应用程序的`/WEB-INF/classes` 中。

如果将 `web.xml` 中 `<web-app>` 的`metadata-complete` 属性设置为true(默认是false). 则表示`web.xml` 中己完成Web 应用程序的相关定义，
部署时将不会扫描注解与`web-fragment.xml` 中的定义。