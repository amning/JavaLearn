<%@ page import="org.springframework.http.HttpRequest" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/All.css" />
    <title>Add Educational Success</title>
</head>
<body>

<div class="word_center">
    Add success
    <a href="Educational.jsp?loginuser=<%=session.getAttribute("loginuser") %>"><input type="submit" value="Continue"></a>
    <a href="Work.jsp?loginuser=<%=session.getAttribute("loginuser") %>"><input type="submit" value="Next"></a>
</div>
</body>
</html>