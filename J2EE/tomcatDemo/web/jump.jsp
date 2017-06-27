<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/24
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<html>
<head>
    <title>这是一个跳转页面</title>
</head>
<body>
<%
    //response.sendRedirect("Login.html");客户端跳转

    //request.getRequestDispatcher("Login.html").forward(request,response);服务器跳转

%>
<%--jsp动作 简化代码--%>
<jsp:forward page="Login.html"></jsp:forward>
</body>
</html>
