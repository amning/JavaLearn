<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/All.css" />
    <title>Insert title here</title>
</head>
<body>
<div class="word_center">
    You have added all the information, and now you can  download it.
    <br>
    <a href="download?Userid=<%=session.getAttribute("loginuser") %>"><input type="submit" value="downloads"></a>
</div>
</body>
</html>