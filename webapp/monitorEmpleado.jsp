<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="vistas/estilosEmpleado.css">
	<title>monitorEmpleado.jsp</title>
</head>
<body>
	<header id="cabezera">Monitor del Empleado. </header>
	<nav id="barranavegacion">
		<p> pulse aqui si desea cerrar sesión. </p>

	</nav>
	
	<aside id="barralateral">
			<h7> aqui se muestra informacion de empresas aleatorias.</h7> 
			<br>
			<h7>Aunque No tengan que ver con las de la base de datos.  </h7>	
	</aside>
	
	<section id="contenido"> 
		<h3>  Buenas aquí se muestra informacion personal del empleado.  </h3>
		<h7> Este es el id_user:  </h7>
		<c:out value="${empleadoDatosPersonales.id_user}" />
		<br> 
		
		<h7> Este es el usuarion en el sistema: </h7>
		<c:out value="${empleadoDatosPersonales.username}" />
		<br>
		
		<h7> Este es su DNI:   </h7>
		<c:out value="${empleadoDatosPersonales.dni}" />
		<br>
		
		<h7> Este es su nombre:  </h7>
		<c:out value="${empleadoDatosPersonales.nombre}" />
		<br>
		<br>
		
		
		<h3> Las gestiones de marcajes las administra aquí.  </h3>
				<form action="ServletEmpleado" method="post">
				<label for="miMarcajeFecha">Intruduzca la fecha de marcajee:  
					<INPUT type="date" id="miMarcajetag" name="miMarcajeFecha">
				</label>
				
				<p> Elija el tipo de marcaje que va a realizar:  </p>
				<laber for="miMarcajeOpcion"> Marcaje de Entrada: 
					<input type="radio" name=miMarcajeOpcion checked value="E" >
				</laber>
				<br>
				<label for="miMarcajeOpcion"> Marcaje de Salida. 
					<input type="radio" name=miMarcajeOpcion value="S">
				</label>
				<br>
				<input type="hidden" name=miId_user value="<c:out value="${empleadoDatosPersonales.id_user}" />"> 
				
				<input type="submit" value="enviar">
			</form>	
	</section>
	
	<footer id="pie">
		<p> ingenieros al peso. Empresa localizada en Arganda del rey </p>
		<p> telefon: 699999999 </p>
	</footer>
</body>
</html>