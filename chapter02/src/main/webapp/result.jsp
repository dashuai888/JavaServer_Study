<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>详细信息展示</title>
</head>
<body>
<h2 align="center">啤酒的详细信息</h2>

<p>
        <%
    List<String> list = (List<String>) request.getAttribute("styles");
    for (String s : list) {
        out.print("<br>" + s);
    }
%>
</body>
</html>
