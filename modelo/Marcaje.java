package modelo;

import java.sql.Date;

public class Marcaje {
	private int id_marcaje;
	private Date fecha ;
	private String tipo_marcaje;
	private int id_usuario;
	
	public int getId_marcaje() {
		return id_marcaje;
	}
	public void setId_marcaje(int id_marcaje) {
		this.id_marcaje = id_marcaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo_marcaje() {
		return tipo_marcaje;
	}
	public void setTipo_marcaje(String tipo_marcaje) {
		this.tipo_marcaje = tipo_marcaje;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	

}
