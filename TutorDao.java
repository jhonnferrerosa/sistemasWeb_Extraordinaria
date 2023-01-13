package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Tutor;


public class TutorDao {

    public TutorDao() {
        System.out.println("TutorDao.java -- se crea a TutorDao");
    }

    public ResultSet identificarTutor(String usuario, String contrasena) {
        ResultSet resultSetResponsableDao = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil();
        String sql = "select * from tutor where usuario='" + usuario + "' and contrasena ='" + contrasena + "';";
        try {
            conection = cone.getConnection();
            st = conection.createStatement();
            resultSetResponsableDao = st.executeQuery(sql);
            if (resultSetResponsableDao.next() == true) {
                System.out.println("TutorDao.java indentificarAlumno -- consulta correcta");
            } else {
                resultSetResponsableDao = null;
            }
        } catch (Exception ex) {
            System.out.println("TutorDao.java --ERROR -- No se ha idetificado");
        }

        return resultSetResponsableDao;
    }
    
    public List<Alumno> getAllAlumno (String usuario){
    	List <Alumno> listaAlumno = new ArrayList <Alumno>();
        ResultSet rs = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil();
        String sql = "SELECT * FROM alumno INNER JOIN informe on alumno.usuario = informe.alumno_usuario where tutor_usuario ='" +usuario +"';";
        try {
            conection = cone.getConnection();
            st = conection.createStatement();
            rs = st.executeQuery(sql);
        	while (rs.next()) {
            	Alumno alumno = new Alumno ();
            	alumno.setUsuario(rs.getString("usuario"));
            	alumno.setNombre(rs.getString("nombre"));
            	alumno.setApellido(rs.getString("apellido"));
            	alumno.setDni(rs.getString("dni"));
            	alumno.setCorreo(rs.getString("correo"));
            	alumno.setNotaMedia(rs.getFloat("notaMedia"));
            	alumno.setCarrera(rs.getString("carrera"));
            	listaAlumno.add(alumno);
        	}
        	System.out.println("TutorDao.java getAllAlumno --  se ha creado la lista de alumnos");
        }catch (Exception ex) {
        	System.out.println("TutorDao.java getAllAlumno -- error no se lista los alumnos");
        }
    	return listaAlumno;
    }
    
    public Tutor getTutor (String usuario) {
    	Tutor tutor = new Tutor ();
        ResultSet rs = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil();
        String sql = "select * from tutor where usuario='" +usuario +"';";
        try {
        	conection = cone.getConnection();
        	st = conection.createStatement();
        	rs = st.executeQuery(sql);
        	if (rs.next() == true) {
        		tutor.setNombre(rs.getString("nombre"));
        		tutor.setDni(rs.getString("dni"));
        		tutor.setEmpresa_cif(rs.getString("empresa_cif"));
        		System.out.println("TutorDao.java getTutor -- se ha conseguido la info del tutor");
        	}else {
        		System.out.println("TutorDao.java getTutor -- consulta incorrecta 1");
        	}
        }catch (Exception ex) {
        	System.out.println("TutorDao.java getTutor -- consulta incorrecta 2");
        }
    	return tutor;
    }


}
