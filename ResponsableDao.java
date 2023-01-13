package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Responsable;


public class ResponsableDao {
    public ResponsableDao() {
        System.out.println("ResponsableDao.java -- se crea a RespnsableDao");
    }

    public ResultSet identificarResponsable(String usuario, String contrasena) {
        ResultSet resultSetResponsableDao = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil();
        String sql = "select * from responsable where usuario='" + usuario + "' and contrasena ='" + contrasena + "';";
        try {
            conection = cone.getConnection();
            st = conection.createStatement();
            resultSetResponsableDao = st.executeQuery(sql);
            if (resultSetResponsableDao.next() == true) {
                System.out.println("ResponsableDao.java indentificarAlumno -- consulta correcta");
            } else {
                resultSetResponsableDao = null;
            }
        } catch (Exception ex) {
            System.out.println("ResponsableDao.java --ERROR -- No se ha idetificado");
        }

        return resultSetResponsableDao;
    }
    
    public List<Empresa> getAllEmpresas() {
        List<Empresa> listaEmpresa = new ArrayList<Empresa>();
        ResultSet rs = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil();
        String sql = "select * from empresa";
        try{
            conection = cone.getConnection();
            st = conection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Empresa empresa = new Empresa ();
                empresa.setCif(rs.getString("cif"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setDescripcion(rs.getString("descripcion"));
                listaEmpresa.add(empresa);
            }
            System.out.println("ResponsableDao.java  getAllEmpresas -- se ha creado la lista de empresas: "+listaEmpresa.get(0).getCif());
        }catch (Exception ex){
            System.out.println("ResponsableDao.java getAllEmpresas --ERROR no se lista las empresas");
        }

        return listaEmpresa;
    }
    
    public Responsable getResponsable (String usuario) {
    	Responsable responsable = new Responsable ();
        ResultSet rs = null;
        Connection conection = null;
        Statement st = null;
        DbUtil cone = new DbUtil();
        String sql = "select * from responsable where usuario='" +usuario +"';";
        try {
        	conection = cone.getConnection();
        	st = conection.createStatement();
        	rs = st.executeQuery(sql);
        	if (rs.next() == true) {
        		responsable.setNombre(rs.getString("nombre"));
        		responsable.setDni(rs.getString("dni"));
        		//System.out.println ("ResponsableDao.java getResponsable -- este es el nombre:  "+rs.getString("nombre"));
        		System.out.println("ResponsableDao.java getResponsable -- se ha conseguido la info del respnsable");
        	}else {
        		System.out.println("ResponsableDao.java getResponsable -- error consulta incorrecta 1");
        	}
        }catch (Exception ex) {
        	System.out.println("ResponsableDao.java getResponsable -- error consulta incorrecta 2");
        }
    	
    	
    	return responsable;
    }


}
