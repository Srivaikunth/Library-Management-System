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
	
	background:url("Welcome.jpg");
	background-repeat:no-repeat;
	background-size:100%;
	text-align: center;
	padding-top: 230px;
	font-size:24px;
}

form {
	display: inline-block;
}
</style>
<body>
<form method="post" action="StudentServlet">
	<table>
	
<tr>
<td align = "left">Name</td>
<td>
				<input type="text" name="student_name"></td>
				</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
			<td align = "left">Phonenumber:</td>
		
			<td>	<input type="number" name="phone_number"></td>
			</tr>
			
			<tr>
				<td></td>
			</tr>
			<tr>
			<td align = "left">Address:</td>
			<td>
	
				<input type="text" name="address"></td>
				</tr>
				<tr>
			<td align = "left">Password:</td>
		
			<td>	<input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td></td>
			</tr>
				</table>
								<button type="submit">Register</button>
				
				</form>


</body>
</html>