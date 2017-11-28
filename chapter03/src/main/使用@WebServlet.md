# 代替部署描述文件(Deployment Descriptor. DD 文件)
使用注解来定义Servlet 是Java EE 6 中Servlet 3.0 之后才有的功能，在先前的版本中，必须在Web 应用程序的WEB-INF 目录中，建立一个web.xml 文件
定义Servlet相关信息。在Servlet 3.0 中，也可以使用web.xml 文件来定义Servlet.

使用web.xml 定义比较麻烦，不过web.xml 中的设置会覆盖Servlet 中的注解，可以使用注解来作默认值，而web.xml 作日后更改设置值之用

# 使用注解 @WebServlet("URL地址")
编写好Servlet 之后，接下来要告诉Web 容器有关于这个Servlet 的一些信息. 在Servlet 3.0 中，可以使用注解，来告知容器哪些Servlet 会提供服务以及额外
信息.

例如在 AnnotationServlet.java 中：
```
@WebServlet("/annotation.view")
```
只要在Servlet 上设置@WebServlet注解，web容器就会自动读取当中的信息.上面的@WebServlet 告诉web容器，如果请求的URL 是 annotation.view，
则由 AnnotationServlet 的实例提供服务. 可以使用@WebServlet(")提供更多信息.
```
@WebServlet(name = "annotation", urlPatterns = "/annotation.view", loadOnStartup = 1)
```
上面的 @WebServlet 告知容器， AnnotationServlet 这个Servlet 的名称是 annotation.这是由name属性指定的，
而如果客户端请求的URL 是/annotation.view，则由具 annotation 名称的Servlet 来处理，这是由urlPatterns 属性来指定的。

在Java EE 相关应用程序中使用注解时，可以记得的是，没有设置的属性通常会有默认值。例如，若没有设置@WebServlet 的name
属性，默认值会是Servlet 的类完整名称。

当应用程序启动后，事实上并没有创建所有的Servlet 实例.容器会在首次请求需要某个Servlet 服务时，才将对应的Servlet 类实例化、进行初始化操作，然后再处理
请求。

这意味着第一次请求该Servlet 的客户端，必须等待Servlet 类实例化、初始化完毕，才真正得到请求的处理。

如果希望应用程序启动时，就先将Servlet 类载入、实例化并做好初始化动作，则可以使用 loadOnStartup 设置。设置大于0 的值(默认值为 -1)，表示启动应用程序后就要初始化Servlet(而不是实例化几个Servlet). 
数字代表了Servlet 的初始顺序。

容器必须保证有较小数字的Servlet 先初始化，在使用注解的情况下，如果有多个Servlet 在设置loadOnStartup 时使用了相同的数字，
则容器实现厂商可以自行决定要如何载入哪个Servlet。