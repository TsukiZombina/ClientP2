package Proyecto2;



import java.io.Serializable;

public class Profesor implements Serializable{

	private String nombre;
	private String cubiculo;
	private String telefono;
	private String correo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCubiculo() {
		return cubiculo;
	}
	public void setCubiculo(String cubiculo) {
		this.cubiculo = cubiculo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Profesor(String nombre, String cubiculo, String telefono, String correo) {
		this.nombre = nombre;
		this.cubiculo = cubiculo;
		this.telefono = telefono;
		this.correo = correo;
	}
	
}

