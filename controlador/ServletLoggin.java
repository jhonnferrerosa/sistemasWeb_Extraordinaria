package controlador;

import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import modelo.AdminDao;
import modelo.Administrador;
import modelo.EmpleadoDao;
/**
 * Servlet implementation class ServletLoggin
 */
public class ServletLoggin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String usuario = ""; 
	private String contrasena = "";
	private String action = "";
	private AdminDao accesoAdminDao = new AdminDao ();
	private EmpleadoDao accesoEmpleadoDao = new EmpleadoDao();
	private int id_userDatosPersonales = 0;
	
	//este ResultSet lo declaro aqui, para que sea la comprobacion de que la consulta de que si
	//ese usuario esta en la BBDD, ese ResultSet me de distinto de null. y asi se si ese usuario
	//esta o no esta en el sistema. 
	ResultSet resultSetServletLoggin = null;  

    /**
     * Default constructor. 
     */
    public ServletLoggin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println ("  ServletLogin.java, doGet-- se ejecuta ");
		usuario = request.getParameter("usuario");
		contrasena = request.getParameter("contrasena");
		action = request.getParameter("action");
		// lo pongo en mayusculas, porque al pasarlo desde el jsp al servlet, no me detecta la U mayuscula, no se porque. 
		action = action.toUpperCase();
		
		try {
			RequestDispatcher requestDispatcher = null;
			System.out.println (" ServletLogin.java, doGet-- action:   "+action);
			System.out.println ("ServletLoggin, deget-- se porcede a iniciar usuario");
			if (action.equals("U")) {
				resultSetServletLoggin = accesoEmpleadoDao.identificarEmpleado(usuario, contrasena, action);
				//esto es el caso en que el returne algo, al llamar al metodo identificar del accesoEmpleadoDao. 
				if (resultSetServletLoggin != null) {
					request.setAttribute("empleadoDatosPersonales", accesoEmpleadoDao.getEmpleado(usuario, contrasena, action));
					requestDispatcher = request.getRequestDispatcher("/monitorEmpleado.jsp");
					requestDispatcher.forward(request, response);						
				}else {
					System.out.println (" servletLogginn, doget() -- se ha ido al error.html");
					requestDispatcher = request.getRequestDispatcher("/error.html");
					requestDispatcher.forward(request, response);
				}
			//este es el casso en el que el string action, tiene el valor "A".
			}else { 
				resultSetServletLoggin = accesoAdminDao.identificarAdmin(usuario, contrasena, action);
				if (resultSetServletLoggin != null) {
					request.setAttribute("adminstradorDatosPersonales", accesoAdminDao.getAdministrador(usuario, contrasena,  action));
					id_userDatosPersonales = accesoEmpleadoDao.getEmpleado(usuario, contrasena, action).getId_user();
					request.setAttribute("administradorId_user", id_userDatosPersonales);
					requestDispatcher = request.getRequestDispatcher("/monitorAdmin.jsp");
					requestDispatcher.forward(request, response);
				}else {
					System.out.println (" servletLoggin, doget() -- se ha ido al error.html");
					requestDispatcher = request.getRequestDispatcher("/error.html");
					requestDispatcher.forward(request, response);
				}
			}
		}catch (Exception ex) {
			System.out.println ("servletRegistro, doget() -- "+ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
