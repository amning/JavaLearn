<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/4/24
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<%
    Cookie[] cookies = request.getCookies();
    if(null!=cookies){
        for (int d=0 ; d <=cookies.length-1;d++){
            out.print(cookies[d].getName()+':'+cookies[d].getValue()+"<br>");
        }
    }
%>
<html>
<head>
    <title>获取cookies</title>
</head>
<body>

</body>
</html>
