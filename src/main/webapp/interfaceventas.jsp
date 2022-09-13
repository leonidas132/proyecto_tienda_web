<%@page import="javax.*" %>
<%@page import="modelo.*" %>
<%@page import="controlador.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"href="css/StyleVentas.css">
<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
<meta charset="ISO-8859-1">
<meta http-equiv="X-AU-Compatible"content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Area de Ventas</title>

	<style>
		body{
			font-family: 'Squada One', cursive;
			font-size: 15px;
			color:#F3F1FB ;
			background-image: url(./css/imagen/registro.jpg);
		    background-repeat: no-repeat;
			background-size: cover;
			background-attachment: fixed;
			background-position: center;
			position: relative;
		}
	</style>

</head>

<body>

 
<header class="container">
  <div class="container_div">
      <h1>AREA DE VENTAS</h1>
    <nav class="nav">
    
      <ul >
        <li><a href="menuprincipal.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
         
     </ul>
    </nav>
 </div>
 </header>

<section>

<div class="form-container">

<form action="Ventas" id="formulario"method="post">
	 <fieldset class="field_set">
	<legend>Identificacion Cliente</legend>
  	

  	<div class="busqueda">
  	 	  
      <input id="Cedula" name="Cedula" value="${cliente.getCedula_Cliente()}" style="width:150px;height:25px" placeholder="  Numero Cedula  "/>
      <button type="submit" name="Consultar" class="formulario_btn1" style="margin: 10px">   Consultar  </button>
      
  	  <label for="Cliente"  style="margin: 10px">Cliente</label >
 	  <input id="Cliente" name="Cliente" value="${cliente.getNombre_Cliente()}" style="width:300px;height:25px" />
 	  
 	  <!---<label for="Consecutivo" style="margin: 10px">Consecutivo</label>
      <input id="Consecutivo" name="Consecutivo" value="" />--->
      
    
  	</div>

	</fieldset>

 <fieldset class="field_set">
<div class = "wrapper">
	<label class="titulo" style="margin: 20px" for="producto">Cod_Producto</label>
	 	
      <!-- <select id="producto" name="producto">
        <option value=""></option>
        <option value="producto1">Producto 1</option>
        <option value="producto2">Producto 2</option>
        <option value="producto3">Producto 3</option>
      </select> -->
      
      <input id="Codigo" name="CodigoProducto1" value="${producto1.getCodigo_producto()}" style="width:90px;height:25px" placeholder="Cod_Producto"/>
     
      <button type="submit" name="Consultar1" class="formulario_btn2"style="margin: 10px">   Consultar  </button>
      
      <input type= "text" style="width:280px;height:25px" class="form__input" id="Nom_Producto" name="Nom_Producto" value="${producto1.getNombre_producto()}" placeholder="Nombre del producto" />
      <input type= "text" style="width:40px;height:25px" class="form__input" id="Cantidad" name="Cantidad1" value="" placeholder="Cant"/>
      <input type= "text" style="width:150px;height:25px" class="form__input" id="valor_total" name="Valor_total1" value="${producto1.getPrecio_venta()}" placeholder="Valor" />
      
   

</div>
 
  
<div>
	<label class="titulo" style="margin: 20px" for="producto">Cod_Producto</label>
	
      <!--<select id="producto" name="producto">
        <option value=""></option>
        <option value="producto1">Producto 1</option>
        <option value="producto2">Producto 2</option>
        <option value="producto3">Producto 3</option>
      </select>--->
      
      <input id="Codigo" name="CodigoProducto2" value="${producto2.getCodigo_producto()}" style="width:90px;height:25px" placeholder="Cod_Producto"/>
      
      <button type="submit" name="Consultar2" class="formulario_btn3" style="margin: 10px">   Consultar  </button>
     
      <input type= "text" style="width:280px;height:25px" class="form__input" id="Nom_Producto" name="Nom_Producto" value="${producto2.getNombre_producto()}" placeholder="Nombre del producto" />
      <input type= "text" style="width:40px;height:25px" class="form__input" id="Cantidad" name="Cantidad2" value="" placeholder="Cant"/>
      <input type= "text" style="width:150px;height:25px" class="form__input" id="valor_total" name="Valor_total2" value="${producto2.getPrecio_venta()}" placeholder="Valor" />
    

</div>
  
  <div>
	<label class="titulo" style="margin: 20px" for="producto">Cod_Producto</label>
	
     
      
      <input id="Codigo" name="CodigoProducto3" value="${producto3.getCodigo_producto()}" style="width:90px;height:25px" placeholder="Cod_Producto"/>
      
      <button type="submit" name="Consultar3" class="formulario_btn4" style="margin: 10px">   Consultar  </button>
      
      <input type= "text" style="width:280px;height:25px" class="form__input" id="Nom_Producto" name="Nom_Producto" value="${producto3.getNombre_producto()}" placeholder="Nombre del producto" />
      <input type= "text" style="width:40px;height:25px" class="form__input" id="Cantidad" name="Cantidad3" value="" placeholder="Cant" />
      <input type= "text" style="width:150px;height:25px" class="form__input" id="valor_total" name="Valor_total3" value="${producto3.getPrecio_venta()}" placeholder="Valor"/>
      
	</div>
	<button type="submit" name="Confirmar" class="formulario_btn5" style="margin: auto;">Confirmar_Venta</button>
	
 </fieldset>	

  <!--<fieldset class="field_set" style="width:350px" >
 
	 <div>
  	<label class="titulo2" for="Subtotal" style="margin: 20px">SUBTOTAL</label>
  	<input type="text" id="Subtotal" name="Subtotal" style="margin: 5px" value="" style="width:130px;height:20px" />
   	
  	<label class="titulo2" for="IVA"style="margin: 20px">IVA</label>
  	<input type="text" id="IVA" name="IVA" style="margin: 15px" value="" style="width:150px;height:25px" />
  	
  	<label class="titulo2" for="Total_Venta"style="margin: 20px">TOTAL</label>
  	<input type="text" id="Total_Venta" name="Total_Venta" style="margin: 3px"value="" style="width:150px;height:25px"/>
  	
	</div> 
 </fieldset>-->
 
	
	<input hidden="" type="text" name="CedulaUsuario" value="${Inicio.getCedula_Usuario()}"> <!-- style="display: none;"--->
 
</form>

</div>
</section>
   <script src="https://kit.fontawesome.com/9a15d400d4.js" crossorigin="anonymous"></script>

</body>
</html>
