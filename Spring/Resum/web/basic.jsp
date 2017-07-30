<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/All.css" />　
    <title>Basic Page</title>
</head>
<body>
<center><h2>Welcome To Curriculum Vitae System</h2></center>
<center><h4>Please Input Your Essential information</h4></center>
<div class="list_center">
    <form action="basic" method="post">
        <table width="300" height="500" border="0" align="center">
            <tr>
                <td align="center">Name:</td>
                <td><input type="text" name="Name"></td>
            </tr>
            <tr>
                <td align="center">Address:</td>
                <td><input type="text" name="Address"></td>
            </tr>
            <tr>
                <td align="center">Gender:</td>
                <td><input type="text" name="Gender"></td>
            </tr>
            <tr>
                <td align="center">Age:</td>
                <td><input type="text" name="Age"></td>
            </tr>
            <tr>
                <td align="center">Email:</td>
                <td><input type="text" name="Email"></td>
            </tr>
            <tr>
                <td align="center">Tel:</td>
                <td><input type="text" name="Tel"></td>
            </tr>
            <tr>
                <td align="center">School:</td>
                <td><input type="text" name="School"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="Userid" value="<%=session.getAttribute("loginuser") %>"></td>

            </tr>
            <tr>
                <td >
                    <div class="submit">

                        <input type="submit" value="continue" >

                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>