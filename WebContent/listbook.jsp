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
	<h3>List of books</h3>
	<table border="3">
		<thead>
			<tr>
				<th>isbn</th>
				<th>name</th>
				<th>price</th>
				<th>author_id</th>
				<th>author name</th>
				<th>publication_id</th>
				<th>publication_name</th>
				
				
					
				
			</tr>
		</thead>
		<tbody>

			<c:forEach var="book" items="${BOOKS}">
				<tr>
					<td>${book.isbn}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.getAuthor().getId()}</td>
					<td>${book.getAuthor().getName()}</td>
					<td>${book.getPublication().getId()}</td>
					<td>${book.getPublication().getName()}</td>
					
				   
					
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