<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<form method="post" action="AddBook">
		<table>
			<tr>
				<td></td>
				<td>Add Book:</td>
			</tr>

			<tr>
				<td>Isbn:</td>
				<td><input type="number" name="isbn"></td>
			</tr>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>Author name</td>
				<td><select name="authorname">
						<c:forEach var="authorname" items="${Authorname}">
							<option value="${authorname.id }">${authorname.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Publication name</td>
				<td><select name="publicationid">
						<c:forEach var="publicationid" items="${Publicationname}">
							<option value="${publicationid.id}">${publicationid.name }</option>
						
						</c:forEach>
							
						
				</select></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<button type="submit">Add</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>