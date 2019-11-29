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
<form action="ProductController" method="post">
<c:if test="${param.action eq 'edit' }">
<input type="hidden" name="action" value="update">
</c:if>

<c:if test="${param.action eq null}">
<input type="hidden" name="action" value="save">
</c:if>


<table border=1>

	<tr>
	<td>ID</td>
	<td><input type="text" name="id" id="id" value="${productEdit.id}"></td>
	</tr>
	
	<tr>
	<td>Code</td>
	<td><input type="text" name="code" id="code" value="${productEdit.code}"></td>	
	</tr>
	
	<tr>
	<td>Description</td>
	<td><input type="text" name="desc" id="desc" value="${productEdit.description}"></td>
	</tr>
	
	<tr>
	<td>Price</td>
	<td><input type="text" name="price" id="price" value="${productEdit.price}"></td>
	</tr>
	
	<tr>
	<td>Date</td>
	<fmt:formatDate value="${productEdit.manfDate }" pattern="dd/mm/yyyy" var="manfDate"/>
	<td><input type="text" name="date" id="date" value="${manfDate}"></td>
	</tr>
	
	<tr><td><input type="submit" name="submit" value="submit"></td>
	<td><input type="reset" name="reset" value="reset"></td>
	</tr>

</table>
</form>
</body>
</html>