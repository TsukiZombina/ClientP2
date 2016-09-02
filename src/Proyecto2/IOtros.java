

import java.util.ArrayList;

public interface IOtros extends java.rmi.Remote {
	
	/**
	 * Regresa la propina que hay que dar en un restaurante
	 *
	 * @param consumo El monto consumido
	 * @param porcentaje El porcentaje de propina que se dara 
	 * @return La propina que hay que dejar como flotante
	 */
	public float calcularPropina(float consumo, int porcentaje) throws java.rmi.RemoteException ;
	
	/**
	 * Regresa el precio de un producto con descuento
	 *
	 * @param precio El precio original
	 * @param descuento El descuento que tiene el producto
	 * @return Un Profesor con todos sus datos
	 */
	public float calcularDescuento(float precio, int descuento) throws java.rmi.RemoteException;
	
	/**
	 * Regresa el interes que hay que pagar determinado mes
	 *
	 * @param deuda El monto de la deuda actual
	 * @param pago El pago que se hara ese mes
	 * @param interes El interes a pagar
	 * @return El interes que se pagara
	 */
	public float calcularInteres(float deuda, float pago, float interes) throws java.rmi.RemoteException;

}
