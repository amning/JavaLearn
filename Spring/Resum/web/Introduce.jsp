<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/All.css" />
    <title>Introduce</title>
</head>
<body>
<center><h2>Welcome To Curriculum Vitae System</h2></center>
<center><h4>Please Introduce yourself.</h4></center>
<div class="list_center">
    <form action="addIntroduce" method="post">
        <table width="300" height="500" border="0" align="center">
            <tr>
                <td align="center">Introduce:</td>
                <td><textarea id="ta1"  name="Introduce" style="width:500px;height:300px;" ></textarea></td>
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
