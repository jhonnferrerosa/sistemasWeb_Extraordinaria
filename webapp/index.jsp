<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="modelo.AdminDao"%>
<%@page import="java.sql.ResultSet"%>

<%!
//este es el ingenierosalpeso. 
//AdminDao adminDao = new AdminDao ();
//String frase;
%>
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <link rel="stylesheet" type="text/css" href="vistas/estilosIndex.css">
		 <title> ingenierosALPeso.jsp</title>
	</head>
	<body>
<%
//Esto es una consulta rapida, prara comporbar que mi aplicacion recien ccreada, sea capaaz de conectarse a la bbdd. 
//out.println ("saludo desde e tiqueta JSP ");
//ResultSet resultSetAdminDao = null;
//try{
//	resultSetAdminDao = adminDao.identificarAdmin("usuario301", "usuario301");
//	frase = resultSetAdminDao.getString(2);
//	System.out.println (frase);
//	System.out.println ("index.jsp -- LA CONSULTA SE HIZO0 ");
//}catch (Exception ex){
//	System.out.println ("index.jsp -- error al ejecutar la consulta");
//}
%>
		<header id="cabezera">
			<h1> ingenieros al Peso</h1>
		</header>

		<nav id="barranavegacion">
		</nav>
		
		<aside id="barralateral">
			<h7> aqui se muestra informacion de empresas aleatorias.</h7> 
			<br>
			<h7>Aunque No tengan que ver con las de la base de datos.  </h7>	
		</aside>
		
		<section id="contenido">
			<h2> Debe loguearse como empleado o como administrador</h2>
			<form action="ServletLoggin" methond="get">
				<label for="usuario">Intruduzca su usuario:  
					<INPUT type="text" id="usuariotag" name="usuario">
				</label>
				<br>
	
				<label for="contrasena"> introduzca la contrasena:  
					<input type="text" id="contrasenatag" name="contrasena"> 
				</label>
				<br>
				<br>
				<br>
				
				<p> elija el tipo de usuario que esta logueando:  </p>
				<laber for="tipoUsuario"> Administrador. 
					<input type="radio" name=action checked value="A" >
				</laber>
				<br>
				<label for="tipoUsuario"> Empleado. 
					<input type="radio" name=action value="u">
				</label>
				<br>
				<!-- COMENTARIO. esta linea es importante para que cuando se rellene el formulario, que el valor de action que es un String -->
				<!--  que esta en el servletLoggin, no se quede con un valor de null, y cuando se haga la comprobacion del if -->
				<!--  no se prozca una execepcion y se quede pillado el programa. Por eso: type="hidden"  -->
				<!-- <input type="hidden" name=action value="nada">   -->
				
				<input type="submit" value="enviar">
			</form>
		
		</section>
		
		<footer id="pie">
			<p> ingenieros al peso. Empresa localizada en Arganda del rey </p>
			<p> telefon: 699999999 </p>
		</footer>
	</body>
</html>
