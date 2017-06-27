<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/24
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>

<%

    Cookie cookie =new Cookie("name","Gareen");
    cookie.setMaxAge(60*24*60);
    cookie.setPath("127.0.0.1");
    response.addCookie(cookie);

%>


<html>
<head>
    <title>设置Cookie</title>
</head>
<body>
    <a href="getCookie.jsp">获取cookie页面</a>
</body>
</html>
