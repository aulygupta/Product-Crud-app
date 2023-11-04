<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
<div class="row">
<h1 class="text-center mb-3">Fill the Product Detail</h1>
</div>
<form action="handle-product" method="post">
<div class="form-group">
<label for="name">Product Name</label>
<input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name" placeholder="Enter the product name here"/>
</div>
<div class="form-group">
<label for="description">Product Description</label>
<textarea class="form-control" id="description" rows="5" name="description" placeholder="Enter the product description"></textarea>
</div>
<div class="form-group">
<label for="price">Product Price</label>
<input type="text" class="form-control" id="price" name="price" placeholder="Enter product price"/>
</div>
<div class="conatiner text-center">
<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
<button type="submit" class="btn btn-primary">Add</button>
</div>
</form>

</div>
</div>
</body>
</html>