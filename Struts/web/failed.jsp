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


<script>
    $(function(){
        $("a").addClass("btn btn-default btn-xs");

    });


</script>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
<nav>
    <ul class="pager">
        登录失败<br/>
        <li><a href="login.jsp" style="text-align: center" >用户登录</a></li>
        <li><a href="register.html" style="text-align: center" >用户注册</a></li><br/>
    </ul>
</nav>
<%@include file="footer.jsp" %>
</body>
</html>
