<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
form
{
	display:inline-block;
}
.image
{
	padding-top:150px;
	padding-left:360px;
}
</style>
<title>Insert title here</title>
</head>

<body>
	<div class="image">
	<img src="admin.png"/> 
	
<form method="post" action="LoginServlet">
<table>
<tbody>
	<tr> 
		<td> <h3> Welcome Admin </h3> </td>
	</tr>
<tr>
<td align="left" style="font-size: 20px">username:</td>
   <td><input type="text" name="username"></td>
   </tr>
   <tr> <td> &nbsp; </td> </tr>
   <tr>
   <td align="left" style="font-size: 20px">password:</td>
   <td><input type="password" name="password"></td>
   
</tr>
<tr> <td> &nbsp; </td> </tr>
</table>
<table align="center">
<tr>
<td>
<button type="submit">Login</button>
</td>
</tr>
</tbody></table>
</form>
</div>
</body>
</html>