package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
	private ResultSet resultSetAdminDao = null;
	private Connection connection = null;
	private Statement miDeclaracion = null;
	
	
	
	public AdminDao () {
		System.out.println ("admin.dao -- se acaba de construir AdminDaoo");
	}
	public ResultSet identificarAdmin (String usuario, String contrasena, String tipo_usuario) throws SQLException{
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql =  "select * from usuarios where username='" + usuario + "' and password ='" + contrasena +"'and tipo_usuario='" +tipo_usuario  +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			if (resultSetAdminDao.next() == true) {
				System.out.println ("AdminDao.java, identificarAdmin -- consulta correcta"); 
			}else {
				System.out.println ("  AdminDao.java, identificarAdmin -- la consulta No se hizo");
				resultSetAdminDao = null;
			}
		}catch (Exception ex) {	
			System.out.println (" admin.dao, identificarAdmin -- error, no se ha identificado");
		}
		return resultSetAdminDao;
	}
	
	public Administrador getAdministrador (String usuario, String contrasena, String tipo_usuario) {
		Administrador administrador = new Administrador ();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql =  "select * from usuarios where username='" + usuario + "' and password ='" + contrasena +"'and tipo_usuario='" +tipo_usuario  +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			if (resultSetAdminDao.next() == true) {
				administrador.setId_user(resultSetAdminDao.getInt("id_user"));
				administrador.setUsername(resultSetAdminDao.getString("username"));
				administrador.setDni(resultSetAdminDao.getString("dni"));
				administrador.setNombre(resultSetAdminDao.getString("nombre"));
				System.out.println ("AdminDao.java getAdministrador -- se ha conseguido la info del administrador");
			}else {
				System.out.println ("AdminDao.java getAdministrador -- error consulta incorrecta 1.");
			}
			
		}catch (Exception ex) {
			System.out.println ("AdminDao.java getAdministrador --" +ex.getMessage());
		}
		return administrador;
	}
	public Administrador getAdministrador (int id_user) {
		Administrador administrador = new Administrador ();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql =  "select * from usuarios where id_user='" +id_user  +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			if (resultSetAdminDao.next() == true) {
				administrador.setId_user(resultSetAdminDao.getInt("id_user"));
				administrador.setUsername(resultSetAdminDao.getString("username"));
				administrador.setDni(resultSetAdminDao.getString("dni"));
				administrador.setNombre(resultSetAdminDao.getString("nombre"));
				System.out.println ("AdminDao.java getAdministrador -- se ha conseguido la info del administrador");
			}else {
				System.out.println ("AdminDao.java getAdministrador -- error consulta incorrecta 1.");
			}
			
		}catch (Exception ex) {
			System.out.println ("AdminDao.java getAdministrador --" +ex.getMessage());
		}
		return administrador;
	}
	
	
	
	public List <Empleado> getAllEmpleadosAsociados (){ //aqui van todos los usuarios que pertenezcan a el proyecto en el que estoy. SI ES QUE ESTOY EN UNO. 
		List <Empleado> listaEmpleadosAsociados = new ArrayList <>();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from usuarios";
		
		
		return listaEmpleadosAsociados;
	}
	
	public List <Empleado> getAllEmpleados (){
		List <Empleado> listaEmpleados = new ArrayList <>();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from usuarios";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			while (resultSetAdminDao.next()) {
				Empleado empleado = new Empleado ();
				empleado.setId_user(resultSetAdminDao.getInt("id_user"));
				empleado.setUsername(resultSetAdminDao.getString("username"));
				empleado.setDni(resultSetAdminDao.getString("dni"));
				listaEmpleados.add(empleado);
			}
			System.out.println ("AdminDao.java, getAllEmpleados -- se ha conseguido todos los empleados. ");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, getAllEmpleados -- "+ex.getMessage());
		}
		return listaEmpleados;
	}
	
	public List <Proyecto> getAllProyectos (){
		List <Proyecto> listaProyectos = new ArrayList <>();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from proyectos";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			while (resultSetAdminDao.next()) {
				Proyecto proyecto = new Proyecto ();
				proyecto.setId_proyecto(resultSetAdminDao.getInt("id_proyecto"));
				proyecto.setNombre(resultSetAdminDao.getString("nombre"));
				proyecto.setId_empresa(resultSetAdminDao.getInt("id_empresa"));
				listaProyectos.add(proyecto);
			}
			System.out.println ("AdminDao.java, getAllProyectos -- se tiene todos los proyectos");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, getAllProyectos -- "+ex.getMessage());
		}
		return listaProyectos;
	}
	
	public List <Empresa> getAllEmpresa (){
		List <Empresa> listaEmpresa = new ArrayList <>();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from empresa";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			while (resultSetAdminDao.next()) {
				Empresa empresa = new Empresa ();
				empresa.setId_empresa(resultSetAdminDao.getInt("id_empresa"));
				empresa.setNombre_empresa(resultSetAdminDao.getString("nombre_empresa"));
				listaEmpresa.add(empresa);
			}
			System.out.println ("AdminDao.java, getAllEmpresas -- se tiene todas las empresas");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, getAllEmpreasa -- "+ex.getMessage());
		}
		return listaEmpresa;
	}
	
	public void createEmpleado (Empleado empleado){	
		System.out.println ("AdminDao.java, createEmpleado -- se ejecuta ");
		try {
			// ya que en la clase de empleado no he guardado el tipo de usuario. creo esta variable, que es la que se va a meter en el SQL. 
			String tipo_usaurio = "U";
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into usuarios (id_user, username, password, dni, nombre, apellidos, fecha_alta,  tipo_usuario)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setString(1, empleado.getId_user()+"");
			preparedStatement.setString(2, empleado.getUsername());
			preparedStatement.setString(3, empleado.getPasswrod());
			preparedStatement.setString(4, empleado.getDni());
			preparedStatement.setString(5, empleado.getNombre());
			preparedStatement.setString(6, empleado.getApellidos());
			preparedStatement.setString(7, empleado.getFeche_alta()+"");
			preparedStatement.setString(8, tipo_usaurio);
			
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, createEmpleado --  se ha introducido un Empleado");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, createEmpleado -- "+ex.getMessage());
		}
	}
	
	public Empleado getEmpleado(int id_user) {
		System.out.println ("AdminDao.java, getEmpleado --se ejecuta");
		Empleado empleado = new Empleado ();
		resultSetAdminDao = null;
		connection = null;
		miDeclaracion = null;
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
	public void updateEmpleado (Empleado empleado) {
		System.out.println ("AdminDao.java, updateEmpleado --se ejecuta");
		try {
			// ya que en la clase de empleado no he guardado el tipo de usuario. creo esta variable, que es la que se va a meter en el SQL. 
			String tipo_usaurio = "U";
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("update usuarios set username=?, password=?, dni=?, nombre=?, tipo_usuario=?, apellidos=?, fecha_alta=?   where id_user=?");
			preparedStatement.setString(1, empleado.getUsername());
			preparedStatement.setString(2, empleado.getPasswrod());
			preparedStatement.setString(3, empleado.getDni());
			preparedStatement.setString(4, empleado.getNombre());
			preparedStatement.setString(5, tipo_usaurio);
			preparedStatement.setString(6, empleado.getApellidos());
			preparedStatement.setString(7, empleado.getFeche_alta()+"");
			preparedStatement.setString(8, empleado.getId_user()+"");
			
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, updateEmpleado --se ha modificado el empleado.");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, updateEmpleado --"+ex.getMessage());
		}
	}
	
	public void deleteEmpleado (int id_user) {
		System.out.println ("AdminDao.java, deleteEmpleado-- se ejecuta");
		try {
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("delete from usuarios where id_user=?");
			preparedStatement.setString (1, id_user+"");
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, deleteEmpleado -- se ha borrado un usuario");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, deleteEmpleado --"+ex.getMessage());
		}
	}
	
	public Empresa getEmpresa (int id_empresa) {
		System.out.println ("AdminDao.java, getEmpresa -- se ejecuta");
		Empresa empresa = new Empresa ();
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from empresa where id_empresa='" +id_empresa +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			if (resultSetAdminDao.next() == true) {
				empresa.setId_empresa(id_empresa);
				empresa.setNombre_empresa(resultSetAdminDao.getString("nombre_empresa"));
				System.out.println ("AdminDao.java, getEmpresa -- se consigue empresa. ");
			}else {
				System.out.println ("AdminDao.java, getEmpresa -- consulta incorrecta.  ");
			}
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, getEmpresa --"+ex.getMessage());
			
		}
		return empresa;
	}
	
	public void createEmpresa (Empresa empresa){	
		System.out.println ("AdminDao.java, createEmpresa -- se ejecuta ");
		try {
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into empresa (id_empresa, nombre_empresa)"
					+ "values (?, ?);");
			preparedStatement.setString(1, empresa.getId_empresa()+"");
			preparedStatement.setString(2, empresa.getNombre_empresa());
			
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, createEmpresa -- se he introducido una empresa");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, createEmpresa --"+ex.getMessage());
		}
	}
	public void updateEmpresa (Empresa empresa) {
		System.out.println ("AdminDao.java, updateEmpresa --se ejecuta");
		try {
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("update empresa set nombre_empresa=? where id_empresa=?");
			preparedStatement.setString(1, empresa.getNombre_empresa());
			preparedStatement.setString(2, empresa.getId_empresa()+"");
			
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, updateEmpresa -- actualizo empresa");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, updateEmpresa --"+ex.getMessage());
		}
	}
	public void deleteEmpresa (int id_empresa) {
		System.out.println ("AdminDao.java, deleteEmpresa-- se ejecuta");
		try {
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("delete from empresa where id_empresa=?");
			preparedStatement.setString (1, id_empresa+"");
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, deleteEmpresa-- se ha borrado empresa ");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, deleteEmpresa-- "+ex.getMessage());
		}
	}
	public Proyecto getProyecto (int id_proyecto) {
		System.out.println ("AdminDao.java, getProyecto -- se ejecuta");
		Proyecto proyecto = new Proyecto ();
		DbUtil miConexion = new DbUtil ();
		String sql = "select * from proyectos where id_proyecto='" +id_proyecto +"';";
		try {
			connection = miConexion.getConnection();
			miDeclaracion = connection.createStatement();
			resultSetAdminDao = miDeclaracion.executeQuery(sql);
			if (resultSetAdminDao.next() == true) {
				proyecto.setId_proyecto(id_proyecto);;
				proyecto.setNombre(resultSetAdminDao.getString("nombre"));
				proyecto.setId_empresa(Integer.valueOf(resultSetAdminDao.getString("id_empresa")));
				System.out.println ("AdminDao.java, getProyecto --se consigue el proyecto. ");
			}else {
				System.out.println ("AdminDao.java, getProyecto --consulta incorrecta.  ");
			}
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, getProyecto --"+ex.getMessage());
		}
		return proyecto;
	}
	
	
	public void createProyecto (Proyecto proyecto){	
		System.out.println ("AdminDao.java, createProyecto -- se ejecuta ");
		try {
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into proyectos (id_proyecto, nombre, id_empresa)"
					+ "values (?, ?, ?);");
			preparedStatement.setString(1, proyecto.getId_proyecto()+"");
			preparedStatement.setString(2, proyecto.getNombre());
			preparedStatement.setString(3, proyecto.getId_empresa()+"");
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, createProyecto -- se ha creado un proyecto. ");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, createProyecto -- "+ex.getMessage());
		}
	}
	public void updateProyecto (Proyecto proyecto) {
		System.out.println ("AdminDao.java, updateProyecto --se ejecuta");
		try {
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("update proyectos set id_proyecto=?, nombre=? where id_empresa=?");
			preparedStatement.setString(1, proyecto.getId_proyecto()+"");
			preparedStatement.setString(2, proyecto.getNombre());
			preparedStatement.setString(3, proyecto.getId_empresa()+"");
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, updateEmpresa -- actualizo empresa");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, updateEmpresa --"+ex.getMessage());
		}
	}
	
	public void deleteProyecto (int id_proyecto) {
		System.out.println ("AdminDao.java, deleteProyecto-- se ejecuta");
		try {
			connection = null;
			DbUtil miConexion = new DbUtil ();
			connection = miConexion.getConnection();
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("delete from proyectos where id_proyecto=?");
			preparedStatement.setString (1, id_proyecto+"");
			preparedStatement.executeUpdate();
			System.out.println ("AdminDao.java, deleteProyecto--  se ha borrado empresa ");
		}catch (Exception ex) {
			System.out.println ("AdminDao.java, deleteProyecto--  "+ex.getMessage());
		}
	}
	
	
}