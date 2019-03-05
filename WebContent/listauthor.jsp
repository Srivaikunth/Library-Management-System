<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>List of authors</h3>
	<table>
		<thead>
			<tr>
				<th>author_name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="author" items="${Authors}">

				<tr>
					<td>${author.id}</td>
					<td>${author.name}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tr></tr><tr></tr>
		<tr><td>
		<a href ="home.jsp">
<button type="submit">back</button></a>
	</td></tr>
	</table>
	
</body>
</html>