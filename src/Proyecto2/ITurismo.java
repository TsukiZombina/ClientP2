package Proyecto2;



import java.util.TimeZone;

public interface ITurismo extends java.rmi.Remote {
	
	/**
	 * Convierte divisas de dos paises
	 *
	 * @param codigoDivisa1 El codigo de la divisa de la que se va a convertir, este codigo corresponde al id de la 
	 * base de datos
	 * @param cantidad La cantidad a convertir
	 * @param El codigo de la divisa a la que se va a convertir
	 * @return La cantidad convertida
	 */
	public double convertirDivisa(int codigoDivisa1, double cantidad, int codigoDivisa2) throws java.rmi.RemoteException ;
	
	/**
	 * Devuelve el clima en grados celsius de una ciudad
	 *
	 * @param codigoCiudad El codigo de la ciudad segun el id en la base de datos
	 * @return El clima en celsisus
	 */
	public double getClima(int codigoCiudad) throws java.rmi.RemoteException;
	
	/**
	 * Devuelve la zona horaria de una ciudad en un objeto TimeZone que contiene junto a Calendar, contiene
	 *la hora y la fecha actual
	 *
	 * @param codigoCiudad El codigo de la ciudad segun el id en la base de datos
	 * @return La zona horaria de una ciudad
	 */
	public TimeZone getHoraExacta(int codigoCiudad) throws java.rmi.RemoteException;

}
