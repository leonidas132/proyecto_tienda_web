<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="widht=device-width, initial-scale= 1.0">
    <title>Login_G10</title>
    <link rel="stylesheet" href="css/Style.css" type="text/css">
    
    <style>
		body{		
			height: 10%;
  			margin: 18%;
  			background-image: url("./css/imagen/f.jpg");
  			background-repeat: no-repeat;
  			background-size: cover;
  			background-attachment: fixed;
    		background-position: center ;
  		    position: relative;
  		
    	}
        i{
  		  font-size: 50px;
  		}
	</style>
    
</head>
<body>

<form action="Ingresar" method="post" >
    <section>
        <div class="form-container">
            	<h1><i class="fas fa-user"></i></h1>
            	
           		 <div class="control">
            		<p>Usuario</p>
                    <input type="text" name="userId" placeholder="Ingrese nombre de usuario" required >
            		<p>Contraseña</p>
            		<input type="password" name="contra" placeholder="*******" required>
            		<input type="submit" class="btn" value="Aceptar">
           			<a href="index.jsp">Pagina Principal</a>
            	</div>
        	     </div>
    </section>
    </form>
       <script src="https://kit.fontawesome.com/9a15d400d4.js" crossorigin="anonymous"></script>
</body>
</html>