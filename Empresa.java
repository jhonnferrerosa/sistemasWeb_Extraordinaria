package model;

public class Empresa {
    private String cif;
    private String nombre;
    private String descripcion;
    
    public Empresa (){
        cif = "000";
        nombre = " empresa sin nombre";
        descripcion = "empresa sin descripcion";
    }
    
    public String getCif (){
        return cif;
    }
    public String getNombre (){
        return nombre;
    }
    public String getDescripcion (){
        return descripcion;
    }
    
    public void setCif (String cif){
        this.cif = cif;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

}
