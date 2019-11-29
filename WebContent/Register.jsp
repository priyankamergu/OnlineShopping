<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="CustomerContoller" >
	

		
		<table>
		<tr>
				<td>Customer Name</td>
				<td><input type="text" name="cname"></td>

			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile"></td>

			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="uname"></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login">
				<td><input type="Reset" value="Reset">
			</tr>

		</table>
	</form>
</body>
</html>