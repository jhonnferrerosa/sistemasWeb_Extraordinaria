<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>monitorTutorModificaDatos.jsp</title>
	<link rel="stylesheet" type="text/css" href="vistas/estilosAdministrador.css">
</head>
<body>

	<header id="cabezera">monitor del administrador, Gestion, Editar. </header>
	
	<section>
		<c:set var="createEmpleadosEmpresasProyectosJsp" value="${createEmpleadosEmpresasProyectos}"/>

administradorId_user
<c:out value="${administradorId_user}"/>

		<!-- Tablas readEmpeado, createEmpleado y updateEmpleado:   son las tres tablas del EMPLEADO.  -->
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'readEmpleado'}">
			<a href="ServletAdministrador?action=consultarEmpleados&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0">  pulse aqui volver al monitor pagina monitor del admistrador Gestion. </a>
			<p> se haca la visualizacion de los datos de un usuario, solo es read. </p>
			<form>
				<label for="id_user"> Este es su id_user: 
					<input type="text" id="id_usertag" name="id_user"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.id_user}"/>"     />  <br>
				 </label>
			
				<label for="username"> Este es su username: 
					<input type="text" id="usernametag" name="username"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.username}"/>"     />  <br>
				 </label>
			
				<label for="dni"> Este es su dni: 
					<input type="text" id="dnitag" name="dni"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.dni}"/>"     />  <br>
				 </label>
			
				<label for="nombre"> Este es su nombre: 
					<input type="text" id="nombretag" name="nombre"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.nombre}"/>"     />  <br>
				 </label>
			</form>
		</c:if>
		
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'createEmpleado'}">
			<p> se haca la creacion de un nuevo usuario. </p>
			<form action="ServletAdministrador" method="post">
				<label for="id_user"> Introduzca el id_user(numero Entero): 
					<input type="text" id="id_usertag" name="id_user"   />  <br>
				 </label>
			
				<label for="username"> Introduzca  su username: 
					<input type="text" id="usernametag" name="username"    />  <br>
				 </label>
			
				<label for="contrasena"> Introduzca  su contraseña: 
					<input type="text" id="contrasenatag" name="contrasena"    />  <br>
				 </label>
			
				<label for="dni"> Introduzca su dni: 
					<input type="text" id="dnitag" name="dni"  />  <br>
				 </label>
			
				<label for="nombre"> Introduzca su nombre: 
					<input type="text" id="nombretag" name="nombre"    />  <br>
				 </label>
				 
				 <label for="apellidos"> Introduzca su apellido: 
				 	<input type="text" id="apellidotag" name="apellido"/> <br>
				 </label>
				 
				 <label for="fechaalta"> Introduzca la fecha de Alta: 
				 	<input type="date" id="fechaltatag" name="fechaalta">
				 </label> 
				 <br>
				 <!-- este valor es importante, para que los request.getPameter() del doPost() del servletAdministrador, tengan un valor por defecto -->
				 <!-- No puede quedar Nulo.  -->
				 <input type="hidden" name=action value="creaUsuario">
				 
				 <input type="hidden" name=id_empresa value=0>
				 <input type="hidden" name=nombreEmpresa value="nada">
				 
				 <input type="hidden" name=id_proyecto value=0>
				 <input type="hidden" name=nombreProyecto value="nada">
				 
				 <input type="hidden" name=administradorId_user value="<c:out value="${administradorId_user}"/>">
				 
				 <input type="submit" value="enviar">
			</form>
		</c:if>
		
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'updateEmpleado'}">
			<p> se haca la Modificacion  de un nuevo usuario. </p>
			<c:out value="${createEmpleadosEmpresasProyectosTabla.id_user}"/>
			
				<form action="ServletAdministrador" method="post">
				<label for="id_user"> Este es su id_user: 
					<input type="text" id="id_usertag" name="id_user" readonly="readonly"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.id_user}"/>" />  <br>
				 </label>
			
				<label for="username"> Introduzca  su username: 
					<input type="text" id="usernametag" name="username"   value="<c:out value="${createEmpleadosEmpresasProyectosTabla.username}"/>"   />  <br>
				 </label>
			
				<label for="contrasena"> Introduzca  su contraseña: 
					<input type="text" id="contrasenatag" name="contrasena"    />  <br>
				 </label>
			
				<label for="dni"> Introduzca su dni: 
					<input type="text" id="dnitag" name="dni"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.dni}"/>"  />  <br>
				 </label>
			
				<label for="nombre"> Introduzca su nombre: 
					<input type="text" id="nombretag" name="nombre"   value="<c:out value="${createEmpleadosEmpresasProyectosTabla.nombre}"/>"      />  <br>
				 </label>
				 
				 <label for="apellidos"> Introduzca su apellido: 
				 	<input type="text" id="apellidotag" name="apellido"/> <br>
				 </label>
				 
				 <label for="fechaalta"> Introduzca la fecha de Alta: 
				 	<input type="date" id="fechaltatag" name="fechaalta">
				 </label>
				 
				 <br>
				 <!-- este valor es importante, para que los request.getPameter() del doPost() del servletAdministrador, tengan un valor por defecto -->
				 <!-- No puede quedar Nulo.  -->
				 <input type="hidden" name=action value="actualizarUsuario">
				 
				 <input type="hidden" name=id_empresa value=0>
				 <input type="hidden" name=nombreEmpresa value="nada">
				 
				 <input type="hidden" name=id_proyecto value=0>
				 <input type="hidden" name=nombreProyecto value="nada">
				 
				 <input type="hidden" name=administradorId_user value="<c:out value="${administradorId_user}"/>">
				 
				 <input type="submit" value="enviar">
			</form>
		</c:if>
		
		
		
		
		
		<!-- Tablas readEmpeado, createEmpleado y updateEmpleado:   son las tres tablas del EMPRESA.  -->
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'readEmpresa'}">
			<a href="ServletAdministrador?action=consultarEmpresas&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0">  pulse aqui volver al monitor pagina monitor del admistrador Gestion. </a>
			<p> se haca la visualizacion de los datos de un usuario, solo es read. </p>
			<form>
				<label for="id_user"> Este es su id_user: 
					<input type="text" id="id_usertag" name="id_user"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.id_empresa}"/>"     />  <br>
				 </label>
			
				<label for="username"> Este es su username: 
					<input type="text" id="usernametag" name="username"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.nombre_empresa}"/>"     />  <br>
				 </label>
				 <br>
		</c:if>
		
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'createEmpresa'}">
			<p> Se hace la creación de una nueva empresa.  </p>
			<form action="ServletAdministrador" method="post">
				<label for="id_empresa"> Intrduzca el id_empresa: 
					<input type="text" id="id_empresatag" name="id_empresa"    />  <br>
				 </label>
			
				<label for="nombreEmpresa"> Introduzca en nombre de la empresa: 
					<input type="text" id="nombreEmpresatag" name="nombreEmpresa"    />  <br>
				 </label>
				 <!-- este valor es importante, para que los request.getPameter() del doPost() del servletAdministrador, tengan un valor por defecto -->
				 <!-- No puede quedar Nulo.  -->
				 <input type="hidden" name=action value="creaEmpresa">
				 
				 <input type="hidden" name=id_user value=0>
				 <input type="hidden" name=username value="nada">
				 <input type="hidden" name=contrasena value="nada">
				 <input type="hidden" name=dni value="nada">
				 <input type="hidden" name=nombre value="nada">
				 <input type="hidden" name=apellido value="nada">
				 <input type="hidden" name=fechaalta value="2000-01-01">
				 
				 <input type="hidden" name=id_proyecto value=0>
				 <input type="hidden" name=nombreProyecto value="nada">
				 
				 <input type="submit" value="enviar">
		</c:if>
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'updateEmpresa'}">
			<p> Se hace la actualización de una empresa.  </p>
			<form action="ServletAdministrador" method="post">
				<label for="id_empresa" > Intrduzca el id_empresa: 
					<input type="text" id="id_empresatag" name="id_empresa" readonly="readonly"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.id_empresa}"/>"    />  <br>
				 </label>
			
				<label for="nombreEmpresa"> Introduzca en nombre de la empresa: 
					<input type="text" id="nombreEmpresatag" name="nombreEmpresa"    />  <br>
				 </label>
				 <!-- este valor es importante, para que los request.getPameter() del doPost() del servletAdministrador, tengan un valor por defecto -->
				 <!-- No puede quedar Nulo.  -->
				 <input type="hidden" name=action value="actualizarEmpresa">
				 
				 <input type="hidden" name=id_user value=0>
				 <input type="hidden" name=username value="nada">
				 <input type="hidden" name=contrasena value="nada">
				 <input type="hidden" name=dni value="nada">
				 <input type="hidden" name=nombre value="nada">
				 <input type="hidden" name=apellido value="nada">
				 <input type="hidden" name=fechaalta value="2000-01-01">
				 
				 <input type="hidden" name=id_proyecto value=0>
				 <input type="hidden" name=nombreProyecto value="nada">
				 
				 <input type="submit" value="enviar">
		</c:if>
		
		
		
		
		
		
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'createProyecto'}">
			<p> se haca la creacion de un nuevo proyecto. </p>
				<form action="ServletAdministrador" method="post">
				<label for="id_proyecto"> Intrduzca el id_proyecto: 
					<input type="text" id="id_proyectotag" name="id_proyecto"    />  <br>
				 </label>
			
				<label for="nombreProyecto"> Introduzca en nombre del proyecto: 
					<input type="text" id="nombreProyectoatag" name="nombreProyecto"    />  <br>
				 </label>
				 
				 <label for="id_empresa"> Introduzca el id_empresa(ese id_empresa tiene que existir): 
					<input type="text" id="id_empresatag" name="id_empresa"    />  <br>
				 </label>
				 <!-- este valor es importante, para que los request.getPameter() del doPost() del servletAdministrador, tengan un valor por defecto -->
				 <!-- No puede quedar Nulo.  -->
				 <input type="hidden" name=action value="creaProyecto">
				 
				 
				 <input type="hidden" name=id_user value=0>
				 <input type="hidden" name=username value="nada">
				 <input type="hidden" name=contrasena value="nada">
				 <input type="hidden" name=dni value="nada">
				 <input type="hidden" name=nombre value="nada">
				 <input type="hidden" name=apellido value="nada">
				 <input type="hidden" name=fechaalta value="2000-01-01">
				 
				 <input type="hidden" name=nombreEmpresa value="nada">
				 
				 <input type="submit" value="enviar">
		</c:if>
		
		<c:if test="${createEmpleadosEmpresasProyectosJsp eq 'updateProyecto'}">
			<p> Se hace la actualización de un proyecto.  </p>
			<form action="ServletAdministrador" method="post">
				<label for="id_proyecto" > Aqui está el id_proyecto: 
					<input type="text" id="id_proyectotag" name="id_proyecto" readonly="readonly"  value="<c:out value="${createEmpleadosEmpresasProyectosTabla.id_proyecto}"/>"    />  <br>
				 </label>
				 
				 <label for="nombreProyecto"> Introduzca en nombre del proyecto: 
					<input type="text" id="nombreProyectoatag" name="nombreProyecto"    />  <br>
				 </label>
				 
				 <label for="id_empresa"> Introduzca el id_empresa(ese id_empresa tiene que existir): 
					<input type="text" id="id_empresatag" name="id_empresa"    />  <br>
				 </label>
				 
				 <!-- este valor es importante, para que los request.getPameter() del doPost() del servletAdministrador, tengan un valor por defecto -->
				 <!-- No puede quedar Nulo.  -->
				 <input type="hidden" name=action value="actualizarEmpresa">
				 
				 <input type="hidden" name=id_user value=0>
				 <input type="hidden" name=username value="nada">
				 <input type="hidden" name=contrasena value="nada">
				 <input type="hidden" name=dni value="nada">
				 <input type="hidden" name=nombre value="nada">
				 <input type="hidden" name=apellido value="nada">
				 <input type="hidden" name=fechaalta value="2000-01-01">
				 
				 <input type="hidden" name=id_proyecto value=0>
				 <input type="hidden" name=nombreProyecto value="nada">
				 
				 <input type="submit" value="enviar">
		</c:if>
	
	</section>
</body>
</html>