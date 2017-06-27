<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/27
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
    $(function(){
        $("a").addClass("btn btn-default btn-xs");

    });


</script>
<html>
<head>
    <title>主页</title>
</head>
<body>
<nav>
    <ul class="pager">
        <li><a href="login.jsp" style="text-align: center" >用户登录</a></li>
        <li><a href="register.html" style="text-align: center" >用户注册</a></li>
    </ul>
</nav>
<%@include file="footer.jsp" %>
</body>
</html>
