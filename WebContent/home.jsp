<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="addauthor.jsp">
					<button type="submit">AddAuthor</button>
			</a></td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td>
				<form method="post" action="BookServlet">
					<button type="submit">AddBook</button>
				</form>
			</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td><a href="addpublication.jsp">
					<button type="submit">AddPublication</button>
			</a></td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td><a href="updateprice.jsp">
					<button type="submit">Update</button>
			</a></td>
		</tr>

	</table>


</body>
</html>