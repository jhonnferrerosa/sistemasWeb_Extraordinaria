package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String baseDatos;
	private String servidor;
	private String usuario;
	private String clave;
	private Connection connection;
	
	public DbUtil () {  
		baseDatos = "rrhh";
		servidor = "jdbc:mysql://localhost/" + baseDatos;
		usuario = "root";
		clave = "";
	}
	//este es un metodo. 
	public Connection getConnection () {
		if (connection != null) {
			System.out.println ("dBUtil.java, getConnection -- ya hay una conexion");
		}else {
			try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(servidor, usuario, clave);
			}catch (Exception ex){
				System.out.println ("dBUtil.java, getConnection -- ha ocurrido un error al crear la conexion");
			}
		}
		return connection;
	}
}