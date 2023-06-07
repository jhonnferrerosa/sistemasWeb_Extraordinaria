<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>monitorTutorModifica.jsp</title>
	<link rel="stylesheet" type="text/css" href="vistas/estilosAdministrador.css">
</head>
<body>

	<header id="cabezera">monitor del administrador, Gestion. </header>
	
	<section> 
		<!--  <c:out value="${readEmpleados}"/>   --> 
		<c:set var="readEmpleadosEmpresasProyectosJsp" value="${readEmpleadosEmpresasProyectos}"/>
		
		<c:if test="${readEmpleadosEmpresasProyectosJsp eq 'readEmpleados'}">
			<p> se hace readEmpleados    +++++++</p>
			
			<a href="ServletAdministrador?action=creoEmpleado&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0"> Pulse aqui si desea crear un usuario </a>
			<br> </br>
			<br> </br>
			<table style="width: 100%;">
				<tfoot> </tfoot>
				<thead>
					<tr>
						<th> El id_user:   </th>
						<th> El Username: </th>
						<th> El DNI:  </th>		
						<th> Opciones: </th>		
					</tr> 
				 </thead>
				<tbody> 
					<c:forEach var="lista" items="${listaEmpleados}">
						<tr>
							<td> <c:out value="${lista.id_user}"> </c:out> </td>
							<td> <c:out value="${lista.username}"> </c:out>  </td>
							<td>  <c:out value="${lista.dni}"> </c:out>  </td>
							<td> 
								<a href="ServletAdministrador?action=leeEmpleado&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=<c:out value="${lista.id_user}"/>&id_empresa=0&id_proyecto=0"> ReadEmpleado.</a>
								<br> 
								<br>
								<a href="ServletAdministrador?action=modificaEmpleado&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=<c:out value="${lista.id_user}"/>&id_empresa=0&id_proyecto=0">Update. </a> 
								<br>
								<br>
								<a href="ServletAdministrador?action=borraEmpleado&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=<c:out value="${lista.id_user}"/>&id_empresa=0&id_proyecto=0"> Delete.</a>
								<br>			
								<br>
								<br>					
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<c:if test="${readEmpleadosEmpresasProyectosJsp eq 'readEmpresas'}">
			<p> se hace readEmprsas </p>
			
			<a href="ServletAdministrador?action=creoEmpresa&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0"> Pulse aqui si desea crear una empresa </a>
			<br> </br>
			<br> </br>
			<table style="width: 100%;">
				<tfoot> </tfoot>
				<thead>
					<tr>
						<th> El id_empresa: </th>
						<th> El nombre_empresa: </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lista" items="${listaEmpresas}">
						<tr>
							<td> <c:out value="${lista.id_empresa}"> </c:out> </td>
							<td> <c:out value="${lista.nombre_empresa}"> </c:out> </td>
							<td>
								<a href="ServletAdministrador?action=leeEmpresa&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=<c:out value="${lista.id_empresa}"/>&id_proyecto=0"> ReadEmpresa </a>								
								<br>
								<br>
								<a href="ServletAdministrador?action=modificaEmpresa&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=<c:out value="${lista.id_empresa}"/>&id_proyecto=0"> UpdateEmpresa </a>	
								<br>
								<br>
								<a href="ServletAdministrador?action=borraEmpresa&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=<c:out value="${lista.id_empresa}"/>&id_proyecto=0"> DeleteEmpresa </a>	
								<br>
								<br>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		
		
		<c:if test="${readEmpleadosEmpresasProyectosJsp eq 'readProyectos'}">
			<p> se hace readProyectos </p>
			<a href="ServletAdministrador?action=creoProyecto&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0"> Pulse aqui si desea crear un proyecto.  </a>
			
			<br> </br>
			<br> </br>
			<table style="width: 100%;">
				<tfoot> </tfoot>
				<thead>
					<tr>
						<th> El id_proyecto: </th>
						<th> El nombre proyecto: </th>
						<th> El id_empresa:  </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lista" items="${listaProyectos}">
						<tr>
							<td> <c:out value="${lista.id_proyecto}"> </c:out> </td>
							<td> <c:out value="${lista.nombre}"> </c:out> </td>
							<td> <c:out value="${lista.id_empresa}"> </c:out> </td>
							<td>
								<a href="ServletAdministrador?action=modificaProyecto&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=<c:out value="${lista.id_proyecto}"/>"> UpdateProyecto </a>	
								<br>
								<br>
								<a href="ServletAdministrador?action=borraProyecto&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=<c:out value="${lista.id_proyecto}"/>"> DeleteProyecto </a>	
								<br>
								<br>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
		</c:if>
		
		
		
		
		
		
		<a href="ServletAdministrador?action=volverMonitorAdmin&id_userDatosPersonales=<c:out value="${administradorId_user}"/>&id_user=0&id_empresa=0&id_proyecto=0" > pulse aqui, para volver al monitor de administrador </a>
		<p> BORRAR. ESTO ES SOLO PARA VER QUE ADMIN ESTA EN EL SISTEMA. es el id_user </p>
		<c:out value="${administradorId_user}"/>
		
	</section>
	
	<footer></footer>

</body>
</html>