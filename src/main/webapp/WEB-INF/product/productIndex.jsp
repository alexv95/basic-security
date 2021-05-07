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
<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
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
        <a class="nav-link" href="/cart">Carrito de compras</a>
      </li>

    </ul>

  </div>
</nav>

   <section id="register-form" class="container" >
        <form class="text-center border border-light p-5 col-lg-6" action="/api/product/create" method="POST">
                  <p class="h4 mb-4">Crear producto</p>
                  <div class="form-row mb-4">
                    <div class="col">
                      <input type="text" id="name" name="name" class="form-control mb-4" placeholder="Nombre" required>
                    </div>
                    <div class="col">
                      <input type="text" name="description" class="form-control mb-4" placeholder="descripcion" required>
                    </div>
                  </div>
                  <input type="number" name="price" class="form-control mb-4" placeholder="precio" required>
                  <!--  <div class="form-row mb-4">
                  	<div class="col">
                  		<select name="categories" class="form-select" >
							<option value="0">Seleccione categoria...</option>
								<c:forEach var="categoria" items="${listCategories}">
										<option value="<c:out value="${categoria.id}"></c:out>"><c:out value="${categoria.name}"></c:out> </option>
								</c:forEach>
						<select>
                  		</div>
                   </div>--> 
                  <button class="btn btn-info my-4 btn-block waves-effect waves-light" type="submit">Registrar producto</button>
        </form>  

     </section>
<section>
<div class="container">
	<table id="example" class="table table-striped table-bordered">
				<thead >
					<tr>
						<th>Nombre</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>accion</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "producto" items="${listProduct}">
					<tr>
					<td><c:out value="${producto.name}"></c:out></td>
					<td><c:out value="${producto.description}"></c:out></td>
					<td><c:out value="${producto.price}"></c:out></td>
					<td><a href="product/edit/${producto.id}">Editar</a></td>
					<td><a href="/api/product/delete/${producto.id}">Eliminar</a></td>
					<td><a href="/api/cart/add/${producto.name}/${producto.description}/${producto.price}">Agregar al carrito</a></td>
					
					
					</tr>
					</c:forEach>
				</tbody>
	</table>

</div>
</section>

<section>

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>accion</th>
				</tr>
			</thead>
		<tbody>
			<c:forEach var = "product" items="${pageProd.content}">
				<tr>
					<td> 
						<c:out value="${product.name}"></c:out>
					</td>
					<td><c:out value="${product.description}"></c:out></td>
					<td><c:out value="${product.price}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<c:forEach begin="1" end="${totalPagina}" var="index">
			<a href="/api/product/pagination/${index}">pagina : ${index}</a>
		</c:forEach>


</section>
			
	 
        

</body>

</html>