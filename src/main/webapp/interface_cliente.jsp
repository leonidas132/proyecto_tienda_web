<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"href="css/StyleCliente.css">
<meta charset="ISO-8859-1">
<meta http-equiv="X-AU-Compatible"content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Datos_Clientes</title>
		
		<style>
		@import url('https://fonts.googleapis.com/css2?family=Squada+One&display=swap');
		body{
		
	        font-family: 'Squada One', cursive;
			font-size: 15px;
			color:#F3F1FB ;
			background-image: url(css/imagen/principal.jpg);
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
    <nav class="nav">
      <ul >
          <li><a href="menuprincipal.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
          
     </ul>
    </nav>
 </div>
 </header>
 
 <h1>AREA DE CLIENTES</h1>
<section>
    <div class="form-container">
    
   
   <form action="CRUDClientes" class="formulario"id="formulario" method="post">
   
    <!-- grupo cc -->
    
      <div class="formulario__grupo" id="grupo_Cedula">
         <label for="cedula" class="formulario__label">Cedula</label>
          <div class="formulario__grupo-input">
               

             <input type="text" name="Cedula" value="${clientes.getCedula_Cliente()}" class="formulario__input"  id="Cedula" placeholder="Cedula">
              
         </div>
       
     </div>
     
    <!--Grupo nombre -->
    
      <div class="formulario__grupo" id="grupo__nombre">
           <label for="nombre" class="formulario__label">Nombre</label>
           <div class="formulario__grupo-input">

                <input type="text" name="Nombre" value="${clientes.getNombre_Cliente()}" class="formulario__input" id="nombre" placeholder="Nombre">
                 
       	   </div>
           
       </div>
       
        <!-- Grupo direccion -->
        
      <div class="formulario__grupo" id="grupo__direccion">
         <label for="direccion" class="formulario__label">Direccion</label>
         <div class="formulario__grupo-input">

             <input type="text" name="Direccion" value="${clientes.getDireccion_Cliente()}" class="formulario__input"  id="direccion" placeholder="Direccion">
            
         </div>
      
      </div> 
      
            <!-- Grupo telefono -->
            
      <div class="formulario__grupo" id="grupo__telefono">
         <label for="telefono" class="formulario__label">Telefono</label>
         <div class="formulario__grupo-input">

             <input type="text" name="Telefono" value="${clientes.getTelefono_Cliente()}" class="formulario__input" id="telefono" placeholder="Telefono">
             
         </div>
       
      </div>    
            
            <!-- Grupo Email -->
            
      <div class="formulario__grupo-1" id="grupo__email">
          <label for="e-mail" class="formulario__label">Email</label>
          <div class="formulario__grupo-input">

          <input class="formulario__input" id="Email" type="text" name="Correo" value="${clientes.getEmail_Cliente()}" placeholder=Email>
            
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
     
     
     <div class="botones" id="botones">
	         <button type="submit" name="Crear" class="formulario_btn4">   Crear  </button> 
	         <button type="submit" name="Buscar" class="formulario_btn3">Consultar </button>
	         <button type="submit" name="Actualizar"class="formulario_btn2">Actualizar</button> 
	         <button type="submit" name="Borrar"class="formulario_btn1"> Eliminar </button> 
	         
    </div>
    	
  </form>
  
  </div>
</section>
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
