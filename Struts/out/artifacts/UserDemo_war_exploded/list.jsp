<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/6/28
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<c:forEach items="${Customers}}" var="customer">
    <td>${customer.custName}</td>
    <td>${customer.custLevel}</td>
    <td>${customer.custSource}</td>
    <td>${customer.custPhone}</td>
    <td>${customer.custMobile}</td>
</c:forEach>
</body>
</html>
