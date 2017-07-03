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
<!--使用struts2标签查看值栈结构-->
<s:debug></s:debug>
<!-- 获取值栈对象的值-->
<s:property value="user1.username"></s:property>
<!-- 获取list集合的数据-->
    <!--s1:-->
    <s:property value="list[0].username"/><br/>
    <!--s2-->
    <s:iterator value="list">
        <s:property value="username"></s:property><br/>
    </s:iterator>
    <!--s3-->
    <s:iterator value="list" var="user">
        <tr>
         <td><s:property value="#user.username"></s:property></td>
            <td><s:property value="#user.email"></s:property></td>
            <td><s:property value="#user.password"></s:property></td>
        </tr>
    </s:iterator>
<s:debug></s:debug>
</body>
</html>
