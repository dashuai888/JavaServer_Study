# HttpServletRequest：请求
作用：获取客户端带给服务器信息的

都是由容器创建

当HTTP 请求转发给Web 容器处理时， Web 容器会收集相关信息，并产生HttpServletRequest对象，可以使用这个对象取得HTTP 请求中的信息.可以在Servlet 中进行请求
的处理，或是将请求转发(或包含)另一个Servlet/JSP 进行处理.各个Servlet/JSP 在同一请求周期中可以共享该对象。

- getParameter(): 指定请求参数名称取得对应的值。getParameter ()返回的是String 对象，若传来的是像"123 "这样的字符串值，而需要的是基本数据类型，
则必须使用Integer.parseInt() 这类的方法将之转换为基本类型。若请求中没有所指定的请求参数名，则会返回null .

- getParameterValues(): 如果窗体上有可复选的组件，如复选框(Checkbox)、列表(List)等，则同一个请求参数名称会有多个值(是像param=1O&param=20&param=30）
可以用getParameterValues() 方法取得一个String 数组，数组元素代表所有被选取选项的值.

- getParameterNames()；如果想要知道请求中有多少请求参数，则可以使用 getParameterNames()方法，返回一个Enumeration 对象，其中包括所有的请求参数名称。

- getParameterMap (): 将请求参数以Map 对象返回， Map 中的键(Key)是请求参数名，值(Value)是请求参数值，以字符串数组类型String[] 返回(因考虑
  有同一请求参数有多个值的情况).

- getHeader () : 使用方式与getParameter ()类似，指定标头名称后可返回字符串值，代表浏览器所送出的标头信息.

- getHeaders(): 使用方式与getParameterValues() 类似，指定标头名称后可返回Enumeration ，元素为字符串.

- getHeaderNames(): 使用方式与getParameterNames() 樊似，取得所有标头名称，以Enumeration 返回，内含所有标头字符串名称。

## 使用 RequestDispatcher 调派请求
在Web 程序中，经常需要多个Servlet 来完成请求。例如，将另一个Servlet的请求处理流程包含(Include)进来，或将请求转发(Forward)给别的Servlet 处理。

如果有这类需求，可以使用HttpServletRequest 的getRequestDispatcher方法取得RequestDispatcher接口的实现类的对象，调用时指定转发或包含的相对URL（或者URL+请求参数）

取得 RequestDispatcher 还有两个方式，通过ServletContext 的 getRequestDispatcher ()或getNamedDispatcher() 

## include ()或forward()
在include ()或forward() 时包括请求参数的做法，仅适用于传递字符串值给另一个Servlet，在调派请求的过程中，如果有必须共享的"对象"，可以设置给请求对象成为
属性，称为请求范围属性
- setAttribute(): 指定名称与对象设置属性.
- getAttribute(): 指定名称取得属性。
- getAttributeNames(): 取得所有属性名称。
- removeAttribute () :指定名称移除属性.

由于请求对象仅在此次请求周期内有效，在请求/响应之后，请求对象会被销毁，设置在请求对象中的属性自然也就消失了，所以通过setAttribute ()设置的属性才
称为请求范围属性。

使用include ()时，被包含的Servlet 中任何对请求头的设置都会被忽略，被包含的Servlet 中可以使用getSession ()方法取得HttpSession对象，这是唯一的例外，
因为HttpSession 底层默认使用Cookie. 所以响应中加一个Cookie 请求头。

RequestDispatcher 的 forward() 方法，调用时同样传入请求与响应对象，这表示你要将请求处理转发给别的Servlet. "对客户端的响应同时也转发给另一个Servlet"

若要调用forward() 方法，目前的Servlet 不能有任何响应确认(Commit). 如果在目前的Servlet 中通过响应对象设置了一些响应但未确认(响应缰冲区未满或未调用任何消除方法).
则所有响应设置会被忽略，如果已经有响应确认且调用了forward()方法，则会抛出IllegalStateException.
  

