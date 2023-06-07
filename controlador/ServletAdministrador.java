package controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.AdminDao;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Proyecto;

/**
 * Servlet implementation class ServletAdministrador
 */
public class ServletAdministrador extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private String action = "";
	private int id_user = 0;
	private int id_empresa = 0;
	private int id_proyecto = 0;
	private int id_userDatosPersonales = 0;
	
	
	//estas variables las usa el post.
	private String username = "";
	private String contrasena = "";
	private String dni = "";
	private String nombre = "";
	private String apellido = "";
	private String fecha_alta = "";
	
	private String nombreEmpresa = "";   
	private String nombreProyecto = "";
	private AdminDao accesoAdminDao = new AdminDao ();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println ("servletAdministrador, doGet -- se ejecuta");
		action = request.getParameter("action");
		id_userDatosPersonales = Integer.valueOf(request.getParameter("id_userDatosPersonales"));  
		id_user = Integer.valueOf(request.getParameter("id_user"));  
		id_empresa = Integer.valueOf(request.getParameter("id_empresa"));
		id_proyecto = Integer.valueOf(request.getParameter("id_proyecto"));  
		
		System.out.println ("servletAdministrador, doGet --"+action);
		System.out.println ("servletAdministrador, doGet --"+id_user);
		//AdminDao accesoAdminDao = new AdminDao ();
		
		try {
			RequestDispatcher requestDispatcher = null;
			switch (action){
			case "consultarEmpleados":
				System.out.println ("servletAdministrador, doGet -- entro a consultar empleados");
				request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpleados");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaEmpleados", accesoAdminDao.getAllEmpleados());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "creoEmpleado":
				System.out.println (" servletAdministrador, doGet -- entro a crear empleado.");
				request.setAttribute("createEmpleadosEmpresasProyectos","createEmpleado");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "leeEmpleado":
				System.out.println ("servletAdministrador, doGet -- leo empleado");
				request.setAttribute("createEmpleadosEmpresasProyectos","readEmpleado");
				request.setAttribute("createEmpleadosEmpresasProyectosTabla", accesoAdminDao.getEmpleado(id_user));
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "modificaEmpleado":
				System.out.println ("servletAdministrador, doGet -- modifico empleado");
				request.setAttribute("createEmpleadosEmpresasProyectos","updateEmpleado");
				request.setAttribute("createEmpleadosEmpresasProyectosTabla", accesoAdminDao.getEmpleado(id_user));
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "borraEmpleado":
				System.out.println ("servletAdministrador, doGet -- borro empleado");
				//en este caso, como simplemente borro, lo que hago es volver a la pantalla en la que salen todos los empleados. 
				accesoAdminDao.deleteEmpleado(id_user);
				request.setAttribute("readEmpleadosEmpresasProyectos","readEmpleados");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaEmpleados", accesoAdminDao.getAllEmpleados());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "consultarEmpresas":
				System.out.println ("servletAdministrador, doGet -- entro a consultar empresas");
				request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpresas");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaEmpresas", accesoAdminDao.getAllEmpresa());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "creoEmpresa":
				System.out.println (" servletAdministrador, doGet -- entro a crear empresa");
				request.setAttribute("createEmpleadosEmpresasProyectos","createEmpresa");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "leeEmpresa":
				System.out.println (" servletAdministrador, doGet -- lee empresa");
				request.setAttribute("createEmpleadosEmpresasProyectos","readEmpresa");
				request.setAttribute("createEmpleadosEmpresasProyectosTabla", accesoAdminDao.getEmpresa(id_empresa));
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "modificaEmpresa":
				System.out.println (" servletAdministrador, doGet -- modifica empresa");
				request.setAttribute("createEmpleadosEmpresasProyectos","updateEmpresa");
				request.setAttribute("createEmpleadosEmpresasProyectosTabla", accesoAdminDao.getEmpresa(id_empresa));
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "borraEmpresa":
				System.out.println (" servletAdministrador, doGet -- borraEmpresa ");
				accesoAdminDao.deleteEmpresa(id_empresa);
				request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpresas");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaEmpresas", accesoAdminDao.getAllEmpresa());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "consultarProyectos":
				System.out.println ("servletAdministrador, doGet -- entro a consultar proyectos");
				request.setAttribute("readEmpleadosEmpresasProyectos","readProyectos");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaProyectos", accesoAdminDao.getAllProyectos());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "creoProyecto": 
				System.out.println ("servletAdministrador, doGet -- entro a crear un pryecto");
				request.setAttribute("createEmpleadosEmpresasProyectos","createProyecto");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "modificaProyecto":
				System.out.println ("servletAdministrador, doGet --entro a modificar proyecto");
				request.setAttribute("createEmpleadosEmpresasProyectos","updateProyecto");
				request.setAttribute ("createEmpleadosEmpresasProyectosTabla", accesoAdminDao.getProyecto(id_proyecto));
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModificaDatos.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "borraProyecto":
				System.out.println (" servletAdministrador, doGet -- borraProyecto ");
				accesoAdminDao.deleteProyecto(id_proyecto);
				request.setAttribute("readEmpleadosEmpresasProyectos","readProyectos");
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaProyectos", accesoAdminDao.getAllProyectos());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "volverMonitorAdmin":
				System.out.println ("servletAdministrador, dooGet -- vuelvo al monitorAdmin");
				request.setAttribute("adminstradorDatosPersonales", accesoAdminDao.getAdministrador(id_userDatosPersonales));
				request.setAttribute("administradorId_user",id_userDatosPersonales);
				requestDispatcher = request.getRequestDispatcher("/monitorAdmin.jsp");
				requestDispatcher.forward(request, response);
				break;
				
			default:
				System.out.println ("servletAdministrador, doGet --  error");
				requestDispatcher = request.getRequestDispatcher("/error.html");
				requestDispatcher.forward(request, response);	
			}
		}catch (Exception ex) {
			System.out.println ("servletAdministrador, doGet -- "+ex.getMessage());
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println ("servletAdministrador, doPost -- se ejecuta");
		action = request.getParameter("action");
		System.out.println ("servletAdministrador, doPost -- action: "+action);
		
		id_user = Integer.valueOf(request.getParameter("id_user"));
		System.out.println ("servletAdministrador, doPost -- id_user: "+id_user);
		username = request.getParameter("username");
		System.out.println ("servletAdministrador, doPost -- username: "+username);
		contrasena = request.getParameter("contrasena");
		System.out.println ("servletAdministrador, doPost -- contrasena: "+contrasena);
		dni = request.getParameter("dni");
		System.out.println ("servletAdministrador, doPost -- dni: "+dni);
		nombre = request.getParameter("nombre");
		System.out.println ("servletAdministrador, doPost -- nombre: "+nombre);
		apellido = request.getParameter("apellido");
		System.out.println ("servletAdministrador, doPost -- apelldo: "+apellido);
		fecha_alta = request.getParameter("fechaalta");
		System.out.println ("servletAdministrador, doPost -- fecha_alta: "+fecha_alta);
		
		
		id_empresa = Integer.valueOf(request.getParameter("id_empresa"));
		System.out.println ("servletAdministrador, doPost -- id_empresa: "+id_empresa);
		nombreEmpresa = request.getParameter("nombreEmpresa");
		System.out.println ("servletAdministrador, doPost -- nombreEmpresa: "+nombreEmpresa);
		
		id_proyecto = Integer.valueOf(request.getParameter("id_proyecto"));
		System.out.println ("servletAdministrador, doPost -- id_proyecto: "+id_proyecto);
		nombreProyecto = request.getParameter("nombreProyecto");
		System.out.println ("servletAdministrador, doPost -- nombreProyecto: "+nombreProyecto);
		
		try {
			RequestDispatcher requestDispatcher = null;
			if (action.equals("creaUsuario")) {
				System.out.println ("servletAdministrador, doPost -- creo empleado");
				Empleado empleado = new Empleado ();
				empleado.setId_user(id_user);
				empleado.setUsername(username);
				empleado.setPasswrod(contrasena);
				empleado.setDni(dni);
				empleado.setNombre(nombre);
				empleado.setApellidos(apellido);
				empleado.setFeche_alta(java.sql.Date.valueOf(fecha_alta));
				accesoAdminDao.createEmpleado(empleado);
				request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpleados");
				// cuidado porque este id_user, no es el que ha lanazado la pagina de crear Empleado, si no que es el que acabo de crear, me info que se muestra enn el 
				//monitosAdminstrador, no es con la que se lanzo. 
				request.setAttribute("administradorId_user", id_userDatosPersonales);
				request.setAttribute("listaEmpleados", accesoAdminDao.getAllEmpleados());
				requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
				requestDispatcher.forward(request, response);
			}else {
				if (action.equals("actualizarUsuario")) {
					System.out.println ("servletAdministrador, doPost -- actualizo empleado");
					Empleado empleado = new Empleado ();
					empleado.setId_user(id_user);
					empleado.setUsername(username);
					empleado.setPasswrod(contrasena);
					empleado.setDni(dni);
					empleado.setNombre(nombre);
					empleado.setApellidos(apellido);
					empleado.setFeche_alta(java.sql.Date.valueOf(fecha_alta));
					accesoAdminDao.updateEmpleado(empleado);
					request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpleados");
					request.setAttribute("administradorId_user", id_userDatosPersonales);  
					request.setAttribute("listaEmpleados", accesoAdminDao.getAllEmpleados());
					requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
					requestDispatcher.forward(request, response);
				}else {
					if (action.equals("creaEmpresa")) {
						System.out.println ("servletAdministrador, doPost -- creoEmpresa");
						Empresa empresa = new Empresa ();
						empresa.setId_empresa(id_empresa);
						empresa.setNombre_empresa(nombreEmpresa);
						accesoAdminDao.createEmpresa(empresa);
						request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpresas");
						request.setAttribute("administradorId_user", id_userDatosPersonales);  
						request.setAttribute("listaEmpresas", accesoAdminDao.getAllEmpresa());
						requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
						requestDispatcher.forward(request, response);
					}else {
						if (action.equals("actualizarEmpresa")) {
							System.out.println ("servletAdministrador, doPost -- actualizarEmpresa");
							Empresa empresa = new Empresa ();
							empresa.setId_empresa(id_empresa);
							empresa.setNombre_empresa(nombreEmpresa);
							accesoAdminDao.updateEmpresa(empresa);
							request.setAttribute("readEmpleadosEmpresasProyectos", "readEmpresas");
							request.setAttribute("administradorId_user", id_userDatosPersonales);  
							request.setAttribute("listaEmpresas", accesoAdminDao.getAllEmpresa());
							requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
							requestDispatcher.forward(request, response);
						}else {
							if (action.equals("creaProyecto")) {
								System.out.println ("servletAdministrador, doPost --creaProyecto");
								Proyecto proyecto = new Proyecto ();
								proyecto.setId_proyecto(id_proyecto);
								proyecto.setNombre(nombreProyecto);
								proyecto.setId_empresa(id_empresa);
								accesoAdminDao.createProyecto(proyecto);
								request.setAttribute("readEmpleadosEmpresasProyectos", "readProyectos");
								request.setAttribute("administradorId_user", id_userDatosPersonales); 
								request.setAttribute("listaProyectos", accesoAdminDao.getAllProyectos());
								requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
								requestDispatcher.forward(request, response);
								
							}else {
								if (action.equals("updateProyecto")) {
									System.out.println ("servletAdministrador, doPost -- actualizo proyecto");
									Proyecto proyecto = new Proyecto ();
									proyecto.setId_proyecto(id_proyecto);
									proyecto.setNombre(nombreProyecto);
									proyecto.setId_empresa(id_empresa);
									accesoAdminDao.updateProyecto(proyecto);
									request.setAttribute("readEmpleadosEmpresasProyectos", "readProyectos");
									request.setAttribute("administradorId_user", id_userDatosPersonales);  
									request.setAttribute("listaProyectos", accesoAdminDao.getAllProyectos());
									requestDispatcher = request.getRequestDispatcher("/monitorAdminModifica.jsp");
									requestDispatcher.forward(request, response);
								}else {
									System.out.println ("servletAdministrador, doGet --  error");
									requestDispatcher = request.getRequestDispatcher("/error.html");
									requestDispatcher.forward(request, response);
								}
							}
						}
					}
				}
			}
		}catch (Exception ex) {
			System.out.println ("servletAdministrador, doPost -- "+ex.getMessage());
		}
	}

}
