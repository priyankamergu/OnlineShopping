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



<a href="ProductDatabaseController?action=new">Add</a>
<br/>
<br/>
<h1>List of All Product</h1>

<table border=1>
	<tr>
	<th>ProductID</th>
	<th>ProductCode</th>
	<th>ProductDescription</th>
	<th>ProductPrice</th>
	<th>ProductDate</th>
	<th>ProductCategoryList</th>
	<th>Action</th>
						
	</tr>
<c:forEach  var="row" items="${list}" >
<tr>
<td>${row.id}</td>
<td>${row.code}</td>
<td>${row.description}</td>
<td>${row.price}</td>
<td>
<fmt:formatDate value="${row.manfDate }" pattern="dd/mm/yyyy"/>
</td>
<td>${row.categoryList}</td>
<td><a href="ProductDatabaseController?action=edit&id=${row.id}">Edit</a> | <a href="ProductDatabaseController?action=delete&id=${row.id}">Delete</a>
</td>
</tr>
	
	</c:forEach>
	
</table>
</body>
</html>