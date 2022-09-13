<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"href="css/stylesproveedor.css">
<meta charset="ISO-8859-1">
<meta http-equiv="X-AU-Compatible"content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Datos Proveedor</title>
</head>
<body>

<header class="container">
  <div class="container_div">
    <nav class="nav">
      <ul >
          <li><a href="menuprincipal.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
          <h1> Datos del Proveedor</h1>
     </ul>
    </nav>
 </div>
 </header>
<main>
   
   <form action="Servletproveedor" class="formulario"id="formulario"method="post">
   
    <!-- grupo nit -->
    
      <div class="formulario__grupo" id="grupo_nit">
         <label for="nit" class="formulario__label">Nit</label>
          <div class="formulario__grupo-input">
             <input type="text" name="Nit" value="${Proveedor.getNit()}" class="formulario__input"  id="nit" placeholder="Nit">
          </div>
        
     </div>
     
    <!--Grupo nombre -->
      <div class="formulario__grupo" id="grupo__nombre">
           <label for="nombre" class="formulario__label">Nombre</label>
           <div class="formulario__grupo-input">
                <input type="text" name="nombre" value="${Proveedor.getNombre_proveedor()}" class="formulario__input" id="nombre" placeholder="Nombre">
          </div>
          
      </div>
       
        <!-- Grupo direccion -->
      <div class="formulario__grupo" id="grupo__direccion">
         <label for="direccion" class="formulario__label">Direccion</label>
         <div class="formulario__grupo-input">
             <input type="text" name="direccion" value="${Proveedor.getDireccion()}" class="formulario__input"  id="direccion" placeholder="Direccion">
         </div>
        
      </div> 
      
            <!-- Grupo telefono -->
      <div class="formulario__grupo" id="grupo__telefono">
         <label for="telefono" class="formulario__label">Telefono</label>
         <div class="formulario__grupo-input">
             <input type="text" name="telefono" value="${Proveedor.getTelefono()}" class="formulario__input" id="telefono" placeholder="Telefono">
         </div>
          
     </div>    
            
            <!-- Grupo ciudad -->
      <div class="formulario__grupo-1" id="grupo__ciudad">
          <label for="cuidad" class="formulario__label">Ciudad</label>
          <div class="formulario__grupo-input">
             <input type="text" name="ciudad" value="${Proveedor.getCiudad()}" class="formulario__input" id="ciudad" placeholder="Ciudad-Pais">
          </div>
     </div>  
       
            <!--mensajes y botones-->
     
      <div class="formulario_mensaje" id="formulario_mensaje">
        
      </div>
     <div class="botones" id="botones">
	         <button type="submit" name="crear" class="formulario_btn4">Crear</button>
	         <button type="submit" name="consultar" class="formulario_btn3">Consultar</button>
	         <button type="submit" name="actualizar"class="formulario_btn2">Actualizar</button>
	         <button type="submit" name="eliminar"class="formulario_btn1">Eliminar</button>
    </div>
  </form>
  
  
</main>

<div class="vista_wave" style="overflow: hidden;">
			<svg viewBox="0 0 500 150" preserveAspectRatio="none"
				style="height: 100%; width: 100%;">
				<path
					d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
					style="stroke: none; fill: #fff;"></path></svg>  
   </div>

<script src="https://kit.fontawesome.com/9a15d400d4.js" crossorigin="anonymous"></script>
</body>
</html>

