<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<add key="webpages:Enabled" value="true" />
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Menu Principal</title>
</head>
<body>

<div style="margin-top: 10px">
<form action="Compras" method="POST">
<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand">
  	 ¡Cadena de Tiendas la Generica - Sucursales en todo el Mundo!
  </a>
	<div class="dropdown show">
				<a style="margin-left: 15px; border: none" class="btn btn-outline-dark dropdown-toggle" href="#" role="button"
					id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ${Inicio.getNombre_Usuario()}</a>

				<div class="dropdown-menu text-center">
					 <a class="dropdown-item" href="#">${Inicio.getCedula_Usuario()}</a>
					 <a class="dropdown-item" href="#">${Inicio.getEmail_Usuario()}</a>
					 <input hidden="" type="text" name="CedulaUsuario" value="${Inicio.getCedula_Usuario()}">
					 <div class="dropdown-divider"></div>
						 
					 <button name="Salir" class="dropdown-item" href="#">Salir</button>
				</div>
			</div>
</nav>


	<div class="d-flex">
		<div class="col-sm-4">
			<div class="card">
			
				<div class="card-body">
				<!-- Busqueda Cliente -->
					<div class="form-group">
						<label>Datos del Cliente</label>
					</div>
					<div class="form-group d-flex">
						<div class="col-sm-6 d-flex">
							<input type="text" name="Cedula_Cliente" value="${Registro.getCedula_Cliente()}" placeholder="Cedula Cliente" class="form-control">
							<button name="BuscarCliente" class="btn btn-outline-info">Buscar</button>
						</div>
						<div class="col-sm-6">
							<input type="text" name="" value="${Registro.getNombre_Cliente()}" readonly placeholder="Datos Cliente" class="form-control">
						</div>
					</div>
					<!-- Busqueda Producto -->
					<div class="form-group">
						<label>Datos Producto</label>	
					</div>
					<div class="form-group d-flex">
						<div class="col-sm-6 d-flex">
							<input type="text" name="Codigo_Producto" value="${Producto.getCodigo_producto()}" placeholder="Codigo Producto" class="form-control">
							<button type="submit" name="BuscarProducto"  class="btn btn-outline-info">Buscar</button>
						</div>
						<div class="col-sm-6">
							<input type="text" name="nom_Producto" value="${Producto.getNombre_producto()}" readonly placeholder="Datos Producto" class="form-control">
						</div>
					</div>
					<div class="form-group d-flex">
						<div class="col-sm-6 d-flex">
							<input type="text" name="precio" value="${Producto.getPrecio_venta()}" readonly placeholder="Precio" class="form-control">
						</div>
						<div class="col-sm-2">
							<input type="number" value="1" name="cantidad" placeholder="" class="form-control">
							
						</div>
						<div class="col-ml-2">
							<button type="submit" class="btn btn-outline-info" name="Agregar">Agregar Producto</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Listar Productos en el Carrito -->
		<div class="col-sm-8">
			<div class="card">
				<div class="card-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Codigo de Producto</th>
								<th>Nombre Producto</th>
								<th>Precio</th>
								<th>Cantidad</th>
								<th>SubTotal</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="list" items="${lista}">
							<tr>
								<td>${list.getCodigo_Producto()}</td>
								<td>${list.getNombre_Producto()}</td>
								<td>${list.getPrecio_Procuto()}</td>
								<td>${list.getCantidad()}</td>
								<td>${list.getSub_total()}</td>
								<td>
									<!-- <a href="" class="btn btn-warning">Editar</a> -->
									<a href="" class="btn btn-danger">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="card-footer d-flex form-inline">
					<div class="col-sm-7">
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
						  Continuar Para Pagar
						</button>
						<button type="submit" class="btn btn-danger">Cancelar</button>
						
						<!-- Button trigger modal -->
						
						
						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 style="text-align: center;" class="modal-title" id="exampleModalLabel">Detalles de la Compra</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						      <table class="table table-hover">
									<thead>
										<tr>
											
											<th>Nombre Producto</th>
											<th>Precio</th>
											<th>Cantidad</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="list" items="${lista}">
										<tr>
									
											<td>${list.getNombre_Producto()}</td>
											<td>${list.getPrecio_Procuto()}</td>
											<td>${list.getCantidad()}</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
									<div class="ml-3" style="margin-top: 20px">
										<input class="btn btn-outline-info" readonly value="Iva">
										<input type="text" name="txtTotal"  value=" ${iva}%" readonly class="form-control">
										<input class="btn btn-outline-info" readonly value="Total Sin Iva">
										<input type="text" name="txtTotal" value=" $ ${SinIva}0" readonly class="form-control">
										<input class="btn btn-outline-info" readonly value="Total a Pagar">
										<input type="text" name="txtTotal" value=" $ ${Total}0" readonly class="form-control">
							
							
									</div>
						      
						        
						      </div>
						      <div class="modal-footer">
						        <button type="submit" name="GenerarVenta" class="btn btn-success">Realizar Compra</button>
						      </div>
						    </div>
						  </div>
						</div>
						
					</div>
					<div class="ml-3">
						<input class="btn btn-outline-info" value="Total a Pagar">
						<input type="text" name="txtTotal" value=" $ ${Total}0" readonly class="form-control">
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</div>















	<!--  <nav class="navbar navbar-expand-lg navbar-light bg-info">
		<a class="navbar-brand" href="">Sucursal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item"><a class="nav-link" href="#">Ofertas
						Del Dia</a></li>

				<li class="nav-item"><a class="nav-link disabled" href="#"> <i class="fas fa-cart-plus">( <label style="color: red;"></label> )</i> Carrito
						de Compras</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Usuario </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>

			</ul>
		</div>
	</nav>

	<div class="container mt-4">
		<div class="row text-center">
			<c:forEach var="pro" items="${productos}">
				<div class="col-sm-4">
					<div class="card">
						<div class="card-header"></div>
						<label>${pro.getNombre_producto()}</label>
						<div class="card-body"></div>
						<i>$ ${pro.getPrecio_venta()}</i>

						<div class="card-footer text-center">
							<label>Acciones</label>
							<div>
								<a href="Compras?accion=AgregarCarrito&id=${pro.getCodigo_producto()}" class="btn btn-outline-info">Agregar al Carrito</a> <a
									href="" class="btn btn-danger">Comprar</a>
							</div>
						</div>


					</div>

				</div>
			</c:forEach>
		</div>
	</div>
	-->
</body>
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
</html>