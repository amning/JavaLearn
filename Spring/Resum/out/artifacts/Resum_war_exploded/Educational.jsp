<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/All.css" />
    <title>Educational Page</title>
</head>
<body>
<center><h2>Welcome To Curriculum Vitae System</h2></center>
<center><h4>Please Input Your Educational experience.You can add more than one</h4></center>
<div class="list_center">
    <form action="addEducational" method="post">
        <table width="300" height="500" border="0" align="center">
            <tr>
                <td align="center">School:</td>
                <td><input type="text" name="School"></td>
            </tr>
            <tr>
                <td align="center">Major:</td>
                <td><input type="text" name="Major"></td>
            </tr>
            <tr>
                <td align="center">Education:</td>
                <td><input type="text" name="Education"></td>
            </tr>
            <tr>
                <td align="center">Graduation Time:</td>
                <td><input type="text" name="Graduation"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="Userid" value="<%=session.getAttribute("loginuser") %>"></td>

            </tr>
            <tr>
                <td >
                    <div class="submit">

                        <input type="submit" value="Add" >

                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>