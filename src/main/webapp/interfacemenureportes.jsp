  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"href="css/Stylesciudades.css">
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <script type="text/javascript" src="js\jquery-3.6.0.min.js"></script>
 <script type="text/javascript" src="js\consulta.js"></script>
 <title>SUCURSALES</title>
</head>
<body>

<header class="container">
 <nav class="nav">
       <ul >
          <li><a href="menuprincipal.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
     
          
     </ul>
    </nav>
    <div class="cont_titulo">
    <h1  class="titulo" style="">Reportes</h1>
 </div> 
 
</header>
<div>
      <ul class="opcion">
         <li><a href="sucursalcali.jsp"class="nav_cali"> Cali</a></li>
         <li><a href="sucursalmedellin.jsp"class="nav_i"> Medellin</a></li>
          <li><a href="interfacezbogota.jsp"class="nav_i">Bogota</a></li>
      </ul>
</div>
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