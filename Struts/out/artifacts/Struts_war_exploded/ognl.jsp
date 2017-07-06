<%--
  Created by IntelliJ IDEA.
  User: 王宁
  Date: 2017/6/30
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:textfield name="username" value="%{#request.req}"></s:textfield>
</body>
</html>
