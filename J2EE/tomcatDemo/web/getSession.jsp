<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/24
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<%
    String name = (String)session.getAttribute("name");//通过session。根据"name"取出对应的名称
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
session中的nama值：<%=name%>
</body>
</html>
