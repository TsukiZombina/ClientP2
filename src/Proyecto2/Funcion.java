package Proyecto2;



import java.io.Serializable;

public class Funcion implements Serializable{
	
	private String nombre;
	private String recinto; //cine o teatro
	private String horaInicio;
	private String horaFin;
	private String costo;
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getRecinto() {
		return recinto;
	}



	public void setRecinto(String recinto) {
		this.recinto = recinto;
	}



	public String getHoraInicio() {
		return horaInicio;
	}



	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}



	public String getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}



	public String getCosto() {
		return costo;
	}



	public void setCosto(String costo) {
		this.costo = costo;
	}



	public Funcion(){}
	
}
