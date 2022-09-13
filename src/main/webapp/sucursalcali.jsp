<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"href="css/Stylescali.css">
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <script type="text/javascript" src="js\jquery-3.6.0.min.js"></script>
 <script type="text/javascript" src="js\consulta.js"></script>
</head>
<body>
<header class="container">
  <div class="container_div">
    <nav class="nav">
      <ul >
          <li><a href="interfacemenureportes.jsp"class="nav_inicio"><i class="fas fa-home"></i></a></li>
     </ul>
    </nav>
 </div>
 </header>
<div class="clas">
 <section class="formulario">
   <form class="form">
      <button type="button"name="lista"class="usu"id="lista">Lista Clientes</button>
      <button type="button"name="ventas"class="ven"id="ventas">Ventas Clientes</button>
     <!--  <button type="button"name=""class=""id=""></button>--> 

   </form>
   <table id="tabla"class="tb">
   
   
   
   </table>
  
 
 
 </section>
 <div class="vista_wave" style="overflow: hidden;">
			<svg viewBox="0 0 500 150" preserveAspectRatio="none"
				style="height: 100%; width: 100%;">
				<path
					d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
					style="stroke: none; fill: #fff;"></path></svg>  
   </div>
 </div>
   <script src="https://kit.fontawesome.com/9a15d400d4.js" crossorigin="anonymous"></script>

</body>
</html>