package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Oferta;


public class AlumnoDao {
    
    public AlumnoDao (){
        System.out.println("AlumnoDao.java -- se crea alumnoDAo");
    }
    
    public ResultSet identificarAlumno (String usuario, String contrasena) throws SQLException{
        ResultSet resultsetAlumnoDao = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil ();
        String sql =  "select * from alumno where usuario='" + usuario + "' and contrasena ='" + contrasena + "';";
        try{
            conection = cone.getConnection();
            st = conection.createStatement();
            resultsetAlumnoDao = st.executeQuery(sql);
            System.out.println("AlumnoDa.java --- se ha dientificado, con usuario: "+usuario);
            if (resultsetAlumnoDao.next() == true){
                System.out.println("AlumnoDao.java indentificarAlumno -- consulta correcta");
            }else{
                System.out.println("AlumnoDao.java indentificarAlumno  -- la consulta no se hizo");
                resultsetAlumnoDao = null;
            }
        }catch (Exception ex){
            System.out.println("AlumnoDa.java --ERROR -- No se ha idetificado");
        }
        return resultsetAlumnoDao;
    }
    
    public List<Oferta> getAllOferta (){
    	List<Oferta> listaOferta = new ArrayList <Oferta>();
    	ResultSet rs = null;
    	Connection conection = null;
    	Statement st = null;
    	DbUtil cone = new DbUtil();
    	String sql = "select * from oferta";
    	try {
    		conection = cone.getConnection();
    		st = conection.createStatement();
    		rs = st.executeQuery(sql);
    		while (rs.next()) {
    			Oferta oferta = new Oferta ();
    			oferta.setId(rs.getInt("id"));
    			oferta.setTitulo(rs.getString("titulo"));
    			oferta.setDescripcion(rs.getString("descripcion"));
    			oferta.setNumeroPlazas(rs.getInt("numPlazas"));
    			oferta.setHorario(rs.getString("horario"));
    			oferta.setDuracion(rs.getString("duracion"));
    			listaOferta.add(oferta);
    		}
    		System.out.println("AlunoDao.java  getAllOferta -- se ha creado la lista de ofertas: "+listaOferta.get(0).getId());
    	}catch (Exception ex) {
    		System.out.println("AlunoDao.java  getAllOferta -- no se lista las ofertas");
    	}
    	
    	return listaOferta;
    }
    
    public Alumno getAlumno (String usuario) {
    	Alumno alumno = new Alumno ();
    	ResultSet rs = null;
    	Connection conection = null;
    	Statement st = null;
    	DbUtil cone = new DbUtil();
    	String sql = "select * from alumno where usuario='" +usuario +"';";
    	try {
    		conection = cone.getConnection();
    		st = conection.createStatement();
    		rs = st.executeQuery(sql);
    		if (rs.next() == true) {
    			alumno.setNombre(rs.getString("nombre"));
    			alumno.setDni(rs.getString("dni"));
    			alumno.setNotaMedia(rs.getFloat("notaMedia"));
    			System.out.println("AlunoDao.java  getAlumno -- se ha conseguido la informacion del alumno");
    		}else {
    			System.out.println("AlunoDao.java  getAlumno -- error consulta incorrecta 1");
    		}
    	}catch (Exception ex) {
    		System.out.println("AlunoDao.java  getAlumno -- error consulta incorrecta 2");
    	}
    	
    	return alumno;
    }
}



