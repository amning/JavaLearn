<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/27
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车</title>
<h1 style="text-align: center">购物车</h1>
<script>
    $(function(){
        $("a").addClass("btn btn-default btn-xs");

    });

</script>
</head>

<c:if test="${!empty user}">

</c:if>
<div>


</div>
<div align="center">当前用户:${user.name}</div>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

    <tr>

        <td>商品名称</td>
        <td>单价</td>
        <td> 数量</td>
        <td> 小计</td>
        <td>删除</td>
    </tr>
       <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td>${oi.product.price*oi.num}</td>
            <td><a href="deleteOrderItem?pid=${oi.product.id}">删除</a></td>
        </tr>
    </c:forEach>
    <c:if test="${!empty ois}">
        <tr>
            <td>
                <a href="/orderCreat">提交订单</a>
            </td>

        </tr>

    </c:if>

</table>

<nav>
    <ul class="pager">
        <li><a href="/listProduct">返  回</a></li>
        <li><a href="login.jsp">退  出</a></li>
    </ul>
</nav>
