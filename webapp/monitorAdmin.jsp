<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
<head>
	<meta charset="ISO-8859-1">	
	<link rel="stylesheet" type="text/css" href="vistas/estilosAdministrador.css">
	<title>monitorAdmin.jsp </title>
</head>

<body>
	<header id="cabezera">
		<h1> Monitor del Administrador</h1>
	</header>

	<nav id="barranavegacion">
		<a href="ServletAdministrador?action=consultarEmpleados&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0">  pulse aqui, si desea que se muestre en esta pagina a la totalidad de los empleados</a>
		<br> 
		<br>
		<a href="ServletAdministrador?action=consultarEmpresas&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0">  pulse aqui, si desea que se muestre en esta pagina a la totalidad de las empresas</a>
		<br>
		<br>
		<a href="ServletAdministrador?action=consultarProyectos&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0">  pulse aqui, si desea que se muestre en esta pagina a la totalidad de los proyectos. </a>
		<br>
		<br>

	</nav>
	
	<aside id="barralateral">
			<h7> aqui se muestra informacion de empresas aleatorias.</h7> 
			<br>
			<h7>Aunque No tengan que ver con las de la base de datos.  </h7>	
	</aside>
	
	<section id="contenido">
		<h3> Buenas administrador, aqui se muestra su informacion personal. </h4>
		<h7> Este es el id_user:          </h7>
		<c:out value="${adminstradorDatosPersonales.id_user}"/>
		<br>
		
		<h7> Este es su usuario en el sistema:     </h7>
		<c:out value="${adminstradorDatosPersonales.username}"/>
		<br>
		
		<h7> Este es su DNI:     </h7>
		<c:out value="${adminstradorDatosPersonales.dni}"/>
		<br>
		
		<h7> Este es su nombre:   </h7>
		<c:out value="${adminstradorDatosPersonales.nombre}"/>
		
		<br>
		<br>
		
		<h4> Aqui se muestran todos los empleados de la empresa que esta asociado como Administador. Es la pagina por defecto. </h4>
	</section>

	<footer id="pie">
		<p> ingenieros al peso. Empresa localizada en Arganda del rey </p>
		<p> telefon: 699999999 </p>
	</footer>

</body>
</html>