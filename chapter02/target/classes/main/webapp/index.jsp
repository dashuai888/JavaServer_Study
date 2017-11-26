<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>dashuai BBS</title>
<body>
<h2 align="center">dashuai BBS</h2>
<%--
SelectColor.do是servlet的逻辑名，HTML会将其当做要处理请求的servlet，SelectColor.do不是一个实际的文件名。这只是我们希望客户端使用的名字!
实际上，客户端根本不能直接访问servlet类.所以不能直接使用servlet文件的路径。
所以，才会使用XML部署描述文件(web.xml) 把客户端请求的资源(SelectColor.do) 映射到一个实际的 servlet 类，当指向 SelectColor.do 的请求到达时，
容器会找到并使用这个类。
--%>
<form method="post" action="SelectColor.do">
    <p>选择啤酒的颜色</p>
    颜色:
    <select name="color" size="1" title="选择颜色">
        <option>红色</option>
        <option>青色</option>
        <option>蓝色</option>
        <option>黑色</option>
    </select>

    <br>

    <div style="text-align: center;">
        <input type="submit">
    </div>
</form>
</body>
</html>