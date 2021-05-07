<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="js/cart.js" ></script>
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
            <div class="container col-lg-8">
		         <h1>Listado de productos en su carrito de compra</h1>
		        <table class="table table-primary table-borderless ">
		            <thead>
		                <tr>
		                <th scope="col">Id</th>
		                <th scope="col">Nombre</th>
		                <th scope="col">Descripcion</th>
		                <th scope="col">Precio</th>
		                <th scope="col">Acciones</th>
		                </tr>
		            </thead>
		            <tbody id="cartList">

		            </tbody>
		            </table>
		          
		    </div>
		    
		    <div class="alert alert-success" role="alert" style="display:none" id="customAlert">
		    	<p id="total"></p>
			</div>
		    
     </section>
</body>
</html>