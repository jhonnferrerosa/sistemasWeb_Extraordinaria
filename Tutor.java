package model;

public class Tutor {
	private String usuario;
	private String contrasena = "";
	private String nombre;
	private String apellido = "";
	private String dni;
	private String correo = "";
	private String empresa_cif;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEmpresa_cif() {
		return empresa_cif;
	}
	public void setEmpresa_cif(String empresa_cif) {
		this.empresa_cif = empresa_cif;
	}

}
