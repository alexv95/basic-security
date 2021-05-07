

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/category">Categoria</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/product">Productos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cart">Ventas</a>
      </li>

    </ul>

  </div>
</nav>
   <section id="register-form" class="container" >
		      <div class="container col-lg-4">
				<h2>Editar Producto</h2>
				<form:form action="/api/product/update" method="post" modelAttribute="producto">
					<form:hidden path="id"/>
					<form:label path="name">Nombre Producto: </form:label>
					<form:input path="name"  class="form-control mb-4" />
					<br>
					<form:label path="description">Desc Producto: </form:label>
					<form:input path="description" class="form-control mb-4" />
						<br>
					<form:label path="price">Precio Producto: </form:label>
					<form:input path="price" />
					<br>
					<form:label path="categories">Categoria: </form:label>
					<div class="col">
						<form:select path="categories" class="form-select">
						<option value="0">Seleccione categoria</option>
							<c:forEach var="categories" items="${listaCategorias}">
								<option value="<c:out value="${categories.id}"></c:out>"><c:out value="${categories.name}"></c:out> </option>
							</c:forEach>
						</form:select>
					</div>
					<input type="submit" value="Modificar">
				</form:form>
				<br>
		
			</div>
        
     </section>
</body>
</html>





