<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <%--使用 jsp 的 el 表达式获取请求参数--%>
    <title>${param.user}</title>
</head>
<body>
<%--使用 jsp 的 el 表达式获取请求范围中的属性--%>
<h1>${msg}</h1>
</body>
</html>
