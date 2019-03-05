<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>
				<form method="post" action="AddAuthor">
					<table>
						<tr>
							<td></td>
							<td>Add Author:</td>
						</tr>
						<tr>
							<td></td>
						</tr>

						<tr>
							<td>name:</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>
								<button type="submit">Add</button>
							</td>
						</tr>

					</table>

				</form>
			</td>
		</tr>
		</table>

</body>
</html>