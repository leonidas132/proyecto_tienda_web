<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styleproductos.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Gestion de productos</title>
</head>
<body>
<nav class="nav">
				<ul>
				  <li><a href="interfacemenureportes.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
				</ul>
			</nav>
	<header class="container">
		<div class="container_div">
		
			<div class="cont_titulo">
				<h1 class="titulo">Gestion de productos</h1>

			<!--  </div>

			<div class="formulario__grupo formulario__grupo-btn-opciones">
				<button type="submit" class="formulario__btn btn1" name="accion" value="crear">Cargar</button>
				
			</div>-->
		
		
		

	</div>
	
  </div>
	</header>
	<main>
		<div>
			<form action="Productos?accion=crear" class="formulario"
				method="POST" enctype="multipart/form-data">
				<input class="formulario__input" type="file" name="archivo"
					id="formFile" accept="text/csv" required>
				<div class="formulario__mensaje" id="formulario__mensaje">
					<p>
						<i class="fas fa-exclamation-triangle"></i><b>Error: </b>
					</p>
				</div>
				<div class="formulario__grupo formulario__grupo-btn-opciones">
					<button type="submit" class="formulario__btn btn1" name="accion"
						value="crear">Cargar</button>
					<p class="formulario__mensaje-exito" id=formulario__mensaje-exito>proceso
						exitoso..!</p>
				</div>



				<div class="dropdown-divider"></div>

				<div class="form-group">
					<table class="table table-hover">
						<thead>
							<tr class="text-center">
								<th style="color: white;">Codigo Producto</th>
								<th style="color: white;">Iva Compra</th>
								<th style="color: white;">Nit Proveedor</th>
								<th style="color: white;">Nombre Producto</th>
								<th style="color: white;">Precio Compra</th>
								<th style="color: white;">Precio Venta</th>
								<th style="color: white;">ACCION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="Pro" items="${productos}">
								<tr class="text-center">
									<td style="color: white;">${Pro.getCodigo_producto()}</td>
									<td style="color: white;">${Pro.getIvacompra()}</td>
									<td style="color: white;">${Pro.getNitproveedor()}</td>
									<td style="color: white;">${Pro.getNombre_producto()}</td>
									<td style="color: white;">${Pro.getPrecio_compra()}</td>
									<td style="color: white;">${Pro.getPrecio_venta()}</td>
									<td class="d-flex"><a href="#" class="btn btn-warning ">Editar</a> <a
										href="#" class="btn btn-danger" style="margin-left: 10px">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
		</div>


	</main>

	<script src="https://kit.fontawesome.com/9a15d400d4.js"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
   <script src="https://kit.fontawesome.com/9a15d400d4.js" crossorigin="anonymous"></script>
 
</html>