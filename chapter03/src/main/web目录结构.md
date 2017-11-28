# 一个Web 应用程序基本组成
- 静态资源
- Servlet
- JSP
- 自定义类
- 工具类
- 部署描述文件(web.xml 等)、设置信息(Annotation 等)

Web 应用程序目录结构必须符合规范。如果一个应用程序的环境路径
(Context path)是`/openhome`,则所有的资源项目必须以 `/openhome` 为根目录，依规定结构
摆放.

基本上根目录中的资源可以直接下载，例如`index.html` 位于`/openhome` 下，则可以直接以`/openhome/index.html` 来取得。

Web 应用程序存在一个特殊的`/WEB-INF` 目录，客户端(例如浏览器〉不可以直接请求此目录中存在的资源(无法直接在网址上指明访问/WEB-INF)，即使强行访问也是404。

- `/WEB-INF/web.xml` 是部署描述文件。
- `/WEB-INF/classes` 放置应用程序用到的自定义类(.class)，必须包括包(Package)结构.
- `/WEB-INF/lib` 放置应用程序用到的JAR 文件。

Web 应用程序用到的JAR 文件，其中可以放置Servlet、JSP、自定义类、工具类、部署描述文件等，应用程序的类载入器可以从JAR 中载入对应的资源.

可以在JAR 文件的  `/META-INF/resources` 目录中放置静态资源或JSP 等

如果要用到某个类，Web 应用程序会到 `/WEB-INF/classes` 中试着载入类，若无，再试着从`/WEB-INF/lib` 的JAR 文件中寻找类文件(若还没有找到，则会到容器实现本
身存放类或JAR 的目录中寻找，位置视实现厂商而有所不同，以Tomcat 而言，搜寻的路径是Tomcat 安装目录下的lib 目录).

客户端不可以直接请求`/WEB-INF` 中的资源，但可以通过程序的控制，让程序来取得`/WEB-INF` 中的资源，如使用`ServletContext` 的`getResource()` 与`getResourceAsStream()` ，或是
通过`RequestDispatcher` 请求调派。

如果Web 应用程序的URL 最后是以`/`结尾，而且确实存在该目录，则Web 容器必须传回该目录下的欢迎页面，可以在部署描述文件web.xml 中定义，指出可用的欢迎页面名称。
Web 容器会依序看看是否有对应的文件存在，如果有，则返回给客户端。
```xml
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>default.jsp</welcome-file>
</welcome-file-list>
```
如果找不到以上的文件,则会尝试至JAR 的`/META-INF/resources` 中寻找己放置的资源页面。如果URL 最后是以`/`结尾，但不存在该目录，则会使用预设Servlet(如
果有定义的话)。

整个Web 应用程序可以被封装为一个WAR 文件，以便部署至 Web 容器。