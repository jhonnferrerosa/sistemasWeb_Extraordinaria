package controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.EmpleadoDao;
import modelo.Marcaje;

import java.util.Date;

/**
 * Servlet implementation class ServletEmpleado
 */
public class ServletEmpleado extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	//private Date  marcaje = new Date ();
	private int id_usuario = 0;
	private String marcajeFecha = "";
	private String marcajeOpcion = "";
	private RequestDispatcher requestDispatcher = null;
	private EmpleadoDao accesoEmpleadoDao = new EmpleadoDao ();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println ("serveltEmpeado, doGet -- se ejecuta");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println ("serveltEmpeado, doPost -- se ejecuta");
		id_usuario = Integer.valueOf(request.getParameter("miId_user"));
		marcajeFecha = request.getParameter("miMarcajeFecha");
		marcajeOpcion = request.getParameter("miMarcajeOpcion");
		System.out.println ("serveltEmpeado, doPost -- marcaje:  "+marcajeFecha);
		System.out.println ("serveltEmpeado, doPost --marcajeOpcion:  "+marcajeOpcion);
		
		try {
			Marcaje marcaje = new Marcaje ();
			marcaje.setId_marcaje(0);
			marcaje.setFecha(java.sql.Date.valueOf(marcajeFecha));
			marcaje.setTipo_marcaje(marcajeOpcion);
			marcaje.setId_usuario(id_usuario);
			accesoEmpleadoDao.insertaMarcaje(marcaje);
			
			request.setAttribute("empleadoDatosPersonales", accesoEmpleadoDao.getEmpleado(id_usuario));
			requestDispatcher = request.getRequestDispatcher("/monitorEmpleado.jsp");
			requestDispatcher.forward(request, response);
		}catch (Exception ex) {
			System.out.println ("serveltEmpeado, doPost --"+ex.getMessage());
		}
	}

}
