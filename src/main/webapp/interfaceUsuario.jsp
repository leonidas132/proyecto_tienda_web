<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"href="css/stylesusuario.css">
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Datos Usuario</title>
</head>
<body>

<header class="container">
  <div class="container_div">
    <nav class="nav">
      <div>
          <ul>
              <li><a href="menuprincipal.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
          </ul>
      </div>
      <ul >
         
          <h1> Datos del Usuario</h1>
     </ul>
    </nav>
 </div>
 </header>
  <main>
 
     <form action="CRUDUsuarios" class="formulario" id="formulario" method="post">
     
            <!-- grupo cedula -->
       <div class="formulario__grupo " id="grupo__cedula">
        <label for="cedula" class="formulario_label">Cedula</label>
         <div class="formulario__grupo-input">
            <input type="text" class="formulario__input"  name="cedula" value="${usuario.getCedula_Usuario()}" id="cedula" placeholder="Cedula">
          
         </div>
           
       </div>
       
     <!-- grupo nombre -->
     <div class="formulario__grupo" id="grupo__nombre">
        <label for="nombre" class="formulario_label">Nombre</label>
         <div class="formulario__grupo-input">
           <input type="text" class="formulario__input" name="nombre" value="${usuario.getNombre_Usuario()}" id="nombre" placeholder="Nombre">
          </div>
       </div>
            <!-- grupo gmail -->
       <div class="formulario__grupo" id="grupo__gmail">
        <label for="gmail" class="formulario_label">Gmail</label>
         <div class="formulario__grupo-input">
           <input type="email" class="formulario__input" name="gmail" value="${usuario.getEmail_Usuario()}" id="gmail" placeholder="Correo Electronico">
          </div>
       </div>
       
            <!-- grupo usuario -->
       <div class="formulario__grupo" id="grupo__usuario">
        <label for="usuario" class="formulario_label">Usuario</label>
         <div class="formulario__grupo-input">
           <input type="text" class="formulario__input" name="usuario" value="${usuario.getUsuario()}" id="usuario" placeholder="User ID">
         </div>
       </div>
       
             <!-- grupo contraseña -->
      <div class="formulario__grupo" id="grupo__password">
        <label for="password" class="formulario_label">Contraseña</label>
         <div class="formulario__grupo-input">
           <input type="Password" class="formulario__input" name="password" value="${usuario.getPassword()}" id="password" placeholder="******">
         </div>
      </div>
        
       <!-- grupo contraseña 2-->
      <div class="formulario__grupo" id="grupo__password2">
        <label for="password2" class="formulario_label">Verificar contraseña</label>
         <div class="formulario__grupo-input">
           <input type="Password" class="formulario__input" name="password2" value="${usuario.getPassword()}" id="password2" placeholder="******">
         </div>
      </div>
	     
	     
       
       <div class="formulario__mensaje" id="formulario__mensaje">
        
       </div>
       <div class="formulario__grupo formulario__grupo-btn-opciones">
         <button type="submit" class="formulario__btn btn1"name="crear">Crear</button>
         <button type="submit" class="formulario__btn"name="consultar">Consultar</button>
         <button type="submit" class="formulario__btn"name="actualizar">Actualizar</button>
         <button type="submit" class="formulario__btn"name="eliminar" >Eliminar</button>
         <p class="formulario__mensaje-exito" id=formulario__mensaje-exito>proceso exitoso..!</p>
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
