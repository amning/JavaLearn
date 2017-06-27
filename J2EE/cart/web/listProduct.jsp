<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
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
<c:if test="${!empty user}">
     <div align="center" style="background-color: aquamarine">
        当前用户：${user.name}
    </div>
</c:if>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
    <tr style="text-align: center">
        <td>id</td>
        <td>名称</td>
         <td>价格</td>
        <td> 加购物车</td>

    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr style="text-align: center">
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>



            <td>   <form action="addOrderItem" method="post">
                  数量  <input type="text" value="1" name="num" style="width: 50px">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="submit" value="加购物车">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<nav>
    <ul class="pager">

           <li><a href="login.jsp">退  出</a></li>
    </ul>
</nav>