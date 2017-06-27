<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/24
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<%
    session.setAttribute("name","teemo");
%>
<html>
<head>
    <title>设置session</title>
</head>
<body>
<a href="getSession.jsp">获取session页面</a>
</body>
</html>
