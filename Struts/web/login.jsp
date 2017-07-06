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
<title>用户登录</title>
<h3 style="text-align: center">已有用户登录</h3>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
  <%--${pageContext.request.contextPath}--%>
  <form action="/login" method="post">
    <tr>
      <td>账号 ： <input type="text" name="username"> <br></td>
      <td>密码: <input type="password" name="password"> <br></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="登录"></td>
    </tr>
  </form>
</table>
<nav>
  <ul class="pager">
    <li><a href="index.jsp">返  回</a></li>
  </ul>
</nav>