# HttpServletResponse：响应
可以使用HttpServletResponse 对浏览器进行响应.

作用：给客户端发出信息用的。能发出响应码；响应消息头；响应正文。都是由容器创建

大部分的情况下：
- 使用 setContentType() 设置响应类型
- 使用 getWriter() 取得 PrintWriter 对象，而后使用 PrintWriter 的 print1n() 等方法输出 HTML 内容.
- 还可以使用 setHeader()、addHeader() 等方法进行响应头的设置
- 或者是使用 sendRedirect()、sendError()方法，对客户端要求重定向网页，或是传送错误状态信息。
- 若必要，也可以使用 getOutputStream() 取得 ServletOutputStream，直接使用流对象对浏览器进行字节数据的响应。

## 设置晌应头、缓冲区
可以使用 HttpServletResponse 对象上的 settHeader() 、addHeader() 来设置响应头
- setHeader() 设置头名称与值
- addHeader() 则可以在同一个头名称上附加值.

如果标头的值是整数，则可以使用 setIntHeader() 、addIntHeader() 方法

如果标头的值是个日期，则可以使用setDateHeader()、addDateHeader() 方法

所有的标头设置，必须在响应确认之前(Commit)，在响应确认之后设置的标头,会被容器忽略

容器可以(但非必要)对响应进行缓冲，通常容器默认都会对响应进行缓冲.可以操作 HttpServletResponse 以下几个方法:
- getBufferSize()
- setBufferSize()
- isCommitted()
- reset()
- resetBuffer()
- flushBuffer()

setBufferSize() 必须在调用 HttpServletResponse 的 getWriter() 或 getOutputStream() 方法之前调用，所取得的 Writer 或 ServletOutputStream 才会套用这个设置.
在调用 HttpServletResponse 的 getWriter() 或 getOutputStream() 方法之后调用 setBufferSize() ，会抛出 IllegalStateException.

在缓冲区未满之前，设置的响应相关内容都不会真正传至客户端，可以使用 isCommitted() 看看是否响应己确认.

如果想要重置所有响应信息，可以调用 reset 方法，这会连同己设置的标头一井清除，调用 resetBuffer() 会重置响应内容，但不会清除己设置的标头内容.

flushBuffer() 会清除(flush)所有缓冲区中己设置的响应信息至客户端

reset、resetBuffer 必须在响应未确认前调用.

## 清理响应
HttpServletResponse 对象若被容器关闭，则必须清除所有的响应内容，响应对象被关闭的时机点有以下几种：

- Servlet 的 service() 方法己结束，响应的内容长度超过 HttpServletResponse 的 setContentLength() 所设置的长度。
- 调用了 sendRedirect() 方法.
- 调用了sendError() 方法.
- 调用了 AsyncContext 的Complete() 方法

## 设置Locale
浏览器如果有发送 Accept-Language 标头，则可以使用 Http5ervletRequest 的getLocal() 来取得一个Locale 对象，代表客户端可接受的语系.

可以使用 Http5ervletResponse 的 setLocal() 来设置地区(Locale)信息，地区倩息就包括了语系与编码信息.语系信息通常通过响应标头Content-Language 来设置，
而 setLocale() 也会设置响应的Content-Language 标头。

可以在web.xml 中设置默认的区域与编码.

## setCharacterEncoding 或 setContentType
使用HttpServletResponse 的 setContentType 时，指定 charset. charset 的值会自动调用 setCharacterEncoding().

如果使用了setCharacterEncoding() 或 setContentType() 时指定了charset. 则 setLocale() 就会被忽略。

因为浏览器需要知道如何处理响应，所以必须告知内容类型. setContentType() 方法在响应中设置 ContentType 响应标头，只要指定 MIME(Multipurpose Internet
Mall Extensions)类型就可以了。由于编码设置与内容类型通常都要设置，所以调用 setContentType () 设置内容类型时，同时指定 charset 属性是个方便且常见的做法.

常见的设置有 
- text/html
- application/pdf
- application/jar
- applicationl/x-zip
- image/jpeg 等

不用强记 MIME 形式，新的 MIME 形式也不断地在增加，必要时再使用搜索了解一下即可.对于应用程序中使用到的 MIME 类型，可以在 web.xml 中设置后缀与 MIME 类型对应.

## sendRedirect( )
过RequestDispatcher 的 forward() 方法. 会将请求转发至指定的URL. 这个动作是在Web 容器中进行的，浏览器并不会知道请求被转发，地址栏也不会有所变化

在转发过程中，都还是在同一个请求周期，这也是为什么 RequestDispatcher 是由调用 HttpServletRequest 的 getRequestDispatcher() 方法取得，所以在HttpServletRequest 中使
用 setAttribute() 设置的属性对象，都可以在转发过程中共享

可以使用 HttpServletResponse 的 sendRedirect 要求浏览器重新请求另一个URL，又称为重定向(Redirect) ，使用时可指定绝对URL 或相对URL.

```
response.sendRedirect("http://xxxxxx");
```
这个方法会在响应中设置 HTTP 状态码为 301 以及 Location 标头，浏览器接收到这个标头，会重新使用 GET 方法请求指定的 URL，因此地址栏上会发现 URL 的变更.

由于是利用HTTP 状态码与标头信息，要求浏览器重定向网页，因此这个方法必须在响应未确认输出前执行，否则会抛出口 IllegalStateException.

## sendError( )
如果在处理请求的过程中发现一些错误，而你想要传送服务器默认的状态与错误信息，可以使用 sendError 方法.

例如，如果根据请求参数必须返回的资源根本不存在，则可以送出错误信息:
```
response.sendError(HttpServletResponse.SC_NOT_FOUND);

```
SC_NOT_FOUND 会令服务器响应 404 状态码，这类常数定义在 HttpServletResponse 接口上.如果想使用自定义的信息来取代默认的信息文字，则可以使用:
```
response.sendError(HttpServletResponse.SC_NOT_FOUND，"MSG") ;
```

由于利用到 HTTP 状态码，要求浏览器重定向网页，因此sendError ()方法同样必须在响应未确认输出前执行，否则会抛出 IllegalStateException.