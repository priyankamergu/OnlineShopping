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



<a href="ProductController?action=new">Add</a>
<br/>
<br/>
<h1>List of All Product</h1>
<table border=1>
	<tr>
	<th>ID</th>
	<th>Code</th>
	<th>Description</th>
	<th>Price</th>
	<th>Date</th>
	<th>Action</th>
	</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.id}</td>
<td>${product.code}</td>
<td>${product.description}</td>
<td>${product.price}</td>
<td>
<fmt:formatDate value="${product.manfDate }" pattern="dd/mm/yyyy"/>
</td>

<td><a href="ProductController?action=edit&id=${product.id}">Edit</a> | <a href="ProductController?action=delete&id=${product.id}">Delete</a>
</td>
</tr>
	
	</c:forEach>
	
</table>
</body>
</html>