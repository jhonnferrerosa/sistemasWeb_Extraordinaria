package modelo;

public class Proyecto {
	private int id_proyecto = 0;
	private String nombre = "";
	private int id_empresa = 0;
	
	public int getId_proyecto() {
		return id_proyecto;
	}
	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
}
