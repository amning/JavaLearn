<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/7/3
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>listUser</title>
</head>
<body>
<s:debug></s:debug>
<%--
<s:iterator value="list" var="user">
    <tr>

        <td> <s:property value="#user.username"></s:property></td>
        <td> <s:property value="#user.email"></s:property></td>

    </tr>

</s:iterator>
--%>
<c:forEach items="${list}" var="user">
    ${user.username}
</c:forEach>
</body>
</html>
