package Proyecto2;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class Client {

	public static void main(String[] args) {
		
		
		//Turismo
		ITurismo turismo;
		try {
			turismo = (ITurismo)Naming.lookup("rmi://localhost:1099/Turismo");
			System.out.println("5 dolares a pesos es: " + turismo.convertirDivisa(1, 5, 2) + " pesos");
			System.out.println("El clima en Paris es : " + turismo.getClima(1) + " grados");
			System.out.println("La hora aqu� es : " + Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
			TimeZone tz = turismo.getHoraExacta(1);
			Calendar c = Calendar.getInstance(tz);
			System.out.println("La hora en paris es : " + c.get(Calendar.HOUR_OF_DAY));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		IGeografico geografico;
		try {
			geografico = (IGeografico)Naming.lookup("rmi://localhost:1099/Geografico");
			System.out.println("La localizacion de la biblioteca es: " + geografico.ubicacionDe("Biblioteca"));
			Profesor prof = geografico.getDatosProfesor("Alejandro");
			System.out.println(prof.getNombre() + ", " + prof.getCubiculo() + ", " + prof.getCorreo() + ", " + prof.getTelefono());
			ArrayList<String> materias = geografico.materiasImpartidas("Alejandro");
			System.out.println(materias);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		IEntretenimiento entretenimiento;
		try {
			entretenimiento = (IEntretenimiento)Naming.lookup("rmi://localhost:1099/Entretenimiento");
			ArrayList<Funcion> funciones = entretenimiento.cinesYHorarios(1);
			System.out.println(funciones.get(0).getRecinto() + " " + funciones.get(1).getHoraInicio());
			System.out.println(entretenimiento.horarioMuseo(1));
			funciones = entretenimiento.costoPorFuncion(1);
			System.out.println(funciones.get(0).getRecinto() + " " + funciones.get(1).getCosto());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		IOtros otros;
		try {
			otros = (IOtros)Naming.lookup("rmi://localhost:1099/Otros");
			System.out.println("100 despues del decuento de 10% es: " + otros.calcularDescuento(100, 10));
			System.out.println("20% de propina por consumo de 30 es: " + otros.calcularPropina(30, 20));
			System.out.println("Deuda: 50, pago: 10, interes:10, resultado: " + otros.calcularInteres(50, 10, 10));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}