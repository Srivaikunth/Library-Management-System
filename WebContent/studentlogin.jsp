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
	background:url("librearyMS.jpg");
	background-repeat:no-repeat;
	background-size:100%;
	text-align: center;
	padding-top: 400px;
}

form {
	display: inline-block;
}
</style>
<body>
<form method="post" action="StudentLoginServlet">
<table>
<tbody>
<tr> 
		<td> <h3> Welcome Student </h3> </td>
	</tr>
<tr>
<td align="left">StudentName:</td>
   <td><input type="text" name="student_name"></td>
   </tr>
   <tr>
   <td align="left">Password:</td>
   <td><input type="password" name="password"></td>
</tr>
</table>
<table>
<tr>
<td>
<button type="submit">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td><a href ="forgetpassword.jsp">Forget Password</a>

</tr>
<tr><td>${status}</td></tr>
</tbody></table>
</form>
</body>
</html>