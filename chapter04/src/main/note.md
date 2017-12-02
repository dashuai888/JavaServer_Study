# 学习任何平台的程序编写，最忌流于API 的背诵与范例抄写
这样搞的后果就是：只知其一，不知其二。记住一句老话: "Web 容器是 Servlet、JSP 唯一认识的HTTP 服务器” 
 
所以，必须掌握在这种抽象层面下，Web 容器如何生成、管理请求/响应对象，为何发明他的人们会设计出这样的API 架构，

……

这样才不至于流于死背甚至写程序时仅会复制、粘贴的窘境。

# Web 容器做了什么
概括的说，Web 容器做的事情就是
> 创建Servlet 实例，并完成Servlet的注册及URL 的映射。请求来到，Web 容器会转发给正确的servlet 处理请求。

当浏览器请求HTTP 服务器时，是使用HTTP 来传送请求与相关信息(请求头、请求参数、Cookie 等). HTTP 是基于TCP/IP 之上的协议，然而Servlet 本质上是个Java 对象，
运行于Web 容器(一个Java 写的应用程序)中。有关HTTP请求的相关信息，是如何变成相对应的Java 对象的呢?

当请求来到HTTP 服务器，HTTP 服务器转发请求给容器时，容器会创建一个代表当次请求的HttpServletRequest 对象，并将请求相关信息设置给该对象。
同时，容器会创建一个HttpServletResponse 对象，作为稍后要对客户端进行响应的Java 对象。

接着，容器会根据 `@WebServlet` 或web.xml 的设置， 找出处理该请求的Servlet，然后调用它的service方法，将创建的HttpServletRequest 对象、HttpServletResponse
对象作为参数传入，service ()方法中会根据HTTP 请求的方式，调用对应的doXXX() 方法。

之后由servlet处理完业务逻辑后，容器转换响应信息为HTTP 响应对象，由HTTP服务器对浏览器进行响应.

最后容器将HttpServletRequest 对象、HttpServletResponse 对象销毁回收，本次请求-响应结束。

# HTTP 是基于请求/响应、无状态的协议
每一次的请求/响应后，服务端就不会记得任何客户端的信息了

容器每次请求都会创建新的请求-响应对象 ，处理完毕会销毁它们。下次请求的请求/响应对象就与上一次创建的请求/响应对象无关了，符合HTTP 基于请求/响应、无状态的模型
所以，对HttpServletRequest ，HttpServletResponse 的设置，是不可能延续至下一次请求的.

像这类请求/响应对象的创建与销毁，也就是有关请求/响应对象的生命周期管理，也是Web 容器提供的功能.事实上，不只请求/响应对象，Web 容嚣管理了多种对象的生命周期，
因此必须了解Web 容器管理对象生命周期的方式，否则就会引来不必要的错误.