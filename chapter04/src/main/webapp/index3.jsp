<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--网页编码为UTF-8--%>
<html>
<head>
    <title>宠物信息调查</title>
    <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
    <%--
    所有浏览器都支持 <meta> 标签。
    <meta> 元素可提供有关页面的元信息（meta-information），比如针对搜索引擎和更新频度的描述和关键词。
    <meta> 标签永远位于 head 元素内部。元数据总是以名称/值的形式被成对传递的
    参考 http://www.w3school.com.cn/tags/tag_meta.asp
    content 是必选属性
    http-equiv 可选属性 把 content 属性关联到 HTTP 头部。
    --%>
</head>
<body>
<form action="pet.view" method="post">
    <%--
    目前大多数浏览器支持 <label> 标签。不向用户呈现任何特殊效果。它为鼠标用户改进了可用性。
    当用户选择该标签时，浏览器就会自动将焦点转到和标签相关的表单控件上。
    "for" 属性可把 label 绑定到另外一个元素。请把 "for" 属性的值设置为相关元素的 id 属性的值。
    参考 http://www.runoob.com/tags/tag-label.html
    --%>
    <label>
        姓名: <input type="text" name="user" value="dashuai"/>
    </label> <br>
    <label>
        邮箱：<input type="text" name="email" value=""/> <br>
    </label>
    <label>喜欢的宠物：</label><br>
    <%--下拉菜单--%>
    <select name="type" size="3" multiple="true" title="">
        <option value="猫">猫</option>
        <option value="狗">狗</option>
        <option value="鸟">鸟</option>
    </select>
    <br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
