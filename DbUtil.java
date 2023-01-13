
/**


package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil {

    private static Connection connection = null;
    private static String saludo;
    
    public DbUtil (){
        saludo = "nada";
        System.out.println("+++ DbUtil.  creada bbdd +++ ");
        
    }
    
    public String saludaConexion (){
        return saludo;
    }
    
    public static Connection getConnection() {
        System.out.println("+++ dbUtil.java getConnection() +++");
        System.out.println("+++ hasta aqui funciona+++");
        String baseDatos = "ejemplouniversidad";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/ejemplouniversidad";
        String user = "root";
        String password = "";
        Log.logdb.info("Entramos a conectar con la BBDD");
        System.out.println("+++ hasta aqui funciona 1 +++");
        if (connection != null) {
            Log.logdb.info("Ya hay una conexion");
            System.out.println("+++ hasta aqui funciona 0 +++");
            return connection;
        } else {
            try {
                Log.logdb.info("Creamos una nueva conexion");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                saludo = "creamos una nueva conexion";
                Log.logdb.info("Finalizamos config db");
                System.out.println("+++ hasta aqui funciona 2 +++");
            } catch (ClassNotFoundException e) {
                Log.logdb.error("Error de conexion: " + e);
                System.out.println("+++ hasta aqui funciona 3 +++");
            } catch (SQLException e) {
                Log.logdb.error("Error de SQL: " + e);
                System.out.println("+++ hasta aqui funciona 4 +++");
            } catch (Exception e) {
                Log.logdb.error("Error general DB: " + e);
                System.out.println("+++ hasta aqui funciona 5 +++");
            }

            return connection;
        }
    }

}  **/

package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private String baseDatos;
    private String servidor;
    private String usuario;
    private String clave;
    private Connection connection;
    
    public DbUtil (){
        System.out.println("DbUtil.java -- se crea la clase");
        
        baseDatos = "gipex";
        servidor = "jdbc:mysql://localhost/" + baseDatos;
        usuario = "root";
        clave = "";
    }
    
    public Connection getConnection (){
        
        if (connection != null){
            System.out.println("DbUtil.java -- ya hay una conexion");
            return connection;
        }else{
            try{
                System.out.println("DbUtil.java -- se crea una conexion");
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(servidor, usuario, clave);
                System.out.println("DbUtil.java -- se HA creado la conexion");
            }catch (Exception ex){
                System.out.println("DbUtil.java -- error al conectar");
            }
            return connection;
        }
    }

}
