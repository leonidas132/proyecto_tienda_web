<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesmenu.css">
<meta charset="ISO-8859-1">
<meta http-equiv="X-AU-Compatible" content="IE=edge">
<meta name="viewport" content="widht=device-width, initial-scale= 1.0">

<title>Menu Principal</title>

</head>
<body>


<%
HttpSession ObSesion=request.getSession();
String Sesion=(String)ObSesion.getAttribute("AccesoUserID");

%>

<label><%=Sesion %></label>

<header class="vista">
  <div class="container">
    <nav class="nav">
      <ul>
        <li> <a href="interfaceUsuario.jsp"id="usu" class="nav_usuario">Usuario</a> </li>	
        <li> <a href="interface_cliente.jsp"id="cli" class="nav_cliente">Cliente </a></li>
  	    <li><a href="interfaceproveedor.jsp"id="pro"   class="nav_proveedor">Proveedor</a></li>
        <li><a href="interfaceproductos.jsp"id="prod" class="nav_producto">Productos</a></li>
        <li> <a href="interfaceventas.jsp"id="ven" class="nav_ventas">Ventas</a></li>
  	    <li><a href="interfacemenureportes.jsp"id="rep" class="nav_reportes">Reportes</a></li>
  	    <li><a href="index.jsp" class="nav_reportes"><i class="fas fa-sign-out-alt"></i> </a></li>
      </ul>
   </nav>

  </div>
 <section class="vista_text">
   <div class="contend">
    
   </div>
  <!--    <div class="div">
    <h1 class="title">Quienes Somos </h1>
      <p class="text">Somos una empresa dedicada hace más de 20 años a la importación y distribución de componentes electrónicos de alta calidad,
                           totalmente garantizados y respaldados en busca de la perfecta aplicación del elemento adquirido.
                           Nuestro mayor objetivo es satisfacer las necesidades de nuestros clientes ofreciéndoles productos de última tecnología,
                            innovación y garantía de manera que se tenga confianza al 100 % en nuestro servicio.
		                    Nos caracterizamos por la calidad, seriedad y cumplimiento efectivo en el trabajo que realizamos.</p>
 
   </div>  -->
 </section> 
<div class="vista_wave" style="overflow: hidden;">
			<svg viewBox="0 0 500 150" preserveAspectRatio="none"
				style="height: 100%; width: 100%;">
				<path
					d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
					style="stroke: none; fill: #fff;"></path></svg>  
   </div>
</header> 
   <script src="https://kit.fontawesome.com/9a15d400d4.js" crossorigin="anonymous"></script>
</body>
</html>