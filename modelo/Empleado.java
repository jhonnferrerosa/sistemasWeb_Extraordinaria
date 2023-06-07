package modelo;

import java.sql.Date;

public class Empleado {
	private int id_user = 0;
	private String username = "";
	private String passwrod = "";
	private String dni = "";
	private String nombre = "";
	private String apellidos = "";
	private Date fecha_baja = null;
	private Date feche_alta = null;

	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public Date getFeche_alta() {
		return feche_alta;
	}
	public void setFeche_alta(Date feche_alta) {
		this.feche_alta = feche_alta;
	}
}
