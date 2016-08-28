package clientep2;

import java.util.ArrayList;

public interface IEntretenimiento extends java.rmi.Remote {
	
	/**
	 * Regresa una lista con los cines y horarios en que pasa una pelicula
	 *
	 * @param codigoPelicula El codigo de la pelicula segun la base de datos 
	 * @return Una lista con las funciones por pelicula
	 */
	public ArrayList<Funcion> cinesYHorarios(int codigoPelicula) throws java.rmi.RemoteException ;
	
	/**
	 * Devuelve el horario en que funciona un museo
	 *
	 * @param codigoMuseo El codigo del museo segun la base de datos
	 * @return Una cadena de texto con el horario de servicio del museo
	 */
	public String horarioMuseo(int codigoMuseo) throws java.rmi.RemoteException;
	
	/**
	 * Regresa una lista con los teatros y costos de una obra
	 *
	 * @param codigoObra El codigo de la obra segun la base de datos 
	 * @return Una lista con las funciones (incluyendo costo)
	 */
	public ArrayList<Funcion> costoPorFuncion(int codigoObra) throws java.rmi.RemoteException;

}


