<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	text-align: center;
	padding-top: 230px;
}

form {
	display: inline-block;
}
</style>
<body>
<form method=post action="ForgetPassword">
<table>
	
<tr>
<td align = "left">PhoneNumber</td>
<td>
<input type="number" name="phone_number"></td>
</tr>
<tr>
<td></td>
</tr>
<tr>
<td align = "left">Password</td>
<td>

<input type="text" name="password"></td>
</tr>
<tr>
<td></td>
</tr>
</table>
<button type="submit">Submit</button>

</form>

</body>
</html>