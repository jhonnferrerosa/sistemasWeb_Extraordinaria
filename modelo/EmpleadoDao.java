package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadoDao {
	private ResultSet resultSetEmpleadoDao = null;
	private Connection connection = null;
	private Statement miDeclaracion = null;
	private PreparedStatement preparedStatement = null;
	
	public EmpleadoDao () {
		System.out.println ("EmpleadoDao.java, EmpleadoDao() -- se acaba de construir el empleado.");
	}
	
	public ResultSet identificarEmpleado (String usuario, String contrasena, String tipo_usuario) {
		resultSetEmpleadoDao = null;
		connection = null; 
		miDeclaracion = null; 
		DbUtil miConexion = new DbUtil (); 
		String sql =  "select * from usuarios where username='" + usuario + "' and password ='" + contrasena +"' and tipo_usuario='" +tipo_usuario +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetEmpleadoDao = miDeclaracion.executeQuery(sql);
			if (resultSetEmpleadoDao.next() == true) {
				System.out.println ("EmpleadoDao.Java, identificaEmpleado -- consulta corrrecta");		
			}else {
				System.out.println ("EmpleadoDao.Java, identificaEmpleado -- Fallo en consulta");
			}
		}catch (Exception ex) {
			System.out.println ("EmpleadoDao.Java, identificaEmpleado -- error, No se ha identificado");
		}
		return resultSetEmpleadoDao;
	}
	
	public Empleado getEmpleado (String usuario, String contrasena, String tipo_usuario) {
		Empleado empleado = new Empleado ();
		DbUtil miConexion = new DbUtil ();
		String sql =  "select * from usuarios where username='" + usuario + "' and password ='" + contrasena +"'and tipo_usuario='" +tipo_usuario  +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetEmpleadoDao = miDeclaracion.executeQuery(sql);
			if (resultSetEmpleadoDao.next() == true) {
				empleado.setId_user(resultSetEmpleadoDao.getInt("id_user"));
				empleado.setUsername(resultSetEmpleadoDao.getString("username"));
				empleado.setDni(resultSetEmpleadoDao.getString("dni"));
				empleado.setNombre(resultSetEmpleadoDao.getString("nombre"));
				System.out.println ("EmpleadoDao.Java,getEmpleado -- se ha consegudo el empleado");
			}else {
				System.out.println ("EmpleadoDao.Java,getEmpleado -- error consulta incorrecta");
			}
		}catch (Exception ex) {
			System.out.println ("EmpleadoDao.Java, getEmpleado --"+ex.getMessage());
		}
		return empleado;
	}
	public Empleado getEmpleado(int id_user) {
		System.out.println ("AdminDao.java, getEmpleado --se ejecuta");
		Empleado empleado = new Empleado ();
		ResultSet resultSetAdminDao = null;
		Connection connection = null;
		Statement miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from usuarios where id_user= '"    +id_user  +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			if (resultSetAdminDao.next() == true) {
				empleado.setId_user(id_user);
				empleado.setUsername(resultSetAdminDao.getString("username"));
				empleado.setDni(resultSetAdminDao.getString("dni"));
				empleado.setNombre(resultSetAdminDao.getString("nombre"));
				System.out.println ("AdminDao.java, getEmpleado --se consigue el empleado. ");
			}else {
				System.out.println ("AdminDao.java, getEmpleado -- consulta incorrecta");
			}
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, getEmpleado --"+ex.getMessage());
		}
		return empleado;
	}
	
	public void insertaMarcaje (Marcaje marcaje) {
		System.out.println ("EmpleadoDao.java, insertaMarcaje -- se ejecuta");
		try {
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			preparedStatement = connection.prepareStatement("insert into marcajes (id, fecha, tipo_marcaje, id_usuario)"
					+ "values (?, ?, ?, ?);");
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, marcaje.getFecha()+"");
			preparedStatement.setString(3, marcaje.getTipo_marcaje());
			preparedStatement.setString(4, marcaje.getId_usuario()+"");
			preparedStatement.executeUpdate();
			System.out.println ("EmpleadoDao.java, insertaMarcaje -- se he introducido un marcaje");
		}catch (Exception ex) {
			System.out.println ("EmpleadoDao.java, insertaMarcaje --"+ex.getMessage());
		}
	}
	
	
	
	
	

}
